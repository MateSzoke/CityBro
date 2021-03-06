package hu.szokemate.citybro.data.db.converters

import androidx.room.TypeConverter
import java.util.*

class CommonConverters {

    @TypeConverter
    fun uuidToString(value: UUID?): String? {
        return value?.toString()
    }

    @TypeConverter
    fun stringToUuid(value: String?): UUID? {
        value ?: return null
        return UUID.fromString(value)
    }
}