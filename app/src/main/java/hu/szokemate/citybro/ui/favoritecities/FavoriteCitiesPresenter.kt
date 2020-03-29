package hu.szokemate.citybro.ui.favoritecities

import co.zsmb.rainbowcake.withIOContext
import javax.inject.Inject

class FavoriteCitiesPresenter @Inject constructor() {

    suspend fun getData(): String = withIOContext {
        ""
    }

}
