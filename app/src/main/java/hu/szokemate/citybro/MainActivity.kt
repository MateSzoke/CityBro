package hu.szokemate.citybro

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import hu.szokemate.citybro.ui.citylist.CityListFragment

class MainActivity : SimpleNavActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigator.add(CityListFragment())
        }
    }

}
