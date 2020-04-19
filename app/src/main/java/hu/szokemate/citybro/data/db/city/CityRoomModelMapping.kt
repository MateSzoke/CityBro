package hu.szokemate.citybro.data.db.city

import hu.szokemate.citybro.domain.model.CityBase

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