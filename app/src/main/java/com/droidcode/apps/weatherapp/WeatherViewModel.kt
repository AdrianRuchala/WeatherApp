package com.droidcode.apps.weatherapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidcode.apps.weatherapp.data.Weather
import com.droidcode.apps.weatherapp.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    val weatherState = MutableLiveData<Weather?>()

    suspend fun getWeather(city: String){
        viewModelScope.launch {
            weatherState.value = repository.getWeather(city)
        }
    }
}
