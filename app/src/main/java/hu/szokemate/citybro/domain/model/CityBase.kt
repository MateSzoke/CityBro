package hu.szokemate.citybro.domain.model

data class CityBase(
    val id: Long? = null,
    val urbanAreaId: String,
    val name: String,
    val imgUrl: String,
    val isFavorite: Boolean
)