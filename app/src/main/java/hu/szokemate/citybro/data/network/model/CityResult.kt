package hu.szokemate.citybro.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CityResult(
    val name: String,
    val population: Int,
    val location: Location,
    @Json(name = "geoname_id")
    val geoNameId: Int,
    @Json(name = "full_name")
    val fullName: String,
    @Json(name = "_links")
    val links: Links
)

@JsonClass(generateAdapter = true)
data class Location(
    val geohash: String,
    val latlon: LatLon
)

@JsonClass(generateAdapter = true)
data class LatLon(
    val latitude: Double,
    val longitude: Double
)

@JsonClass(generateAdapter = true)
data class Links(
    @Json(name = "city:urban_area")
    val urbanAreaLink: LinkHref?
)

@JsonClass(generateAdapter = true)
data class LinkHref(
    val href: String,
    val name: String
)