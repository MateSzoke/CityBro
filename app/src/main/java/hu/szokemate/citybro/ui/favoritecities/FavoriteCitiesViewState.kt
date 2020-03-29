package hu.szokemate.citybro.ui.favoritecities

sealed class FavoriteCitiesViewState

object Loading : FavoriteCitiesViewState()

data class FavoriteCitiesReady(val data: String = "") : FavoriteCitiesViewState()
