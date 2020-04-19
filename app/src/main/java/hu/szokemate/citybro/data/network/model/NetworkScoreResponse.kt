package hu.szokemate.citybro.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class NetworkScoreResponse(
    val categories: List<NetworkScore>,
    val summary: String
)

@JsonClass(generateAdapter = true)
class NetworkScore(
    val color: String,
    val name: String,
    @Json(name = "score_out_of_10")
    val value: Double
)