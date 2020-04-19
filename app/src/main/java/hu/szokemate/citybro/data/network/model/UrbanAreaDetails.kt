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
    val type: String,
    val label: String,
    @Json(name = "currency_dollar_value")
    val currencyDollarValue: Double? = null,
    @Json(name = "float_value")
    val doubleValue: Double? = null,
    @Json(name = "int_value")
    val intValue: Int? = null,
    @Json(name = "percent_value")
    val percentValue: Double? = null,
    @Json(name = "string_value")
    val stringValue: String? = null,
    @Json(name = "url_value")
    val urlValue: String? = null
)