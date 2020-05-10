package hu.szokemate.citybro.ui.citydetailscontainer

sealed class CityDetailsContainerViewState

data class CityDetailsContainerReady(val cityName: String) : CityDetailsContainerViewState()