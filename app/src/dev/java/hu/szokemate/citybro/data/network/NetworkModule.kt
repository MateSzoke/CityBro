package hu.szokemate.citybro.data.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import hu.szokemate.citybro.BuildConfig
import hu.szokemate.citybro.data.network.model.NetworkUrbanAreaDetailDataPoint
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .apply {
                if (BuildConfig.DEBUG) {
                    addNetworkInterceptor(StethoInterceptor())

                    val loggingInterceptor = HttpLoggingInterceptor()
                    loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                    addInterceptor(loggingInterceptor)
                }
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.TELEPORT_API_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().add(
                    DefaultOnDataMismatchAdapter.newFactory(
                        type = NetworkUrbanAreaDetailDataPoint::class.java, defaultValue = null
                    )
                ).build()
            )
        )
        .build()

    @Provides
    @Singleton
    fun provideServiceManagerAPI(retrofit: Retrofit): TeleportAPI =
        retrofit.create(TeleportAPI::class.java)

}
