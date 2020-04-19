package hu.szokemate.citybro.domain.model

import java.util.*

data class CityDetails(
    val id: UUID,
    val urbanAreaId: String,
    val fullName: String,
    val imgUrls: List<String>,
    val isFavorite: Boolean,
    val population: Int,
    val mayor: String,
    val latitude: Double,
    val longitude: Double,
    val currency: String?,
    val scores: ScoreData
)