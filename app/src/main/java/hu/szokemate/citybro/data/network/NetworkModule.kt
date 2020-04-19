package hu.szokemate.citybro.data.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import hu.szokemate.citybro.data.network.model.UrbanAreaDetailDataPoint
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val TELEPORT_API_BASE_URL = "https://api.teleport.org/api/"
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor.apply { httpLoggingInterceptor.level = BODY })
            .addNetworkInterceptor(StethoInterceptor())
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(TELEPORT_API_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().add(
                    DefaultOnDataMismatchAdapter.newFactory(
                        type = UrbanAreaDetailDataPoint::class.java, defaultValue = null
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
