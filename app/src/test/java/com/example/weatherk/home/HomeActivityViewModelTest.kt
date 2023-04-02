package com.example.weatherk.home

import com.example.weatherk.repository.OpenWeatherRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.MockitoRule
import org.mockito.junit.MockitoTestRule
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyBlocking

@RunWith(MockitoJUnitRunner::class)
class HomeActivityViewModelTest {

    private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @Mock
    lateinit var openWeatherRepository: OpenWeatherRepository

    private lateinit var homeActivityViewModel: HomeActivityViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)

        homeActivityViewModel = HomeActivityViewModel(openWeatherRepository)
    }

    @Test
    fun init() {
        verifyBlocking(openWeatherRepository, times(1)) {
            getWeather(44.34, 10.99)
        }
    }
}