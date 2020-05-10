package hu.szokemate.citybro.ui.citydetailscontainer


import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.applyArgs
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.navigation.extensions.requireString
import co.zsmb.rainbowcake.navigation.navigator
import com.google.android.material.tabs.TabLayoutMediator
import hu.szokemate.citybro.R
import kotlinx.android.synthetic.main.back_button_toolbar.*
import kotlinx.android.synthetic.main.fragment_city_details_container.*

class CityDetailsContainerFragment :
    RainbowCakeFragment<CityDetailsContainerViewState, CityDetailsContainerViewModel> {

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_city_details_container

    //region Arguments
    @Suppress("ConvertSecondaryConstructorToPrimary")
    @Deprecated(
        message = "Use newInstance instead",
        replaceWith = ReplaceWith("CityDetailsContainerFragment.newInstance()")
    )
    constructor()

    companion object {
        private const val CITY_ID = "SOME_ID"

        @Suppress("DEPRECATION")
        fun newInstance(cityId: String): CityDetailsContainerFragment {
            return CityDetailsContainerFragment().applyArgs {
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

        toolbar.setNavigationOnClickListener { navigator?.pop() }

        viewpager.adapter =
            CityDetailsPagerAdapter(
                fragment = this,
                cityId = cityId
            )

        TabLayoutMediator(tabs, viewpager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = when (position) {
                    0 -> getString(R.string.city_details_tab_title)
                    1 -> getString(R.string.life_quality_tab_title)
                    else -> throw IllegalArgumentException("Wrong tab position")
                }
            }).attach()
    }

    override fun onStart() {
        super.onStart()

        viewModel.load(cityId)
    }

    override fun render(viewState: CityDetailsContainerViewState) {
        when (viewState) {
            is CityDetailsContainerReady -> {
                toolbar.title = viewState.cityName
            }
        }.exhaustive
    }

}
