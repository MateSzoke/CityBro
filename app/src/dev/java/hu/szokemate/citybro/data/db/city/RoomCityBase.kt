package hu.szokemate.citybro.data.db.city

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "city_base")
data class RoomCityBase(
    @PrimaryKey
    val id: UUID,
    val urbanAreaId: String,
    val name: String,
    val imgUrl: String,
    val isFavorite: Boolean
)