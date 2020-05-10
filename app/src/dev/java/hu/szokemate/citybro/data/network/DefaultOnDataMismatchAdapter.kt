package hu.szokemate.citybro.data.network

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import java.lang.reflect.Type

class DefaultOnDataMismatchAdapter<T> private constructor(
    private val delegate: JsonAdapter<T>,
    private val defaultValue: T?
) : JsonAdapter<T>() {

    override fun fromJson(reader: JsonReader): T? {
        return try {
            delegate.fromJsonValue(reader.readJsonValue())
        } catch (e: Exception) {
            defaultValue
        }
    }

    override fun toJson(writer: JsonWriter, value: T?) {
        delegate.toJson(writer, value)
    }

    companion object {
        @JvmStatic
        fun <T> newFactory(type: Class<T>, defaultValue: T?): JsonAdapter.Factory {
            return object : JsonAdapter.Factory {
                override fun create(
                    requestedType: Type,
                    annotations: Set<Annotation>,
                    moshi: Moshi
                ): JsonAdapter<*>? {
                    if (type != requestedType) {
                        return null
                    }
                    val delegate = moshi.nextAdapter<T>(this, type, annotations)
                    return DefaultOnDataMismatchAdapter(delegate, defaultValue)
                }
            }
        }
    }
}