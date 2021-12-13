package com.apollographql.apollo3.api.json

import com.apollographql.apollo3.annotations.ApolloInternal
import com.apollographql.apollo3.api.Upload

/**
 * A [JsonWriter] that writes data to a [Map<String, Any?>]
 *
 * Call [beginObject], [name], [value], etc... like for regular Json writing. Once you're done, get the result in [root]
 *
 * The returned [Map] will contain values of the following types:
 * - String
 * - Int
 * - Double
 * - Long
 * - JsonNumber
 * - null
 * - Map<String, Any?> where values are any of these values recursively
 * - List<Any?> where values are any of these values recursively
 *
 * To write to a [okio.BufferedSink], see also [BufferedSinkJsonWriter]
 */
@OptIn(ApolloInternal::class)
class MapJsonWriter : JsonWriter {
  sealed class State {
    class List(val list: MutableList<Any?>) : State()
    class Map(val map: MutableMap<String, Any?>, var name: String?) : State()
  }

  private var root: Any? = null
  private var rootSet = false

  private val stack = mutableListOf<State>()

  /**
   * Return the resulting representation of the Json as a Kotlin type. Most of the times, it will be a [Map]<String, Any?> but
   * [MapJsonWriter] also support writing lists and scalars at the root of the json
   */
  fun root(): Any? {
    check(rootSet)
    return root
  }

  override fun beginArray(): JsonWriter = apply {
    val list = mutableListOf<Any?>()
    valueInternal(list)
    stack.add(State.List(list))
  }

  override fun endArray(): JsonWriter = apply {
    val state = stack.removeAt(stack.size - 1)

    check(state is State.List)
  }

  override fun beginObject(): JsonWriter = apply {
    val map = if (stack.isEmpty()) {
      mutableMapOf<String, Any?>()
    } else {
      val state = stack[stack.size - 1]
      when (state) {
        is State.List -> mutableMapOf<String, Any?>()
        is State.Map -> {
          val existingValue = state.map.get(state.name)
          if (existingValue == null) {
            mutableMapOf<String, Any?>()
          } else {
            // The stream rewinded. This happens with fragments as interface
            check(existingValue is MutableMap<*, *>) {
              "Trying to overwrite a non-object value with an object at $path: $existingValue"
            }
            @Suppress("UNCHECKED_CAST")
            existingValue as MutableMap<String, Any?>
          }
        }
      }
    }

    valueInternal(map)

    stack.add(State.Map(map, null))
  }

  override fun endObject(): JsonWriter = apply {
    val state = stack.removeAt(stack.size - 1)

    check(state is State.Map)
  }

  override fun name(name: String): JsonWriter = apply {
    val state = stack.last()

    check(state is State.Map)
    check(state.name == null)

    state.name = name
  }

  private fun <T> valueInternal(value: T?) = apply {
    when (val state = stack.lastOrNull()) {
      is State.Map -> {
        check(state.name != null)
        state.map[state.name!!] = value
        state.name = null
      }
      is State.List -> {
        state.list.add(value)
      }
      else -> {
        root = value
        rootSet = true
      }
    }
  }

  override val path: String
    get() {
      return stack.map {
        when(it) {
          is State.List -> it.list.size.toString()
          is State.Map -> it.name ?: "?" // if we don't know the name display '?' for now
        }
      }.joinToString(".")
    }
  override fun value(value: String) = valueInternal(value)

  override fun value(value: Boolean) = valueInternal(value)

  override fun value(value: Double) = valueInternal(value)

  override fun value(value: Int) = valueInternal(value)

  override fun value(value: Long) = valueInternal(value)

  override fun value(value: JsonNumber) = valueInternal(value)

  override fun value(value: Upload) = valueInternal(null)

  override fun nullValue() = valueInternal(null)

  override fun close() {
  }

  override fun flush() {
  }
}