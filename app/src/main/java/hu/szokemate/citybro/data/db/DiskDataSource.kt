package hu.szokemate.citybro.data.db

import hu.szokemate.citybro.data.db.city.CityDao
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DiskDataSource @Inject
constructor(
    private val cityDao: CityDao
) {


}