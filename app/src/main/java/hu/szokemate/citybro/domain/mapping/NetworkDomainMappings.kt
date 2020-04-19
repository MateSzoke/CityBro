package hu.szokemate.citybro.domain.mapping

import hu.szokemate.citybro.data.network.model.CityResult
import hu.szokemate.citybro.data.network.model.ScoreResponse
import hu.szokemate.citybro.domain.model.CityBase
import hu.szokemate.citybro.domain.model.Score
import hu.szokemate.citybro.domain.model.ScoreData
import java.util.*
import hu.szokemate.citybro.data.network.model.Score as NetworkScore

fun CityResult.toDomainModel(urbanAreaId: String, imgUrl: String): CityBase {
    return CityBase(
        id = UUID.randomUUID(),
        urbanAreaId = urbanAreaId,
        name = name,
        isFavorite = false,
        imgUrl = imgUrl
    )
}

fun ScoreResponse.toDomainModel(): ScoreData {
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