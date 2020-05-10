package hu.szokemate.citybro.ui.citydetailscontainer

import co.zsmb.rainbowcake.withIOContext
import hu.szokemate.citybro.domain.interactor.CityInteractor
import hu.szokemate.citybro.domain.model.CityDetails
import javax.inject.Inject

class CityDetailsContainerPresenter @Inject constructor(
    private val cityInteractor: CityInteractor
) {

    suspend fun getCityDetails(urbanAreaId: String): CityDetails? = withIOContext {
        cityInteractor.getCityDetails(urbanAreaId)
    }

}