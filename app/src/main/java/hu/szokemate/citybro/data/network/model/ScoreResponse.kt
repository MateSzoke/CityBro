package hu.szokemate.citybro.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ScoreResponse(
    val categories: List<Score>,
    val summary: String
)

@JsonClass(generateAdapter = true)
data class Score(
    val color: String,
    val name: String,
    @Json(name = "score_out_of_10")
    val value: Double
)