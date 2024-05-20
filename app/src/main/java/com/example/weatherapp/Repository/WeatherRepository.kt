package com.example.weatherapp.Repository

import com.example.weatherapp.Server.ApiServices

class WeatherRepository (val api:ApiServices){
    fun getCurrentWeather(lat:Double,lng:Double,unit:String)=
        api.getCurrentWeather(lat,lng,unit,"51d803c52e7e9e9688bfa6614339e318")

    fun getForecastWeather(lat:Double,lng:Double,unit:String)=
        api.getForecastWearhet(lat,lng,unit,"51d803c52e7e9e9688bfa6614339e318")
}