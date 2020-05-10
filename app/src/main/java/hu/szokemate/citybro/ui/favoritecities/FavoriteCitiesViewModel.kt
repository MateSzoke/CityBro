package hu.szokemate.citybro.ui.favoritecities

import co.zsmb.rainbowcake.base.JobViewModel
import javax.inject.Inject

class FavoriteCitiesViewModel @Inject constructor(
    private val favoriteCitiesPresenter: FavoriteCitiesPresenter
) : JobViewModel<FavoriteCitiesViewState>(FavoriteCitiesReady(emptyList())) {

    fun load() = execute {
        viewState = FavoriteCitiesReady(cities = favoriteCitiesPresenter.getFavoriteCities())
    }

    fun setCityFavorite(isAdd: Boolean, urbanAreaId: String) = execute {
        favoriteCitiesPresenter.setCityFavorite(isAdd, urbanAreaId)
        load()
    }

}
