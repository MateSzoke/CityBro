package hu.szokemate.citybro.data.db

import com.google.common.truth.Truth.assertThat
import hu.szokemate.citybro.common.URBAN_AREA_ID
import hu.szokemate.citybro.data.db.city.CityDao
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Test

class DiskDataSourceTest {

    private val cityDao: CityDao = mockk()
    private val diskDataSource: DiskDataSource = DiskDataSource(cityDao)

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun `Add favorite city`() {
        every { cityDao.getAllCities() } returns DISK_MOCK_ALL_CITIES

        diskDataSource.addCityToFavorites(URBAN_AREA_ID)
        val favoriteCity = cityDao.getAllCities().first { it.urbanAreaId == URBAN_AREA_ID }
        assertThat(favoriteCity.isFavorite).isEqualTo(true)
    }

    @Test
    fun `Remove favorite city`() {
        every { cityDao.getAllCities() } returns DISK_MOCK_ALL_CITIES

        diskDataSource.removeCityFromFavorites(URBAN_AREA_ID)
        val favoriteCity = cityDao.getAllCities().first { it.urbanAreaId == URBAN_AREA_ID }
        assertThat(favoriteCity.isFavorite).isEqualTo(false)
    }

    @Test
    fun `Add city details returns`() {
        every { cityDao.addCityDetails(DISK_MOCK_CITY_DETAILS) } returns Unit

        val cityDetails = diskDataSource.getCityDetailsByUrbanAreaId(URBAN_AREA_ID)
        assertThat(cityDetails?.urbanAreaId).isEqualTo(DISK_MOCK_CITY_DETAILS.urbanAreaId)
    }
}