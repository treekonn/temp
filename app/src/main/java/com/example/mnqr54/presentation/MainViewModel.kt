package com.example.mnqr54.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mnqr54.data.api.WeatherModelApi
import com.example.mnqr54.domain.GetWeatherDataUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _weather = MutableLiveData<State<WeatherModelApi>>()
    val weather: LiveData<State<WeatherModelApi>> = _weather

    private val getWeatherDataUseCase = GetWeatherDataUseCase()
    private var job: Job? = null

    fun getWeatherData() {
        job?.cancel()
        job = viewModelScope.launch {
            _weather.value = State.Loading()
            try {
                _weather.value = State.Data(getWeatherDataUseCase.getWeatherData())
            } catch (e: Exception) {
                _weather.value = State.Error(e)
            }
        }
    }
}
