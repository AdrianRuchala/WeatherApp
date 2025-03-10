package com.droidcode.apps.weatherapp.di

import com.droidcode.apps.weatherapp.data.remote.WeatherApi
import com.droidcode.apps.weatherapp.data.repository.WeatherRepositoryImpl
import com.droidcode.apps.weatherapp.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideWeatherRepository(api: WeatherApi): WeatherRepository {
        return WeatherRepositoryImpl(api)
    }
}
