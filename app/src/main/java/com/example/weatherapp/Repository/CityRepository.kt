package com.example.weatherapp.Repository

import com.example.weatherapp.Server.ApiServices

class CityRepository(val api:ApiServices) {
    fun getCities(q:String,limit:Int)=
        api.getCitiesList(q,limit,"51d803c52e7e9e9688bfa6614339e318")
}