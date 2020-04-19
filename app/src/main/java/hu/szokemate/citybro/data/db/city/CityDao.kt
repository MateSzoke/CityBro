package hu.szokemate.citybro.data.db.city

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface CityDao {

    @Query("SELECT * FROM city_base")
    fun getAllCities(): List<RoomCityBase>

    @Query("SELECT * FROM city_details WHERE urbanAreaId = :urbanAreaId")
    fun getCityByUrbanAreaId(urbanAreaId: String): RoomCityDetails

    @Query("SELECT * FROM city_base WHERE isFavorite = 1")
    fun getFavoriteCities(): List<RoomCityBase>

    @Insert(onConflict = REPLACE)
    fun addCityBase(cityBase: RoomCityBase)

    @Insert(onConflict = REPLACE)
    fun addCityDetails(cityDetails: RoomCityDetails)

    @Query("UPDATE city_base SET isFavorite = :isFavorite WHERE urbanAreaId= :urbanAreaId")
    fun setCityFavorite(urbanAreaId: String, isFavorite: Boolean)

}
