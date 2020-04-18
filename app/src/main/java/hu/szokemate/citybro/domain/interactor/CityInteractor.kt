package hu.szokemate.citybro.domain.interactor

import hu.szokemate.citybro.data.db.DiskDataSource
import hu.szokemate.citybro.data.network.NetworkDataSource
import hu.szokemate.citybro.domain.model.CityBase
import javax.inject.Inject

class CityInteractor @Inject constructor(
    private val diskDataSource: DiskDataSource,
    private val networkDataSource: NetworkDataSource
) {

    suspend fun getAllCities(): List<CityBase> {
        return networkDataSource.getAllCities() ?: diskDataSource.getAllCities()
    }

    suspend fun getCityBySearch(citySearch: String): String? {
        return networkDataSource.getCityBySearch(citySearch).toString()
    }
}