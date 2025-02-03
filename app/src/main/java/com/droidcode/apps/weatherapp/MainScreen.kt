package com.droidcode.apps.weatherapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun WeatherScreen(modifier: Modifier, viewModel: WeatherViewModel) {
    Column(
        modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(R.string.app_name))
        HorizontalDivider(Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
        )
        SearchBar(Modifier, viewModel)
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
