package hu.szokemate.citybro.ui.citydetails

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.applyArgs
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.navigation.extensions.requireString
import hu.szokemate.citybro.R
import kotlinx.android.synthetic.main.fragment_city_details.*

class CityDetailsFragment : RainbowCakeFragment<CityDetailsViewState, CityDetailsViewModel> {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_city_details

    //region Arguments
    @Suppress("ConvertSecondaryConstructorToPrimary")
    @Deprecated(
        message = "Use newInstance instead",
        replaceWith = ReplaceWith("CityDetailsFragment.newInstance()")
    )
    constructor()

    companion object {
        private const val CITY_ID = "SOME_ID"

        @Suppress("DEPRECATION")
        fun newInstance(cityId: String): CityDetailsFragment {
            return CityDetailsFragment().applyArgs {
                putString(CITY_ID, cityId)
            }
        }
    }

    private var cityId: String = ""

    private fun initArguments() {
        cityId = requireArguments().requireString(CITY_ID)
    }

    //endregion
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initArguments()
    }

    override fun onStart() {
        super.onStart()

        viewModel.load(cityId)
    }

    override fun render(viewState: CityDetailsViewState) {
        when (viewState) {
            Loading -> cityDetailsFragmentRoot.isVisible = false
            EmptyCityDetails -> showEmptyCityDetails()
            is CityDetailsReady -> showCityDetailsReady(viewState)
        }.exhaustive
    }

    private fun showEmptyCityDetails() {
        cityDetailsFragmentRoot.isVisible = true
        cityDetailsResultText.text = "Empty result"
    }

    private fun showCityDetailsReady(viewState: CityDetailsReady) {
        cityDetailsFragmentRoot.isVisible = true
        cityDetailsResultText.text = viewState.city.toString()

    }

}
