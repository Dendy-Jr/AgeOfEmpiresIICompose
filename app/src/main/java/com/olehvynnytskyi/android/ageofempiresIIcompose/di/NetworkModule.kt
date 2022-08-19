package com.olehvynnytskyi.android.ageofempiresIIcompose.di

import com.olehvynnytskyi.android.ageofempiresIIcompose.BuildConfig
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.api.AgeOfEmpiresIIApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideAgeOfEmpiresIIApi(): AgeOfEmpiresIIApi {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .client(client)
            .build()
            .create(AgeOfEmpiresIIApi::class.java)
    }
}