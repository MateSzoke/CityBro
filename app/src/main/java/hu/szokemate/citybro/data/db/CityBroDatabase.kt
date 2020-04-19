package hu.szokemate.citybro.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import hu.szokemate.citybro.data.db.city.CityDao
import hu.szokemate.citybro.data.db.city.RoomCityBase
import hu.szokemate.citybro.data.db.converters.CommonConverters

@Database(
    exportSchema = false,
    version = 1,
    entities = [
        RoomCityBase::class
    ]
)
@TypeConverters(
    CommonConverters::class
)
abstract class CityBroDatabase : RoomDatabase() {

    abstract fun cityDao(): CityDao

}