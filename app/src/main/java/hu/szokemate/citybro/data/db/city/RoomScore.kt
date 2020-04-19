package hu.szokemate.citybro.data.db.city

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "score",
    foreignKeys = [

        ForeignKey(
            entity = RoomCityDetails::class,
            parentColumns = ["id"],
            childColumns = ["scoreDataId"],
            onDelete = ForeignKey.NO_ACTION
        )
    ],
    indices = [
        Index("scoreDataId")
    ]
)
data class RoomScore(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val scoreDataId: Long,
    val color: String,
    val name: String,
    val value: Double
)