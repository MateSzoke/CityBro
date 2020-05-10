package hu.szokemate.citybro.ui.citydetailscontainer.lifequality

import android.os.Bundle
import android.text.Html
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.applyArgs
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.navigation.extensions.requireString
import hu.szokemate.citybro.R
import hu.szokemate.citybro.domain.model.ScoreData
import kotlinx.android.synthetic.main.fragment_life_quality.*

class LifeQualityFragment : RainbowCakeFragment<LifeQualityViewState, LifeQualityViewModel> {

    private lateinit var scoreAdapter: ScoreAdapter

    override fun provideViewModel() = getViewModelFromFactory()
    override fun getViewResource() = R.layout.fragment_life_quality

    //region Arguments
    @Suppress("ConvertSecondaryConstructorToPrimary")
    @Deprecated(
        message = "Use newInstance instead",
        replaceWith = ReplaceWith("LifeQualityFragment.newInstance()")
    )
    constructor()

    companion object {
        private const val CITY_ID = "SOME_ID"

        @Suppress("DEPRECATION")
        fun newInstance(cityId: String): LifeQualityFragment {
            return LifeQualityFragment().applyArgs {
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
        scoreAdapter = ScoreAdapter()
    }

    override fun onStart() {
        super.onStart()

        viewModel.load(cityId)
    }

    override fun render(viewState: LifeQualityViewState) {
        when (viewState) {
            Loading -> {
            }
            is LifeQualityReady -> showScores(viewState.scoreData)
        }.exhaustive
    }

    private fun showScores(scoreData: ScoreData) {
        @Suppress("DEPRECATION")
        scoreSummaryText.text = Html.fromHtml(scoreData.summary)
        scoreAdapter.submitList(scoreData.categories)
        scoreList.adapter = scoreAdapter
    }

}
