// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.test_inline

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object GetPage_ResponseAdapter : ResponseAdapter<GetPage.Data> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forObject("collection", "collection", null, false, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): GetPage.Data {
    return reader.run {
      var collection: GetPage.Collection? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> collection = readObject<GetPage.Collection>(RESPONSE_FIELDS[0]) { reader ->
            GetPage_ResponseAdapter.Collection_ResponseAdapter.fromResponse(reader)
          }
          else -> break
        }
      }
      GetPage.Data(
        collection = collection!!
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: GetPage.Data) {
    writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
      GetPage_ResponseAdapter.Collection_ResponseAdapter.toResponse(writer, value.collection)
    }
  }

  object ParticularItemItem_ResponseAdapter : ResponseAdapter<GetPage.ParticularItemItem> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("image", "image", null, false, null),
      ResponseField.forString("title", "title", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        GetPage.ParticularItemItem {
      return reader.run {
        var __typename: String? = __typename
        var image: String? = null
        var title: String? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> image = readString(RESPONSE_FIELDS[1])
            2 -> title = readString(RESPONSE_FIELDS[2])
            else -> break
          }
        }
        GetPage.ParticularItemItem(
          __typename = __typename!!,
          image = image!!,
          title = title!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: GetPage.ParticularItemItem) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.image)
      writer.writeString(RESPONSE_FIELDS[2], value.title)
    }
  }

  object OtherItem_ResponseAdapter : ResponseAdapter<GetPage.OtherItem> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("title", "title", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): GetPage.OtherItem {
      return reader.run {
        var __typename: String? = __typename
        var title: String? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> title = readString(RESPONSE_FIELDS[1])
            else -> break
          }
        }
        GetPage.OtherItem(
          __typename = __typename!!,
          title = title!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: GetPage.OtherItem) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.title)
    }
  }

  object Item_ResponseAdapter : ResponseAdapter<GetPage.Item> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("title", "title", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): GetPage.Item {
      val typename = __typename ?: reader.readString(RESPONSE_FIELDS[0])
      return when(typename) {
        "ParticularItem" -> GetPage_ResponseAdapter.ParticularItemItem_ResponseAdapter.fromResponse(reader, typename)
        else -> GetPage_ResponseAdapter.OtherItem_ResponseAdapter.fromResponse(reader, typename)
      }
    }

    override fun toResponse(writer: ResponseWriter, value: GetPage.Item) {
      when(value) {
        is GetPage.ParticularItemItem -> GetPage_ResponseAdapter.ParticularItemItem_ResponseAdapter.toResponse(writer, value)
        is GetPage.OtherItem -> GetPage_ResponseAdapter.OtherItem_ResponseAdapter.toResponse(writer, value)
      }
    }
  }

  object ParticularCollectionCollection_ResponseAdapter :
      ResponseAdapter<GetPage.ParticularCollectionCollection> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forList("items", "items", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        GetPage.ParticularCollectionCollection {
      return reader.run {
        var __typename: String? = __typename
        var items: List<GetPage.Item>? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> items = readList<GetPage.Item>(RESPONSE_FIELDS[1]) { reader ->
              reader.readObject<GetPage.Item> { reader ->
                GetPage_ResponseAdapter.Item_ResponseAdapter.fromResponse(reader)
              }
            }?.map { it!! }
            else -> break
          }
        }
        GetPage.ParticularCollectionCollection(
          __typename = __typename!!,
          items = items!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: GetPage.ParticularCollectionCollection) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeList(RESPONSE_FIELDS[1], value.items) { values, listItemWriter ->
        values?.forEach { value ->
          listItemWriter.writeObject { writer ->
            GetPage_ResponseAdapter.Item_ResponseAdapter.toResponse(writer, value)
          }
        }
      }
    }
  }

  object Item1_ResponseAdapter : ResponseAdapter<GetPage.Item1> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("title", "title", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): GetPage.Item1 {
      return reader.run {
        var __typename: String? = __typename
        var title: String? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> title = readString(RESPONSE_FIELDS[1])
            else -> break
          }
        }
        GetPage.Item1(
          __typename = __typename!!,
          title = title!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: GetPage.Item1) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.title)
    }
  }

  object OtherCollection_ResponseAdapter : ResponseAdapter<GetPage.OtherCollection> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forList("items", "items", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        GetPage.OtherCollection {
      return reader.run {
        var __typename: String? = __typename
        var items: List<GetPage.Item1>? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> items = readList<GetPage.Item1>(RESPONSE_FIELDS[1]) { reader ->
              reader.readObject<GetPage.Item1> { reader ->
                GetPage_ResponseAdapter.Item1_ResponseAdapter.fromResponse(reader)
              }
            }?.map { it!! }
            else -> break
          }
        }
        GetPage.OtherCollection(
          __typename = __typename!!,
          items = items!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: GetPage.OtherCollection) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeList(RESPONSE_FIELDS[1], value.items) { values, listItemWriter ->
        values?.forEach { value ->
          listItemWriter.writeObject { writer ->
            GetPage_ResponseAdapter.Item1_ResponseAdapter.toResponse(writer, value)
          }
        }
      }
    }
  }

  object Collection_ResponseAdapter : ResponseAdapter<GetPage.Collection> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forList("items", "items", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): GetPage.Collection {
      val typename = __typename ?: reader.readString(RESPONSE_FIELDS[0])
      return when(typename) {
        "ParticularCollection" -> GetPage_ResponseAdapter.ParticularCollectionCollection_ResponseAdapter.fromResponse(reader, typename)
        else -> GetPage_ResponseAdapter.OtherCollection_ResponseAdapter.fromResponse(reader, typename)
      }
    }

    override fun toResponse(writer: ResponseWriter, value: GetPage.Collection) {
      when(value) {
        is GetPage.ParticularCollectionCollection -> GetPage_ResponseAdapter.ParticularCollectionCollection_ResponseAdapter.toResponse(writer, value)
        is GetPage.OtherCollection -> GetPage_ResponseAdapter.OtherCollection_ResponseAdapter.toResponse(writer, value)
      }
    }
  }
}
