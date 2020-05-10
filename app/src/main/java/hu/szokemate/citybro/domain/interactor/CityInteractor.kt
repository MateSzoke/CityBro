package hu.szokemate.citybro.domain.interactor

import hu.szokemate.citybro.data.db.DiskDataSource
import hu.szokemate.citybro.data.network.NetworkDataSource
import hu.szokemate.citybro.domain.model.CityBase
import hu.szokemate.citybro.domain.model.CityDetails
import javax.inject.Inject

class CityInteractor @Inject constructor(
    private val diskDataSource: DiskDataSource,
    private val networkDataSource: NetworkDataSource
) {

    private fun getCachedCities(): List<CityBase> {
        return diskDataSource.getAllCities()
    }

    private fun getCachedCityDetail(urbanAreaId: String): CityDetails? {
        return diskDataSource.getCityDetailsByUrbanAreaId(urbanAreaId)
    }

    suspend fun getAllCities(limit: Int): List<CityBase>? {
        val cities = getCachedCities()
        return if (cities.isEmpty()) {
            val newCities = networkDataSource.getAllCities(limit = limit)
            if (newCities != null) {
                diskDataSource.saveCityBases(newCities)
            }
            getCachedCities()
        } else {
            cities
        }
    }

    suspend fun getCityBySearch(citySearch: String): CityBase? {
        val city = getCachedCities().firstOrNull {
            it.name.contains(
                other = citySearch,
                ignoreCase = true
            )
        } ?: networkDataSource.getCityBySearch(citySearch)
        if (city != null) {
            diskDataSource.saveCityBase(city)
        }
        return city
    }

    suspend fun getCityDetails(urbanAreaId: String): CityDetails? {
        val cachedCityDetails = getCachedCityDetail(urbanAreaId)
        return if (cachedCityDetails == null) {
            val newCityDetail = networkDataSource.getCityDetails(urbanAreaId)
            if (newCityDetail != null) diskDataSource.saveCityDetails(newCityDetail) else return null
            getCachedCityDetail(urbanAreaId)

        } else {
            cachedCityDetails
        }
    }

    fun getFavoriteCities() = getCachedCities().filter { it.isFavorite }


    fun addCityToFavorites(urbanAreaId: String) {
        diskDataSource.addCityToFavorites(urbanAreaId)
    }

    fun removeCityFromFavorites(urbanAreaId: String) {
        diskDataSource.removeCityFromFavorites(urbanAreaId)
    }

}
