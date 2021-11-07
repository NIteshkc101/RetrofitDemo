package com.example.retrofitdemo.model

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.adapter.VehiclesListAdapter
import com.example.retrofitdemo.network.RetroClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VehicleListActivity : AppCompatActivity() {
    private lateinit var vehiclesList :ArrayList<VehicleResponse>
    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_list)
        recyclerView= findViewById(R.id.recyclerViewVehicles)

//        val vehicleList = intent.getSerializableExtra("list") as ArrayList<*>



        loadData()

    }

    private fun loadData() {
        RetroClient.getApiService().getVehicleList()
            .enqueue(object : Callback<VehicleListResponseData> {
                override fun onResponse(
                    call: Call<VehicleListResponseData>,
                    response: Response<VehicleListResponseData>
                ) {
                    if (response.isSuccessful && response.code() == 200) {
                        vehiclesList = response.body()?.data!!
                        recyclerView.layoutManager = LinearLayoutManager(this@VehicleListActivity,LinearLayoutManager.VERTICAL,false)

                        recyclerView.adapter = VehiclesListAdapter(vehiclesList)




                    }

                }

                override fun onFailure(call: Call<VehicleListResponseData>, t: Throwable) {
                    Toast.makeText(
                        this@VehicleListActivity,
                        "Fetching Vehicle list Failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            })


    }
}