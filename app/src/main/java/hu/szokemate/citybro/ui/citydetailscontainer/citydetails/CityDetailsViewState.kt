package hu.szokemate.citybro.ui.citydetailscontainer.citydetails

import hu.szokemate.citybro.domain.model.CityDetails

sealed class CityDetailsViewState

object Loading : CityDetailsViewState()

object EmptyCityDetails : CityDetailsViewState()

data class CityDetailsReady(val city: CityDetails) : CityDetailsViewState()
