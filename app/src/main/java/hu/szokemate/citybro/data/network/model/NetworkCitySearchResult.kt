package hu.szokemate.citybro.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class NetworkCitySearchResult(
    val count: Int,
    @Json(name = "_embedded")
    val result: NetworkEmbeddedCityResult
)

@JsonClass(generateAdapter = true)
class NetworkEmbeddedCityResult(
    @Json(name = "city:search-results")
    val searchResults: List<NetworkSearchResult>
)

@JsonClass(generateAdapter = true)
class NetworkSearchResult(
    @Json(name = "_links")
    val links: NetworkLink,
    @Json(name = "matching_alternate_names")
    val alternativeNames: List<NetworkAlternativeName>,
    @Json(name = "matching_full_name")
    val fullName: String
)

@JsonClass(generateAdapter = true)
class NetworkLink(
    @Json(name = "city:item")
    val cityItem: NetworkHref
)

@JsonClass(generateAdapter = true)
class NetworkHref(
    val href: String
)

@JsonClass(generateAdapter = true)
class NetworkAlternativeName(
    val name: String
)

@JsonClass(generateAdapter = true)
class NetworkLink2(
    val curies: List<NetworkCurie>,
    val self: NetworkHref
)

@JsonClass(generateAdapter = true)
class NetworkCurie(
    val href: String,
    val name: String,
    val templated: Boolean
)