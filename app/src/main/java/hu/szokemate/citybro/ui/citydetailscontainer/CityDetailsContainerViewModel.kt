package hu.szokemate.citybro.ui.citydetailscontainer

import co.zsmb.rainbowcake.base.JobViewModel
import javax.inject.Inject

class CityDetailsContainerViewModel @Inject constructor(
    private val cityDetailsContainerPresenter: CityDetailsContainerPresenter
) :
    JobViewModel<CityDetailsContainerViewState>(CityDetailsContainerReady("")) {

    fun load(cityId: String) = execute {
        viewState = CityDetailsContainerReady(
            cityName = cityDetailsContainerPresenter.getCityDetails(cityId)?.fullName ?: ""
        )
    }
}