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

    fun getCityDetailsByUrbanAreaId(urbanAreaId: String): CityDetails? {
        val roomCityBase = cityDao.getCityBaseByUrbanAreaId(urbanAreaId) ?: return null
        val roomCityDetails = cityDao.getCityDetailsByUrbanAreaId(urbanAreaId) ?: return null
        val roomScoreData = cityDao.getScoreDataByCityDetailsId(roomCityDetails.id) ?: return null
        val roomScores = cityDao.getScoresByScoreDataId(roomScoreData.id)
        return roomCityDetails.toDomainModel(
            isFavorite = roomCityBase.isFavorite,
            scoreData = roomScoreData.toDomainModel(categories = roomScores)
        )
    }

    fun saveCityBase(city: CityBase) {
        if (city.urbanAreaId !in cityDao.getAllCities().map { it.urbanAreaId })
            cityDao.addCityBase(city.toRoomModel())
    }

    fun saveCityBases(cities: List<CityBase>) {
        cities.forEach { city ->
            cityDao.addCityBase(city.toRoomModel())
        }
    }

    fun saveCityDetails(cityDetails: CityDetails) {
        cityDao.addCityDetails(cityDetails.toRoomModel())
        val scores = cityDetails.scores
        val scoreDataId = cityDao.addScoreData(scores.toRoomModel(cityDetails.id))
        scores.categories.forEach { score ->
            cityDao.addScore(score.toRoomModel(scoreDataId))
        }
    }

    fun addCityToFavorites(urbanAreaId: String) {
        cityDao.setCityFavorite(urbanAreaId = urbanAreaId, isFavorite = true)
    }

    fun removeCityFromFavorites(urbanAreaId: String) {
        cityDao.setCityFavorite(urbanAreaId = urbanAreaId, isFavorite = false)
    }

}