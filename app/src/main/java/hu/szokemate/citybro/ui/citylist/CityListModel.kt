package hu.szokemate.citybro.ui.citylist

import co.zsmb.rainbowcake.base.JobViewModel
import javax.inject.Inject

class CityListModel @Inject constructor(
    private val cityListPresenter: CityListPresenter
) : JobViewModel<CityListViewState>(Loading) {

    fun load() = execute {
        viewState =
            CityListReady(cityListPresenter.getAllCities(), "No result")
    }

    fun searchCity(citySearch: String) = execute {
        val state = viewState as? CityListReady ?: return@execute
        val result = cityListPresenter.getCityBySearch(citySearch)
        viewState = state.copy(tmpResult = result)
    }

}
