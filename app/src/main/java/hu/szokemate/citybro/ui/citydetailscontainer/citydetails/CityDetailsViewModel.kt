package hu.szokemate.citybro.ui.citydetailscontainer.citydetails

import co.zsmb.rainbowcake.base.JobViewModel
import javax.inject.Inject

class CityDetailsViewModel @Inject constructor(
    private val cityDetailsPresenter: CityDetailsPresenter
) : JobViewModel<CityDetailsViewState>(Loading) {

    fun load(urbanAreaId: String) = execute {
        viewState = Loading
        val cityDetails = cityDetailsPresenter.getCityDetails(urbanAreaId)
        viewState = if (cityDetails != null) CityDetailsReady(cityDetails) else EmptyCityDetails
    }

}
