package hu.szokemate.citybro.data.network

import hu.szokemate.citybro.data.network.model.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TeleportAPI {

    @GET("cities/")
    suspend fun getCityBySearch(
        @Query("search") search: String,
        @Query("limit") limit: Int = 1
    ): NetworkCitySearchResult

    @GET("cities/{city_id}")
    suspend fun getCityByGeoNameId(@Path("city_id") geoNameId: String): NetworkCityResult

    @GET("urban_areas/{ua_id}/")
    suspend fun getUrbanAreaInformation(@Path("ua_id") urbanAreaId: String): NetworkUrbanArea

    @GET("urban_areas/{ua_id}/images/")
    suspend fun getCityImages(@Path("ua_id") urbanAreaId: String): NetworkUrbanAreaImages

    @GET("urban_areas/{ua_id}/scores/")
    suspend fun getCityScores(@Path("ua_id") urbanAreaId: String): NetworkScoreResponse

    @GET("urban_areas/{ua_id}/details/")
    suspend fun getCityDetails(@Path("ua_id") urbanAreaId: String): NetworkUrbanAreaDetails
}
