package hu.szokemate.citybro.domain.model

data class CityBase(
    val id: Long,
    val name: String,
    val imgUrl: String,
    val isFavorite: Boolean
)