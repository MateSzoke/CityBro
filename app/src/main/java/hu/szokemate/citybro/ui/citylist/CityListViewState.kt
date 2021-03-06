package hu.szokemate.citybro.ui.citylist

import hu.szokemate.citybro.domain.model.CityBase

sealed class CityListViewState

object Loading : CityListViewState()

object CityNotFound : CityListViewState()

data class CityListReady(val cities: List<CityBase>) : CityListViewState()
