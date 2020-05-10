package hu.szokemate.citybro.data.network.mapping

import hu.szokemate.citybro.data.network.model.NetworkCityResult
import hu.szokemate.citybro.data.network.model.NetworkScore
import hu.szokemate.citybro.data.network.model.NetworkScoreResponse
import hu.szokemate.citybro.domain.model.CityBase
import hu.szokemate.citybro.domain.model.Score
import hu.szokemate.citybro.domain.model.ScoreData
import java.util.*

fun NetworkCityResult.toDomainModel(urbanAreaId: String, imgUrl: String): CityBase {
    return CityBase(
        id = UUID.randomUUID(),
        urbanAreaId = urbanAreaId,
        name = name,
        isFavorite = false,
        imgUrl = imgUrl
    )
}

fun NetworkScoreResponse.toDomainModel(): ScoreData {
    return ScoreData(
        categories = categories.map { it.toDomainModel() },
        summary = summary
    )
}

fun NetworkScore.toDomainModel(): Score {
    return Score(
        color = color,
        name = name,
        value = value
    )
}