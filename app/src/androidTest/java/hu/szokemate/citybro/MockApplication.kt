package hu.szokemate.citybro

import hu.szokemate.citybro.di.ApplicationModule

class MockApplication : CityBroApplication() {

    override fun setupInjector() {
        injector = DaggerAppTestComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

}