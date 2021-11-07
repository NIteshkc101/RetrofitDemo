package com.example.retrofitdemo.network

import com.example.retrofitdemo.Constants
import com.example.retrofitdemo.model.*
import retrofit2.Call
import retrofit2.http.*

interface Api  {


    @GET(Constants.vehicleList)
    fun getVehicleList(

    ):Call<VehicleListResponseData>


    @POST(Constants.loginUrl)
    fun loginUser(
        @Body body: LoginBody
    ):Call<LoginResponseData>


}