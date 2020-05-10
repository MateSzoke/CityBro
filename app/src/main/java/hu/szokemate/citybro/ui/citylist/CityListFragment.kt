package hu.szokemate.citybro.ui.citylist

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.navigation.BackPressAware
import co.zsmb.rainbowcake.navigation.navigator
import hu.szokemate.citybro.R
import hu.szokemate.citybro.domain.model.CityBase
import hu.szokemate.citybro.ui.CityAdapter
import hu.szokemate.citybro.ui.citydetailscontainer.CityDetailsContainerFragment
import hu.szokemate.citybro.ui.favoritecities.FavoriteCitiesFragment
import hu.szokemate.citybro.util.extensions.hideKeyboard
import hu.szokemate.citybro.util.extensions.trimmedText
import kotlinx.android.synthetic.main.fragment_city_list.*

class CityListFragment : RainbowCakeFragment<CityListViewState, CityListViewModel>(),
    CityAdapter.Listener, BackPressAware {

    private lateinit var cityAdapter: CityAdapter

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_city_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchImage.setOnClickListener {
            viewModel.searchCity(citySearchInput.trimmedText)
            clearSearchInput()
        }
        cityAdapter = CityAdapter()
        cityAdapter.listener = this

        citySearchInput.doOnTextChanged { _, _, count, _ ->
            searchBackImage.isVisible = count != 0
            appTitleText.isVisible = count == 0
        }

        searchBackImage.setOnClickListener {
            clearSearchInput()
            viewModel.load()
        }

        appTitleText.setOnClickListener { viewModel.load() }

        favoriteButton.setOnClickListener { navigator?.add(FavoriteCitiesFragment()) }
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(viewState: CityListViewState) {
        when (viewState) {
            Loading -> {
                cityListFragmentRoot.isVisible = false
            }
            is CityListReady -> showCityListReady(viewState)
            CityNotFound -> showCityNotFound()
        }.exhaustive
    }

    private fun showCityNotFound() {
        cityListFragmentRoot.isVisible = true
        cityNotFoundImage.isVisible = true
        cityList.isVisible = false
    }


    private fun showCityListReady(viewState: CityListReady) {
        cityListFragmentRoot.isVisible = true
        cityList.isVisible = true
        cityNotFoundImage.isVisible = false
        searchBackImage.isVisible = false
        appTitleText.isVisible = true

        cityAdapter.submitList(viewState.cities)
        cityList.adapter = cityAdapter
    }

    override fun onCityClicked(city: CityBase) {
        navigator?.add(CityDetailsContainerFragment.newInstance(city.urbanAreaId))
    }

    override fun onFavoriteButtonClicked(isAdd: Boolean, urbanAreaId: String) {
        viewModel.setCityFavorite(isAdd, urbanAreaId)
    }

    override fun onBackPressed(): Boolean {
        return if (citySearchInput.text.isNotEmpty()) {
            clearSearchInput()
            false
        } else {
            viewModel.load()
            true
        }
    }

    private fun clearSearchInput() {
        hideKeyboard()
        citySearchInput.text.clear()
    }

}
