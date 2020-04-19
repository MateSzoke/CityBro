package hu.szokemate.citybro.data.db.city

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "city_details")
data class RoomCityDetails(
    @PrimaryKey
    val id: UUID,
    val urbanAreaId: String,
    val fullName: String,
    val imgUrl: String,
    val population: Int,
    val mayor: String,
    val latitude: Double,
    val longitude: Double,
    val currency: String?
)