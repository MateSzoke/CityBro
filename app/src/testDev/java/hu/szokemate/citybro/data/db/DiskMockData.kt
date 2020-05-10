package hu.szokemate.citybro.data.db

import hu.szokemate.citybro.data.db.city.RoomCityBase
import hu.szokemate.citybro.data.db.city.RoomCityDetails
import java.util.*

val DISK_MOCK_ALL_CITIES = listOf(
    RoomCityBase(
        id = UUID.randomUUID(),
        urbanAreaId = "mock_urban_area_id_01",
        name = "Budapest",
        isFavorite = false,
        imgUrl = "https://store-images.s-microsoft.com/image/apps.47288.14188059920471079.8845931d-936f-4c5b-848c-e9700ef87a6b.92da2b6e-01a3-4806-8575-6f6278ecd71b"
    ),
    RoomCityBase(
        id = UUID.randomUUID(),
        urbanAreaId = "mock_urban_area_id_02",
        name = "Peking",
        isFavorite = false,
        imgUrl = "https://store-images.s-microsoft.com/image/apps.47288.14188059920471079.8845931d-936f-4c5b-848c-e9700ef87a6b.92da2b6e-01a3-4806-8575-6f6278ecd71b"
    ),
    RoomCityBase(
        id = UUID.randomUUID(),
        urbanAreaId = "mock_urban_area_id_03",
        name = "London",
        isFavorite = false,
        imgUrl = "https://store-images.s-microsoft.com/image/apps.47288.14188059920471079.8845931d-936f-4c5b-848c-e9700ef87a6b.92da2b6e-01a3-4806-8575-6f6278ecd71b"
    )
)

val DISK_MOCK_CITY_DETAILS =
    RoomCityDetails(
        id = UUID.randomUUID(),
        urbanAreaId = "mock_urban_area_id_01",
        fullName = "Budapest, Hungary",
        imgUrlWeb = "https://store-images.s-microsoft.com/image/apps.47288.14188059920471079.8845931d-936f-4c5b-848c-e9700ef87a6b.92da2b6e-01a3-4806-8575-6f6278ecd71b",
        imgUrlMobile = "https://store-images.s-microsoft.com/image/apps.47288.14188059920471079.8845931d-936f-4c5b-848c-e9700ef87a6b.92da2b6e-01a3-4806-8575-6f6278ecd71b",
        population = 123123,
        mayor = "Francz Mayor",
        latitude = 40.3,
        longitude = 26.5,
        currency = "EUR"
    )