package hu.szokemate.citybro.ui.citydetailscontainer.lifequality

import co.zsmb.rainbowcake.withIOContext
import javax.inject.Inject

class LifeQualityPresenter @Inject constructor() {

    suspend fun getData(): String = withIOContext {
        ""
    }

}
