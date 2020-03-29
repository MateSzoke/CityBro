package hu.szokemate.citybro.ui.citydetails

import co.zsmb.rainbowcake.base.JobViewModel
import javax.inject.Inject

class CityDetailsViewModel @Inject constructor(
    private val cityDetailsPresenter: CityDetailsPresenter
) : JobViewModel<CityDetailsViewState>(Loading) {

    fun load() = execute {
        viewState = CityDetailsReady(cityDetailsPresenter.getData())
    }

}
