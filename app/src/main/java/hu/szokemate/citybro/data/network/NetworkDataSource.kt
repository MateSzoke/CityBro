package hu.szokemate.citybro.data.network

import hu.szokemate.citybro.data.network.model.NetworkCityResult
import hu.szokemate.citybro.data.network.model.NetworkSearchResult
import hu.szokemate.citybro.domain.mapping.toDomainModel
import hu.szokemate.citybro.domain.model.CityBase
import hu.szokemate.citybro.domain.model.CityDetails
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(
    private val teleportAPI: TeleportAPI
) {

    companion object {
        const val CURRENCY_DATA_ID = "CURRENCY-URBAN-AREA"
    }

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
                citySearchResult.result.searchResults.map { it.geoNameId }
            geoNameIds.map { id ->
                teleportAPI.getCityByGeoNameId(id).toCityBase()
            }
        }
    }

    suspend fun getCityBySearch(query: String, limit: Int = 1): CityBase? {
        return fetch {
            val citySearchResult = teleportAPI.getCityBySearch(query, limit)
            if (citySearchResult.result.searchResults.isEmpty()) return null
            teleportAPI.getCityByGeoNameId(citySearchResult.result.searchResults.first().geoNameId)
                .toCityBase()
        } ?: return null
    }

    suspend fun getCityDetails(urbanAreaId: String): CityDetails? {
        return fetch {
            if (urbanAreaId.isEmpty()) return null
            val urbanArea = teleportAPI.getUrbanAreaInformation(urbanAreaId)
            val geoNameId = teleportAPI.getCityBySearch(
                search = urbanArea.name,
                limit = 1
            ).result.searchResults.first().geoNameId
            val cityResult = teleportAPI.getCityByGeoNameId(geoNameId)
            val image = teleportAPI.getCityImages(urbanAreaId).photos.map { it.image.web }.first()
            val scores = teleportAPI.getCityScores(urbanAreaId)
            val details = teleportAPI.getCityDetails(urbanAreaId).categories.flatMap { it.data }
            CityDetails(
                id = UUID.randomUUID(),
                urbanAreaId = urbanAreaId,
                fullName = urbanArea.fullName,
                imgUrl = image,
                isFavorite = false,
                population = cityResult.population,
                mayor = urbanArea.mayor,
                latitude = cityResult.location.latlon.latitude,
                longitude = cityResult.location.latlon.longitude,
                currency = details.first { it.id == CURRENCY_DATA_ID }.stringValue,
                scores = scores.toDomainModel()
            )
        }
    }

    private suspend fun NetworkCityResult.toCityBase(): CityBase {
        val imgUrl =
            if (urbanAreaId.isNotEmpty()) teleportAPI.getCityImages(urbanAreaId).photos.first().image.web else ""
        return toDomainModel(urbanAreaId = urbanAreaId, imgUrl = imgUrl)
    }

    private val NetworkSearchResult.geoNameId: String
        get() = links.cityItem.href.substringAfter("cities/")

    private val NetworkCityResult.urbanAreaId: String
        get() = links.urbanAreaLink?.href?.substringAfter("urban_areas/")
            ?.dropLast(1) ?: ""
}