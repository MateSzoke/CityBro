package hu.szokemate.citybro.ui.favoritecities

import co.zsmb.rainbowcake.base.JobViewModel
import javax.inject.Inject

class FavoriteCitiesViewModel @Inject constructor(
    private val favoriteCitiesPresenter: FavoriteCitiesPresenter
) : JobViewModel<FavoriteCitiesViewState>(Loading) {

    fun load() = execute {
        viewState = FavoriteCitiesReady(favoriteCitiesPresenter.getData())
    }

}
