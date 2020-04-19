package hu.szokemate.citybro.domain.model

import java.util.*

data class CityBase(
    val id: UUID,
    val urbanAreaId: String,
    val name: String,
    val imgUrl: String,
    val isFavorite: Boolean
)