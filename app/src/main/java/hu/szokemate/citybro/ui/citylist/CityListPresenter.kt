package hu.szokemate.citybro.ui.citylist

import co.zsmb.rainbowcake.withIOContext
import javax.inject.Inject

class CityListPresenter @Inject constructor() {

    suspend fun getData(): String = withIOContext {
        ""
    }

}
