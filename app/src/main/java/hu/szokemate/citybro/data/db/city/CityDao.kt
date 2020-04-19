package hu.szokemate.citybro.data.db.city

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import java.util.*

@Dao
interface CityDao {

    @Query("SELECT * FROM city_base")
    fun getAllCities(): List<RoomCityBase>

    @Query("SELECT * FROM city_base WHERE urbanAreaId = :urbanAreaId")
    fun getCityBaseByUrbanAreaId(urbanAreaId: String): RoomCityBase

    @Query("SELECT * FROM city_details WHERE urbanAreaId = :urbanAreaId")
    fun getCityDetailsByUrbanAreaId(urbanAreaId: String): RoomCityDetails

    @Query("SELECT * FROM city_base WHERE isFavorite = 1")
    fun getFavoriteCities(): List<RoomCityBase>

    @Query("SELECT * FROM score_data WHERE cityDetailsId = :cityDetailsId")
    fun getScoreDataByCityDetailsId(cityDetailsId: UUID): RoomScoreData

    @Query("SELECT * FROM score WHERE scoreDataId = :scoreDataId")
    fun getScoresByScoreDataId(scoreDataId: Long): List<RoomScore>

    @Insert(onConflict = REPLACE)
    fun addCityBase(cityBase: RoomCityBase)

    @Insert(onConflict = REPLACE)
    fun addCityDetails(cityDetails: RoomCityDetails)

    @Query("UPDATE city_base SET isFavorite = :isFavorite WHERE urbanAreaId= :urbanAreaId")
    fun setCityFavorite(urbanAreaId: String, isFavorite: Boolean)

}
