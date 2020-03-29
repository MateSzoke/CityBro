package hu.szokemate.citybro

import co.zsmb.rainbowcake.config.Loggers
import co.zsmb.rainbowcake.config.rainbowCake
import co.zsmb.rainbowcake.dagger.BuildConfig
import co.zsmb.rainbowcake.dagger.RainbowCakeApplication
import co.zsmb.rainbowcake.timber.TIMBER
import hu.szokemate.citybro.di.AppComponent
import hu.szokemate.citybro.di.ApplicationModule
import hu.szokemate.citybro.di.DaggerAppComponent
import timber.log.Timber

class CityBroApplication : RainbowCakeApplication() {

    override lateinit var injector: AppComponent

    override fun setupInjector() {
        injector = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        rainbowCake {
            logger = Loggers.TIMBER
            isDebug = BuildConfig.DEBUG
        }

        Timber.plant(Timber.DebugTree())
    }

}
