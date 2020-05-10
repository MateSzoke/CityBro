package hu.szokemate.citybro.ui.favoritecities

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.navigation.navigator
import hu.szokemate.citybro.R
import hu.szokemate.citybro.domain.model.CityBase
import hu.szokemate.citybro.ui.CityAdapter
import hu.szokemate.citybro.ui.citydetailscontainer.CityDetailsContainerFragment
import kotlinx.android.synthetic.main.back_button_toolbar.*
import kotlinx.android.synthetic.main.fragment_favorite_cities.*

class FavoriteCitiesFragment :
    RainbowCakeFragment<FavoriteCitiesViewState, FavoriteCitiesViewModel>(), CityAdapter.Listener {

    private lateinit var cityAdapter: CityAdapter

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_favorite_cities

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.title = getString(R.string.favorite_cities_toolbar)
        toolbar.setNavigationOnClickListener { navigator?.pop() }

        cityAdapter = CityAdapter()
        cityAdapter.listener = this
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(viewState: FavoriteCitiesViewState) {
        when (viewState) {
            is FavoriteCitiesReady -> showFavoriteCities(viewState.cities)
        }.exhaustive
    }

    private fun showFavoriteCities(cities: List<CityBase>) {
        cityAdapter.submitList(cities)
        cityList.adapter = cityAdapter
    }

    override fun onCityClicked(city: CityBase) {
        navigator?.add(CityDetailsContainerFragment.newInstance(city.urbanAreaId))
    }

    override fun onFavoriteButtonClicked(isAdd: Boolean, urbanAreaId: String) {
        viewModel.setCityFavorite(isAdd, urbanAreaId)
    }

}
