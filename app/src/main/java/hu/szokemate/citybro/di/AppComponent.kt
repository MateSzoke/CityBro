package hu.szokemate.citybro.di

import co.zsmb.rainbowcake.dagger.RainbowCakeComponent
import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import dagger.Component
import hu.szokemate.citybro.CityBroApplication
import hu.szokemate.citybro.data.db.RoomModule
import hu.szokemate.citybro.data.network.NetworkModule
import hu.szokemate.citybro.util.glide.CustomGlideModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        RainbowCakeModule::class,
        ApplicationModule::class,
        ViewModelModule::class,
        RoomModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : RainbowCakeComponent {

    fun inject(cityBroApplication: CityBroApplication)

    fun inject(customGlideModule: CustomGlideModule)

}
