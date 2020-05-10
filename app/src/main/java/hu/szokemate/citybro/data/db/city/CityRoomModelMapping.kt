package hu.szokemate.citybro.data.db.city

import hu.szokemate.citybro.domain.model.CityBase
import hu.szokemate.citybro.domain.model.CityDetails
import hu.szokemate.citybro.domain.model.Score
import hu.szokemate.citybro.domain.model.ScoreData
import java.util.*

fun RoomCityBase.toDomainModel(): CityBase {
    return CityBase(
        id = id,
        urbanAreaId = urbanAreaId,
        name = name,
        imgUrl = imgUrl,
        isFavorite = isFavorite
    )
}

fun CityBase.toRoomModel(): RoomCityBase {
    return RoomCityBase(
        id = id,
        urbanAreaId = urbanAreaId,
        name = name,
        imgUrl = imgUrl,
        isFavorite = isFavorite
    )
}

fun RoomScore.toDomainModel(): Score {
    return Score(
        id = id,
        color = color,
        name = name,
        value = value
    )
}

fun Score.toRoomModel(scoreDataId: Long): RoomScore {
    return RoomScore(
        scoreDataId = scoreDataId,
        color = color,
        name = name,
        value = value
    )
}

fun RoomScoreData.toDomainModel(categories: List<RoomScore>): ScoreData {
    return ScoreData(
        id = id,
        categories = categories.map { it.toDomainModel() },
        summary = summary
    )
}

fun ScoreData.toRoomModel(cityDetailsId: UUID): RoomScoreData {
    return RoomScoreData(
        summary = summary,
        cityDetailsId = cityDetailsId
    )
}

fun CityDetails.toRoomModel(): RoomCityDetails {
    return RoomCityDetails(
        id = id,
        urbanAreaId = urbanAreaId,
        fullName = fullName,
        imgUrlWeb = imgUrlWeb,
        imgUrlMobile = imgUrlMobile,
        population = population,
        mayor = mayor,
        latitude = latitude,
        longitude = longitude,
        currency = currency
    )
}

fun RoomCityDetails.toDomainModel(isFavorite: Boolean, scoreData: ScoreData): CityDetails {
    return CityDetails(
        id = id,
        urbanAreaId = urbanAreaId,
        fullName = fullName,
        imgUrlWeb = imgUrlWeb,
        imgUrlMobile = imgUrlMobile,
        population = population,
        mayor = mayor,
        latitude = latitude,
        longitude = longitude,
        currency = currency,
        isFavorite = isFavorite,
        scores = scoreData
    )
}