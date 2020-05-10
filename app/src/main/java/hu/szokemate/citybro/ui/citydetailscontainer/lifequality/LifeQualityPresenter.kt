package hu.szokemate.citybro.ui.citydetailscontainer.lifequality

import co.zsmb.rainbowcake.withIOContext
import hu.szokemate.citybro.domain.interactor.CityInteractor
import hu.szokemate.citybro.domain.model.ScoreData
import javax.inject.Inject

class LifeQualityPresenter @Inject constructor(
    private val cityInteractor: CityInteractor
) {

    suspend fun getScores(cityId: String): ScoreData? = withIOContext {
        cityInteractor.getCityDetails(cityId)?.scores
    }

}
