package hu.szokemate.citybro.common

import hu.szokemate.citybro.domain.model.CityBase
import hu.szokemate.citybro.domain.model.CityDetails
import hu.szokemate.citybro.domain.model.Score
import hu.szokemate.citybro.domain.model.ScoreData
import java.util.*

val URBAN_AREA_ID = "mock_urban_area_id_01"

val MOCK_ALL_CITIES = listOf(
    CityBase(
        id = UUID.randomUUID(),
        urbanAreaId = "mock_urban_area_id_01",
        name = "Budapest",
        isFavorite = false,
        imgUrl = "https://store-images.s-microsoft.com/image/apps.47288.14188059920471079.8845931d-936f-4c5b-848c-e9700ef87a6b.92da2b6e-01a3-4806-8575-6f6278ecd71b"
    ),
    CityBase(
        id = UUID.randomUUID(),
        urbanAreaId = "mock_urban_area_id_02",
        name = "Peking",
        isFavorite = false,
        imgUrl = "https://store-images.s-microsoft.com/image/apps.47288.14188059920471079.8845931d-936f-4c5b-848c-e9700ef87a6b.92da2b6e-01a3-4806-8575-6f6278ecd71b"
    ),
    CityBase(
        id = UUID.randomUUID(),
        urbanAreaId = "mock_urban_area_id_03",
        name = "London",
        isFavorite = false,
        imgUrl = "https://store-images.s-microsoft.com/image/apps.47288.14188059920471079.8845931d-936f-4c5b-848c-e9700ef87a6b.92da2b6e-01a3-4806-8575-6f6278ecd71b"
    )
)

val MOCK_CITY_BY_SEARCH = CityBase(
    id = UUID.randomUUID(),
    urbanAreaId = "mock_urban_area_id_01",
    name = "Budapest",
    isFavorite = false,
    imgUrl = "https://store-images.s-microsoft.com/image/apps.47288.14188059920471079.8845931d-936f-4c5b-848c-e9700ef87a6b.92da2b6e-01a3-4806-8575-6f6278ecd71b"
)

val MOCK_CITY_DETAILS = CityDetails(
    id = UUID.randomUUID(),
    urbanAreaId = "mock_urban_area_id_01",
    fullName = "Budapest, Hungary",
    imgUrlWeb = "https://store-images.s-microsoft.com/image/apps.47288.14188059920471079.8845931d-936f-4c5b-848c-e9700ef87a6b.92da2b6e-01a3-4806-8575-6f6278ecd71b",
    imgUrlMobile = "https://store-images.s-microsoft.com/image/apps.47288.14188059920471079.8845931d-936f-4c5b-848c-e9700ef87a6b.92da2b6e-01a3-4806-8575-6f6278ecd71b",
    isFavorite = false,
    population = 123123,
    mayor = "Francz Mayor",
    latitude = 40.3,
    longitude = 26.5,
    currency = "EUR",
    scores = ScoreData(
        categories = listOf(
            Score(
                color = "#FFF",
                name = "housing",
                value = 30.0
            ),
            Score(
                color = "#FFF",
                name = "cost of living",
                value = 60.0
            )
        ),
        summary = "Lorem ipsum dolor es gut city i guess"
    )
)
