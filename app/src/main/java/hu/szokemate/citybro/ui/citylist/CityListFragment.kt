package hu.szokemate.citybro.ui.citylist

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.navigation.navigator
import hu.szokemate.citybro.R
import hu.szokemate.citybro.domain.model.CityBase
import hu.szokemate.citybro.ui.CityAdapter
import hu.szokemate.citybro.ui.citydetails.CityDetailsFragment
import hu.szokemate.citybro.util.extensions.trimmedText
import kotlinx.android.synthetic.main.fragment_city_list.*
import timber.log.Timber

class CityListFragment : RainbowCakeFragment<CityListViewState, CityListViewModel>(),
    CityAdapter.Listener {

    private lateinit var cityAdapter: CityAdapter

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_city_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        citySearchButton.setOnClickListener { viewModel.searchCity(citySearchInput.trimmedText) }
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(viewState: CityListViewState) {
        when (viewState) {
            Loading -> cityListFragmentRoot.isVisible = false
            is CityListReady -> showCityListReady(viewState)
        }.exhaustive
    }

    private fun showCityListReady(viewState: CityListReady) {
        cityListFragmentRoot.isVisible = true
        resultText.text = viewState.tmpResult
        viewState.cities.forEach { Timber.d(it.toString()) }
        showDetailsButton.setOnClickListener {
            val urbanAreaId = viewState.cities.first().urbanAreaId
            if (urbanAreaId.isNotEmpty())
                navigator?.add(CityDetailsFragment.newInstance(urbanAreaId))
        }
    }

    override fun onCityClicked(city: CityBase) {
        navigator?.add(CityDetailsFragment.newInstance(city.urbanAreaId))
    }

}
