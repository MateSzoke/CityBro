package hu.szokemate.citybro.ui.citydetails

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireLong
import hu.szokemate.citybro.R

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
        fun newInstance(cityId: Long): CityDetailsFragment {
            return CityDetailsFragment().applyArgs {
                putLong(CITY_ID, cityId)
            }
        }
    }

    private var cityId: Long = 0

    private fun initArguments() {
        cityId = requireArguments().requireLong(CITY_ID)
    }

    //endregion
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initArguments()

        // TODO Setup views
    }

    override fun onStart() {
        super.onStart()

        viewModel.load()
    }

    override fun render(viewState: CityDetailsViewState) {
        // TODO Render state
    }

}
