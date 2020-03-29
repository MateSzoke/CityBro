package hu.szokemate.citybro.data.db

import hu.szokemate.citybro.data.db.city.CityDao
import hu.szokemate.citybro.data.db.city.toDomainModel
import hu.szokemate.citybro.domain.model.CityBase
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

}