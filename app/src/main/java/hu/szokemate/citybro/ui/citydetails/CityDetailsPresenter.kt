package hu.szokemate.citybro.ui.citydetails

import co.zsmb.rainbowcake.withIOContext
import javax.inject.Inject

class CityDetailsPresenter @Inject constructor() {

    suspend fun getData(): String = withIOContext {
        ""
    }

}
