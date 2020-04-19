package hu.szokemate.citybro.data.db.city

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.*

@Entity(
    tableName = "score_data",
    foreignKeys = [

        ForeignKey(
            entity = RoomCityDetails::class,
            parentColumns = ["id"],
            childColumns = ["cityDetailsId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index("cityDetailsId")
    ]
)
data class RoomScoreData(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val summary: String,
    val cityDetailsId: UUID
)