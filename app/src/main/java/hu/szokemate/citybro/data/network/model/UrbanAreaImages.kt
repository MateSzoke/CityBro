package hu.szokemate.citybro.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UrbanAreaImages(
    val photos: List<Photo>
)

@JsonClass(generateAdapter = true)
data class Photo(
    val image: Image
)

@JsonClass(generateAdapter = true)
data class Image(
    val mobile: String,
    val web: String
)