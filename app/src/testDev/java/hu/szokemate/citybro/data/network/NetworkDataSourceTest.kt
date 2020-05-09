package hu.szokemate.citybro.data.network

import com.google.common.truth.Truth.assertThat
import hu.szokemate.citybro.common.MOCK_ALL_CITIES
import hu.szokemate.citybro.common.MOCK_CITY_BY_SEARCH
import io.mockk.clearMocks
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class NetworkDataSourceTest {

    private val teleportAPI: TeleportAPI = mockk()
    private val networkDataSource = NetworkDataSource(teleportAPI)

    @Before
    fun setUp() {
        clearMocks(teleportAPI)
    }

    @Test
    fun `getCityBySearch response works`() = runBlocking {

        val response = networkDataSource.getCityBySearch("Budapest")

        assertThat(response).isEqualTo(MOCK_CITY_BY_SEARCH)
    }

    @Test
    fun `getCityBySearch calls the same api method`() = runBlocking {

        networkDataSource.getCityBySearch("Budapest")

        coVerify { teleportAPI.getCityBySearch(search = "Budapest", limit = 1) }
    }

    @Test
    fun `getAllCities response works`() = runBlocking {

        val response = networkDataSource.getAllCities()

        assertThat(response).isEqualTo(MOCK_ALL_CITIES)
    }
}