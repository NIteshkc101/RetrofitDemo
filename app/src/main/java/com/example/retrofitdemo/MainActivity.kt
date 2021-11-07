package com.example.retrofitdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.retrofitdemo.model.*
import com.example.retrofitdemo.network.RetroClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var vehiclesList: ArrayList<VehicleResponse>

    private lateinit var vehicleButton: Button
    private lateinit var loginButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vehicleButton = findViewById(R.id.vehicleButton)
        loginButton = findViewById(R.id.loginButton)

        vehicleButton.setOnClickListener(this)
        loginButton.setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        if (view == vehicleButton) {

            val intent = Intent(this@MainActivity, VehicleListActivity::class.java)
            startActivity(intent)


        }
        if (view == loginButton) {

            val loginBody = LoginBody("janakphuyal12+26@gmail.com", "janak123")

            RetroClient.getApiService().loginUser(loginBody)
                .enqueue(object : Callback<LoginResponseData> {
                    override fun onResponse(
                        call: Call<LoginResponseData>,
                        response: Response<LoginResponseData>
                    ) {


                        if (response.isSuccessful && response.code() == 200) {
                            val accessToken = response.body()?.data?.accessToken
                            val refreshToken = response.body()?.data?.refreshToken
                            val expiresIn = response.body()?.data?.expiresIn
                            val tokenType = response.body()?.data?.tokenType


                            val intent = Intent(this@MainActivity, LoginActivity::class.java)
                            intent.putExtra("accessToken", accessToken)
                            intent.putExtra("refreshToken", refreshToken)
                            intent.putExtra("expiresIn", expiresIn)
                            intent.putExtra("tokenType", tokenType)
                            startActivity(intent)
                        }
                    }


                    override fun onFailure(call: Call<LoginResponseData>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "Login Failed", Toast.LENGTH_SHORT).show()
                    }

                })
        }
    }
}