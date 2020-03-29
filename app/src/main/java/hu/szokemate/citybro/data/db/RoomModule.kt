package hu.szokemate.citybro.data.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    companion object {
        private const val DB_NAME = "citybro-db"
    }

    @Provides
    @Singleton
    fun provideRoomDatabase(context: Context): CityBroDatabase {
        return Room.databaseBuilder(
            context,
            CityBroDatabase::class.java,
            DB_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideCityDao(cityBroDatabase: CityBroDatabase) =
        cityBroDatabase.cityDao()

}