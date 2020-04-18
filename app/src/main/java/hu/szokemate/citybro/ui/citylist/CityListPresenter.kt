package hu.szokemate.citybro.ui.citylist

import co.zsmb.rainbowcake.withIOContext
import hu.szokemate.citybro.domain.interactor.CityInteractor
import hu.szokemate.citybro.domain.model.CityBase
import javax.inject.Inject

class CityListPresenter @Inject constructor(
    private val cityInteractor: CityInteractor
) {

    suspend fun getAllCities(): List<CityBase> = withIOContext {
        cityInteractor.getAllCities()
    }

    suspend fun getCityBySearch(citySearch: String): String = withIOContext {
        cityInteractor.getCityBySearch(citySearch) ?: "No result :'("
    }

}
