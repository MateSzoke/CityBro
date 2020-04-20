package hu.szokemate.citybro

import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import dagger.Component
import hu.szokemate.citybro.data.db.DiskModule
import hu.szokemate.citybro.data.db.RoomModule
import hu.szokemate.citybro.data.network.NetworkModule
import hu.szokemate.citybro.di.AppComponent
import hu.szokemate.citybro.di.ApplicationModule
import hu.szokemate.citybro.di.ViewModelModule
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
interface AppTestComponent : AppComponent {


}