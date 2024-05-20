package com.example.weatherapp.Server

import com.example.weatherapp.model.CityResponseApi
import com.example.weatherapp.model.CurrentResponseApi
import com.example.weatherapp.model.ForecastResponseApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("data/2.5/weather")
     fun getCurrentWeather(
         @Query("lat") lat: Double,
         @Query("lon") lon: Double,
         @Query("units") units: String,
         @Query("appid") ApiKey:String,
    ): Call<CurrentResponseApi>

    @GET("data/2.5/forecast")
    fun getForecastWearhet(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String,
        @Query("appid") ApiKey:String,
    ): Call<ForecastResponseApi>

    @GET("geo/1.0/direct")
    fun getCitiesList(
        @Query("q") q:String,
        @Query("limit") limit:Int,
        @Query("appid") ApiKey: String
    ):Call<CityResponseApi>
}