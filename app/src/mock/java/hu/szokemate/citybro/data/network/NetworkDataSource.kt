package hu.szokemate.citybro.data.network

import hu.szokemate.citybro.domain.model.CityBase
import hu.szokemate.citybro.domain.model.CityDetails
import javax.inject.Inject

@Suppress("UNUSED_PARAMETER", "RedundantSuspendModifier")
class NetworkDataSource @Inject constructor() {

    suspend fun getAllCities(limit: Int = 10): List<CityBase>? {
        return emptyList()
    }

    suspend fun getCityBySearch(query: String, limit: Int = 1): CityBase? {
        return null
    }

    suspend fun getCityDetails(urbanAreaId: String): CityDetails? {
        return null
    }

}