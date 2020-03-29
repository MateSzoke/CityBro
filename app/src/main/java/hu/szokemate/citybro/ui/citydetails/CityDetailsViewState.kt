package hu.szokemate.citybro.ui.citydetails

sealed class CityDetailsViewState

object Loading : CityDetailsViewState()

data class CityDetailsReady(val data: String = "") : CityDetailsViewState()
