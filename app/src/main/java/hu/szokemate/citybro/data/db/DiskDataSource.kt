package hu.szokemate.citybro.data.db

import hu.szokemate.citybro.data.db.city.CityDao
import hu.szokemate.citybro.data.db.city.toDomainModel
import hu.szokemate.citybro.data.db.city.toRoomModel
import hu.szokemate.citybro.domain.model.CityBase
import hu.szokemate.citybro.domain.model.CityDetails
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DiskDataSource @Inject
constructor(
    private val cityDao: CityDao
) {

    fun getAllCities(): List<CityBase> {
        return cityDao.getAllCities().map { it.toDomainModel() }
    }

    fun getFavoriteCities(): List<CityBase> {
        return cityDao.getFavoriteCities().map { it.toDomainModel() }
    }

    fun getCityDetailsByUrbanAreaId(urbanAreaId: String): CityDetails {
        val roomCityBase = cityDao.getCityBaseByUrbanAreaId(urbanAreaId)
        val roomCityDetails = cityDao.getCityDetailsByUrbanAreaId(urbanAreaId)
        val roomScoreData = cityDao.getScoreDataByCityDetailsId(roomCityDetails.id)
        val roomScores = cityDao.getScoresByScoreDataId(roomScoreData.id)
        return roomCityDetails.toDomainModel(
            isFavorite = roomCityBase.isFavorite,
            scoreData = roomScoreData.toDomainModel(categories = roomScores)
        )
    }

    fun insertCityBase(city: CityBase) {
        cityDao.addCityBase(city.toRoomModel())
    }

    fun insertCityBases(cities: List<CityBase>) {
        cities.forEach { city ->
            cityDao.addCityBase(city.toRoomModel())
        }
    }

    fun addCityToFavorites(urbanAreaId: String) {
        cityDao.setCityFavorite(urbanAreaId = urbanAreaId, isFavorite = true)
    }

    fun removeCityFromFavorites(urbanAreaId: String) {
        cityDao.setCityFavorite(urbanAreaId = urbanAreaId, isFavorite = false)
    }

}