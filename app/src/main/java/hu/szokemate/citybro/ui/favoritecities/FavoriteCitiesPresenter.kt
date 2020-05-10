package hu.szokemate.citybro.ui.favoritecities

import co.zsmb.rainbowcake.withIOContext
import hu.szokemate.citybro.domain.interactor.CityInteractor
import hu.szokemate.citybro.domain.model.CityBase
import javax.inject.Inject

class FavoriteCitiesPresenter @Inject constructor(
    private val cityInteractor: CityInteractor
) {

    suspend fun getFavoriteCities(): List<CityBase> =
        withIOContext { cityInteractor.getFavoriteCities() }


    suspend fun setCityFavorite(isAdd: Boolean, urbanAreaId: String) = withIOContext {
        if (isAdd)
            cityInteractor.addCityToFavorites(urbanAreaId)
        else
            cityInteractor.removeCityFromFavorites(urbanAreaId)
    }

}
