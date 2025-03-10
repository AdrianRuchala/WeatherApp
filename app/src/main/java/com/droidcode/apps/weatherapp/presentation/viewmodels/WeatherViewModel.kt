package com.droidcode.apps.weatherapp.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidcode.apps.weatherapp.domain.models.CurrentCondition
import com.droidcode.apps.weatherapp.domain.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {
    private val currentConditionState = MutableLiveData<CurrentCondition?>()
    val weather: LiveData<CurrentCondition?> = currentConditionState

    fun getWeather(city: String){
        viewModelScope.launch {
            val response = repository.getWeather(city)
            currentConditionState.value = response.current_condition.firstOrNull()
        }
    }
}
