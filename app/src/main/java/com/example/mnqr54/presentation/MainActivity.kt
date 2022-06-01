package com.example.mnqr54.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.mnqr54.R
import com.example.mnqr54.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObservers()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]


    }

    private fun initObservers() {
        viewModel.weather.observe(this) {
            when (it) {

                is State.Data -> {
                    binding.tvName.text = it.data.name
                    binding.tvTemperature.text =
                        getString(R.string.tv_temperature, it.data.main.temp.toString())
                    binding.tvFeelsLike.text =
                        getString(R.string.tv_feels_like, it.data.main.feels_like.toString())
                    binding.tvDescription.text =
                        getString(R.string.tv_description, it.data.weather[0].description)
                    binding.tvSpeed.text =
                        getString(R.string.tv_speed, it.data.wind.speed.toString())
                    binding.tvPressure.text =
                        getString(R.string.tv_pressure, it.data.main.pressure.toString())
                    binding.tvHumidity.text =
                        getString(R.string.tv_humidity, it.data.main.humidity.toString())
                    binding.weatherInfoGroup.isVisible = true
                    binding.progressBar.isVisible = false
                }
                is State.Error -> {
                    binding.weatherInfoGroup.isVisible = false
                    binding.progressBar.isVisible = false
                    Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
                }
                is State.Loading ->  {
                    binding.weatherInfoGroup.isVisible = false
                    binding.progressBar.isVisible = true
                }
            }
        }

        binding.btRefresh.setOnClickListener {
            viewModel.getWeatherData()
        }
    }

}