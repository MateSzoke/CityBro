package hu.szokemate.citybro.ui.citydetailscontainer

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import hu.szokemate.citybro.ui.citydetailscontainer.citydetails.CityDetailsFragment
import hu.szokemate.citybro.ui.citydetailscontainer.lifequality.LifeQualityFragment

class CityDetailsPagerAdapter(fragment: Fragment, val cityId: String) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CityDetailsFragment.newInstance(cityId = cityId)
            1 -> LifeQualityFragment.newInstance(cityId = cityId)
            else -> throw IllegalArgumentException("Wrong fragment position")
        }
    }
}