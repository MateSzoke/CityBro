package hu.szokemate.citybro.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkUrbanAreaImages(
    val photos: List<Photo>
)

@JsonClass(generateAdapter = true)
data class Photo(
    val image: NetworkImage
)

@JsonClass(generateAdapter = true)
data class NetworkImage(
    val mobile: String,
    val web: String
)