package hu.szokemate.citybro.data.network

import hu.szokemate.citybro.data.network.model.CitySearchResult
import retrofit2.http.GET
import retrofit2.http.Query

interface TeleportAPI {

    @GET("cities/")
    suspend fun getCityBySearch(
        @Query("search") search: String,
        @Query("limit") limit: Int = 1
    ): CitySearchResult
}
