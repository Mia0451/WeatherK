package com.example.weatherk.home

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.weatherk.R
import com.example.weatherk.repository.OpenWeatherRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity: AppCompatActivity() {

    @Inject lateinit var openWeatherRepository: OpenWeatherRepository
    lateinit var homeActivityViewModel: HomeActivityViewModel

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeActivityViewModel = ViewModelProvider(this)[HomeActivityViewModel::class.java]

        setContentView(R.layout.activity_home)
        textView = findViewById(R.id.text_view)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                homeActivityViewModel.getWeatherResponseFlow().catch {

                }.collect {
                    textView.text = it.toString()
                }
            }
        }
    }
}