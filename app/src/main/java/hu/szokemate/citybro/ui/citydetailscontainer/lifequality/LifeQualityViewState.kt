package hu.szokemate.citybro.ui.citydetailscontainer.lifequality

import hu.szokemate.citybro.domain.model.ScoreData

sealed class LifeQualityViewState

object Loading : LifeQualityViewState()

data class LifeQualityReady(val scoreData: ScoreData) : LifeQualityViewState()
