package hu.szokemate.citybro.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CitySearchResult(
    val count: Int,
    @Json(name = "_embedded")
    val result: EmbeddedCityResult
)

@JsonClass(generateAdapter = true)
data class EmbeddedCityResult(
    @Json(name = "city:search-results")
    val searchResults: List<SearchResult>
)

@JsonClass(generateAdapter = true)
data class SearchResult(
    @Json(name = "_links")
    val links: Link,
    @Json(name = "matching_alternate_names")
    val alternativeNames: List<AlternativeName>,
    @Json(name = "matching_full_name")
    val fullName: String
)

@JsonClass(generateAdapter = true)
data class Link(
    @Json(name = "city:item")
    val cityItem: Href
)

@JsonClass(generateAdapter = true)
data class Href(
    val href: String
)

@JsonClass(generateAdapter = true)
data class AlternativeName(
    val name: String
)

@JsonClass(generateAdapter = true)
data class Link2(
    val curies: List<Curie>,
    val self: Href
)

@JsonClass(generateAdapter = true)
data class Curie(
    val href: String,
    val name: String,
    val templated: Boolean
)