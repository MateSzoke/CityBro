package hu.szokemate.citybro.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class NetworkCityResult(
    val name: String,
    val population: Int,
    val location: NetworkLocation,
    @Json(name = "geoname_id")
    val geoNameId: Int,
    @Json(name = "full_name")
    val fullName: String,
    @Json(name = "_links")
    val links: NetworkLinks
)

@JsonClass(generateAdapter = true)
class NetworkLocation(
    val geohash: String,
    val latlon: NetworkLatLon
)

@JsonClass(generateAdapter = true)
class NetworkLatLon(
    val latitude: Double,
    val longitude: Double
)

@JsonClass(generateAdapter = true)
class NetworkLinks(
    @Json(name = "city:urban_area")
    val urbanAreaLink: NetworkLinkHref?
)

@JsonClass(generateAdapter = true)
class NetworkLinkHref(
    val href: String,
    val name: String
)