package com.example.weatherk

import android.util.Log
import com.example.weatherk.service.OpenWeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RetrofitModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        var okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor {
            var request = it.request()
            var url = request.url().newBuilder().addQueryParameter(API_TOKEN_KEY, API_TOKEN).build()
            Log.e("here", "here in RetrofitModule, url = " + url.toString())
            it.proceed(request.newBuilder().url(url).build())
        }
        return okHttpClientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().client(okHttpClient).baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    fun provideOpenWeatherService(retrofit: Retrofit): OpenWeatherService {
        return retrofit.create(OpenWeatherService::class.java)
    }


    companion object {
        const val API_TOKEN_KEY = "APPID"
        const val API_TOKEN = "a420ec9b6936d9212ca1d70b60eacf3d"
        const val BASE_URL = "https://api.openweathermap.org"
    }
}