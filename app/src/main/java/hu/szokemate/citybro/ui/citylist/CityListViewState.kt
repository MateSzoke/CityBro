package hu.szokemate.citybro.ui.citylist

sealed class CityListViewState

object Loading : CityListViewState()

data class CityListReady(val data: String = "") : CityListViewState()
