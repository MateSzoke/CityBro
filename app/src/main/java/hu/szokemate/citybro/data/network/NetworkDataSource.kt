package hu.szokemate.citybro.data.network

import hu.szokemate.citybro.data.network.model.CityResult
import hu.szokemate.citybro.data.network.model.ScoreResponse
import hu.szokemate.citybro.domain.mapping.toDomainModel
import hu.szokemate.citybro.domain.model.CityBase
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(
    private val teleportAPI: TeleportAPI
) {

    private inline fun <reified T> fetch(action: () -> T?): T? {
        return try {
            action()
        } catch (e: IOException) {
            Timber.d("Network fetch failed")
            Timber.d(e)
            return null
        } catch (e: HttpException) {
            Timber.d("Network fetch failed")
            Timber.d(e)
            return null
        }
    }


    suspend fun getAllCities(limit: Int = 10): List<CityBase>? {
        return fetch {
            val citySearchResult = teleportAPI.getCityBySearch("", limit)
            if (citySearchResult.result.searchResults.isEmpty()) return null
            val geoNameIds =
                citySearchResult.result.searchResults.map { it.links.cityItem.href.substringAfter("cities/") }
            geoNameIds.map { id ->
                val cityResult = teleportAPI.getCityByGeoNameId(id)
                val urbanAreaId =
                    cityResult.links.urbanAreaLink?.href?.substringAfter("urban_areas/")
                        ?.dropLast(1)
                val imgUrl =
                    if (urbanAreaId != null) teleportAPI.getCityImages(urbanAreaId).photos[0].image.web else ""
                cityResult.toDomainModel(urbanAreaId = urbanAreaId ?: "", imgUrl = imgUrl)
            }
        }
    }

    suspend fun getCityBySearch(query: String, limit: Int = 1): CityResult? {
        return fetch {
            val citySearchResult = teleportAPI.getCityBySearch(query, limit)
            if (citySearchResult.result.searchResults.isEmpty()) return null
            val geoNameId =
                citySearchResult.result.searchResults[0].links.cityItem.href.substringAfter("cities/")
            teleportAPI.getCityByGeoNameId(geoNameId)
        } ?: return null
    }

    suspend fun getCityScores(urbanAreaId: String): ScoreResponse? {
        return fetch { teleportAPI.getCityScores(urbanAreaId) }
    }

}