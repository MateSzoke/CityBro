package hu.szokemate.citybro.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UrbanArea(
    @Json(name = "full_name")
    val fullName: String,
    val name: String,
    val mayor: String,
    @Json(name = "_links")
    val links: UrbanLink
)

@JsonClass(generateAdapter = true)
data class UrbanLink(
    val country: LinkHref
)