package hu.szokemate.citybro.di

import co.zsmb.rainbowcake.dagger.RainbowCakeComponent
import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import dagger.Component
import hu.szokemate.citybro.data.db.RoomModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        RainbowCakeModule::class,
        ApplicationModule::class,
        ViewModelModule::class,
        RoomModule::class
    ]
)
interface AppComponent : RainbowCakeComponent
