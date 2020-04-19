package hu.szokemate.citybro.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UrbanAreaDetails(
    val categories: List<UrbanAreaDetailCategory>
)

@JsonClass(generateAdapter = true)
data class UrbanAreaDetailCategory(
    val id: String,
    val label: String,
    val data: List<UrbanAreaDetailDataPoint>
)

@JsonClass(generateAdapter = true)
data class UrbanAreaDetailDataPoint(
    val id: String,
    @Json(name = "currency_dollar_value")
    val currencyDollarValue: Double,
    @Json(name = "float_value")
    val doubleValue: Double,
    @Json(name = "int_value")
    val intValue: Int,
    val label: String,
    @Json(name = "percent_value")
    val percentValue: Double,
    @Json(name = "string_value")
    val stringValue: String,
    val type: String,
    @Json(name = "url_value")
    val urlValue: String
)