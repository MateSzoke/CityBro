package hu.szokemate.citybro.data.db.city

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city_base")
data class RoomCityBase(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val imgUrl: String,
    val isFavorite: Boolean
)