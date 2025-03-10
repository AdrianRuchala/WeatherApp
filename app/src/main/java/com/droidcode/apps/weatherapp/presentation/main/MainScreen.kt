package com.droidcode.apps.weatherapp.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.droidcode.apps.weatherapp.R
import com.droidcode.apps.weatherapp.presentation.viewmodels.WeatherViewModel
import com.droidcode.apps.weatherapp.domain.models.CurrentCondition
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun WeatherScreen(modifier: Modifier, viewModel: WeatherViewModel) {
    val weather by viewModel.weather.observeAsState()
    Column(
        modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(R.string.app_name), style = MaterialTheme.typography.titleLarge)
        HorizontalDivider(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )
        SearchBar(Modifier, viewModel)
        weather?.let { WeatherData(Modifier, it) }
    }
}

@Composable
fun SearchBar(modifier: Modifier, viewModel: WeatherViewModel) {
    var city by remember { mutableStateOf("") }
    Column(
        modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = city,
            onValueChange = { city = it },
            modifier
                .fillMaxWidth()
                .padding(8.dp),
            label = { Text(stringResource(R.string.type_city)) })

        Button(onClick = {
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.getWeather(city)
            }
        }) {
            Row {
                Icon(imageVector = Icons.Filled.Search, contentDescription = null)
                Text(stringResource(R.string.search))
            }
        }
    }
}

@Composable
fun WeatherData(modifier: Modifier, currentConditionState: CurrentCondition) {
    Column(
        modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        if (currentConditionState.temp_C?.isNotEmpty() == true) {
            Row(modifier.fillMaxWidth()) {
                Text(
                    stringResource(R.string.temperature),
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier.padding(2.dp))
                Text(currentConditionState.temp_C)
            }
        }

        if (currentConditionState.weatherDesc?.isNotEmpty() == true) {
            Row(modifier.fillMaxWidth()) {
                Text(
                    stringResource(R.string.weather_desc),
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier.padding(2.dp))
                currentConditionState.weatherDesc.forEach { weatherDesc ->
                    weatherDesc.value?.let { Text(it) }
                }
            }
        }

        if (currentConditionState.feelsLikeC?.isNotEmpty() == true) {
            Row(modifier.fillMaxWidth()) {
                Text(
                    stringResource(R.string.temperature_feels_like),
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier.padding(2.dp))
                Text(currentConditionState.feelsLikeC)
            }
        }

        if (currentConditionState.windspeedKmph?.isNotEmpty() == true) {
            Row(modifier.fillMaxWidth()) {
                Text(
                    stringResource(R.string.wind_speed),
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier.padding(2.dp))
                Text(currentConditionState.windspeedKmph)
            }
        }

        if (currentConditionState.cloudcover?.isNotEmpty() == true) {
            Row(modifier.fillMaxWidth()) {
                Text(
                    stringResource(R.string.cloud_cover),
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier.padding(2.dp))
                Text(currentConditionState.cloudcover)
            }
        }

        if (currentConditionState.humidity?.isNotEmpty() == true) {
            Row(modifier.fillMaxWidth()) {
                Text(
                    stringResource(R.string.humidity),
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier.padding(2.dp))
                Text(currentConditionState.humidity)
            }
        }

    }
}
