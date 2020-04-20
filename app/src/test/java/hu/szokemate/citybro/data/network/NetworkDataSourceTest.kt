package hu.szokemate.citybro.data.network

import io.mockk.clearMocks
import io.mockk.mockk
import org.junit.Before

class NetworkDataSourceTest {

    private val teleportAPI: TeleportAPI = mockk()
    private val networkModule = NetworkDataSource(teleportAPI)

    @Before
    fun setUp() {
        clearMocks(teleportAPI)
    }
}