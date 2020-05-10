package hu.szokemate.citybro.data.db

import hu.szokemate.citybro.domain.model.CityBase
import hu.szokemate.citybro.domain.model.CityDetails
import javax.inject.Inject

@Suppress("UNUSED_PARAMETER")
class DiskDataSource @Inject constructor() {

    fun getAllCities(): List<CityBase> {
        return emptyList()
    }

    fun getFavoriteCities(): List<CityBase> {
        return emptyList()
    }

    fun getCityDetailsByUrbanAreaId(urbanAreaId: String): CityDetails? {
        return null
    }

    fun saveCityBase(city: CityBase) {
        // Empty
    }

    fun saveCityBases(cities: List<CityBase>) {
        // Empty
    }

    fun saveCityDetails(cityDetails: CityDetails) {
        // Empty
    }

    fun addCityToFavorites(urbanAreaId: String) {
        // Empty
    }

    fun removeCityFromFavorites(urbanAreaId: String) {
        // Empty
    }

}