package hu.szokemate.citybro.ui.citylist

import co.zsmb.rainbowcake.base.JobViewModel
import javax.inject.Inject

class CityListViewModel @Inject constructor(
    private val cityListPresenter: CityListPresenter
) : JobViewModel<CityListViewState>(Loading) {

    companion object {
        const val TOP_CITIES_LIMIT = 10
    }

    fun load(limit: Int = TOP_CITIES_LIMIT) = execute {
        viewState =
            CityListReady(cityListPresenter.getAllCities(limit = limit), "No result")
    }

    fun searchCity(citySearch: String) = execute {
        val state = viewState as? CityListReady ?: return@execute
        val result = cityListPresenter.getCityBySearch(citySearch)
        viewState = state.copy(tmpResult = result.toString())  //TODO remove toString after test
    }

}
