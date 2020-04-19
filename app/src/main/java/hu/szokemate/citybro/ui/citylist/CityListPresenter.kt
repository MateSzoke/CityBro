package hu.szokemate.citybro.ui.citylist

import co.zsmb.rainbowcake.withIOContext
import hu.szokemate.citybro.domain.interactor.CityInteractor
import hu.szokemate.citybro.domain.model.CityBase
import javax.inject.Inject

class CityListPresenter @Inject constructor(
    private val cityInteractor: CityInteractor
) {

    suspend fun getAllCities(limit: Int): List<CityBase> = withIOContext {
        cityInteractor.getAllCities(limit) ?: emptyList()
    }

    suspend fun getCityBySearch(citySearch: String): CityBase? = withIOContext {
        cityInteractor.getCityBySearch(citySearch)
    }

}
