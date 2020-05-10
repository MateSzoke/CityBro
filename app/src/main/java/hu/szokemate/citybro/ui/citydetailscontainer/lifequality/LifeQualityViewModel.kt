package hu.szokemate.citybro.ui.citydetailscontainer.lifequality

import co.zsmb.rainbowcake.base.JobViewModel
import javax.inject.Inject

class LifeQualityViewModel @Inject constructor(
    private val lifeQualityPresenter: LifeQualityPresenter
) : JobViewModel<LifeQualityViewState>(Loading) {

    fun load() = execute {
        viewState = LifeQualityReady(lifeQualityPresenter.getData())
    }

}
