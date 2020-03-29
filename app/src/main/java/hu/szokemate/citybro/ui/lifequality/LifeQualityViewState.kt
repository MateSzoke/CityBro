package hu.szokemate.citybro.ui.lifequality

sealed class LifeQualityViewState

object Loading : LifeQualityViewState()

data class LifeQualityReady(val data: String = "") : LifeQualityViewState()
