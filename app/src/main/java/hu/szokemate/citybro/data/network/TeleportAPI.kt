package hu.szokemate.citybro.data.network

import hu.szokemate.citybro.data.network.model.CityResult
import hu.szokemate.citybro.data.network.model.CitySearchResult
import hu.szokemate.citybro.data.network.model.ScoreResponse
import hu.szokemate.citybro.data.network.model.UrbanAreaImages
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TeleportAPI {

    @GET("cities/")
    suspend fun getCityBySearch(
        @Query("search") search: String,
        @Query("limit") limit: Int
    ): CitySearchResult

    @GET("cities/{city_id}")
    suspend fun getCityByGeoNameId(@Path("city_id") geoNameId: String): CityResult

    @GET("urban_areas/{ua_id}/images/")
    suspend fun getCityImages(@Path("ua_id") urbanAreaId: String): UrbanAreaImages

    @GET("urban_areas/{ua_id}/scores/")
    suspend fun getCityScores(@Path("ua_id") urbanAreaId: String): ScoreResponse

    @GET("urban_areas/{ua_id}/details/")
    suspend fun getCityDetails(@Path("ua_id") urbanAreaId: String)
}
