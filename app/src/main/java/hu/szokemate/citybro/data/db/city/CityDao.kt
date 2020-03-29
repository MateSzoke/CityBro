package hu.szokemate.citybro.data.db.city

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface CityDao {

    @Query("SELECT * FROM city_base")
    fun getAllCities(): List<RoomCityBase>

    @Insert(onConflict = REPLACE)
    fun addCity(cityBase: RoomCityBase)
}