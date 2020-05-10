package hu.szokemate.citybro.ui.favoritecities

import co.zsmb.rainbowcake.withIOContext
import hu.szokemate.citybro.domain.interactor.CityInteractor
import javax.inject.Inject

class FavoriteCitiesPresenter @Inject constructor(
    private val cityInteractor: CityInteractor
) {

    suspend fun getData(): String = withIOContext {
        ""
    }

    suspend fun setCityFavorite(isAdd: Boolean, urbanAreaId: String) = withIOContext {
        if (isAdd)
            cityInteractor.addCityToFavorites(urbanAreaId)
        else
            cityInteractor.removeCityFromFavorites(urbanAreaId)
    }

}
