package hu.szokemate.citybro.ui.favoritecities

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.navigation.navigator
import hu.szokemate.citybro.R
import hu.szokemate.citybro.domain.model.CityBase
import hu.szokemate.citybro.ui.CityAdapter
import hu.szokemate.citybro.ui.citydetails.CityDetailsFragment

class FavoriteCitiesFragment :
    RainbowCakeFragment<FavoriteCitiesViewState, FavoriteCitiesViewModel>(), CityAdapter.Listener {

    private lateinit var cityAdapter: CityAdapter

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_favorite_cities

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO Setup views
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(viewState: FavoriteCitiesViewState) {
        // TODO Render state
    }

    override fun onCityClicked(city: CityBase) {
        navigator?.add(CityDetailsFragment.newInstance(city.urbanAreaId))
    }

    override fun onFavoriteButtonClicked(isAdd: Boolean, urbanAreaId: String) {
        viewModel.setCityFavorite(isAdd, urbanAreaId)
    }

}
