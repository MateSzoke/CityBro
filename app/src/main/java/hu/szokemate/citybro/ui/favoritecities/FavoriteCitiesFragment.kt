package hu.szokemate.citybro.ui.favoritecities

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import hu.szokemate.citybro.R

class FavoriteCitiesFragment :
    RainbowCakeFragment<FavoriteCitiesViewState, FavoriteCitiesViewModel>() {

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

}
