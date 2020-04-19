package hu.szokemate.citybro.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UrbanArea(
    @Json(name = "full_name")
    val fullName: String,
    val name: String,
    val mayor: String
)

