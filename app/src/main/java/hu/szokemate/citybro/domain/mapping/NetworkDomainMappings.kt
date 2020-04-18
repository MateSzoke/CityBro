package hu.szokemate.citybro.domain.mapping

import hu.szokemate.citybro.data.network.model.CityResult
import hu.szokemate.citybro.domain.model.CityBase

fun CityResult.toDomainModel(urbanAreaId: String, imgUrl: String): CityBase {
    return CityBase(
        urbanAreaId = urbanAreaId,
        name = name,
        isFavorite = false,
        imgUrl = imgUrl
    )
}