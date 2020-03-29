package hu.szokemate.citybro.data.network

import hu.szokemate.citybro.domain.model.CityBase
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkDataSource @Inject constructor(
    private val serviceManagerAPI: TeleportAPI
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


    suspend fun getAllCities(): List<CityBase>? {
        return fetch { emptyList<CityBase>() }
    }

}