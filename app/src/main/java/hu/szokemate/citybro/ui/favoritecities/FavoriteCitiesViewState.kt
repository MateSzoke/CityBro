package hu.szokemate.citybro.ui.favoritecities

import hu.szokemate.citybro.domain.model.CityBase

sealed class FavoriteCitiesViewState

data class FavoriteCitiesReady(val cities: List<CityBase>) : FavoriteCitiesViewState()
