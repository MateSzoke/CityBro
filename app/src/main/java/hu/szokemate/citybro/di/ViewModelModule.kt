package hu.szokemate.citybro.di

import androidx.lifecycle.ViewModel
import co.zsmb.rainbowcake.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import hu.szokemate.citybro.ui.citydetailscontainer.CityDetailsContainerViewModel
import hu.szokemate.citybro.ui.citydetailscontainer.citydetails.CityDetailsViewModel
import hu.szokemate.citybro.ui.citydetailscontainer.lifequality.LifeQualityViewModel
import hu.szokemate.citybro.ui.citylist.CityListViewModel
import hu.szokemate.citybro.ui.favoritecities.FavoriteCitiesViewModel

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CityListViewModel::class)
    abstract fun cityListViewModel(cityListModel: CityListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CityDetailsViewModel::class)
    abstract fun cityDetailsViewModel(cityDetailsViewModel: CityDetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LifeQualityViewModel::class)
    abstract fun lifeQualityViewModel(lifeQualityViewModel: LifeQualityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavoriteCitiesViewModel::class)
    abstract fun favoriteCitiesViewModel(favoriteCitiesViewModel: FavoriteCitiesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CityDetailsContainerViewModel::class)
    abstract fun cityDetailsContainerViewModel(cityDetailsContainerViewModel: CityDetailsContainerViewModel): ViewModel

}
