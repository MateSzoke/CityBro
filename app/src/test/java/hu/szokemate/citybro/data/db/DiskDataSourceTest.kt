package hu.szokemate.citybro.data.db

import com.google.common.truth.Truth.assertThat
import hu.szokemate.citybro.data.db.city.CityDao
import io.mockk.clearAllMocks
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
    fun firstTest() {
        assertThat(listOf(1, 2, 3)).contains(2)
    }
}