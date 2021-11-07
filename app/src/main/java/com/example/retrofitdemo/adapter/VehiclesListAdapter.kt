package com.example.retrofitdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitdemo.R
import com.example.retrofitdemo.model.VehicleResponse
import kotlinx.android.synthetic.main.vehicle_sample_layout.view.*

class VehiclesListAdapter(
    private val vehiclesList: List<VehicleResponse> = ArrayList()
):RecyclerView.Adapter<VehiclesListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VehiclesListAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.vehicle_sample_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: VehiclesListAdapter.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                holder.bind(vehiclesList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return vehiclesList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val chassisNumber: TextView = itemView.chassisNumber
        private val color = itemView.color
        private val model = itemView.model
        private val photoCount = itemView.photo_count
        private val purchaseDate = itemView.purchase_date
        private val purchaseDestination = itemView.purchase_destination
        private val referenceNumber = itemView.reference_number
        private val salesPerson = itemView.sales_person
        private val vehicleImage = itemView.vehicle_image


    fun bind(vehicle: VehicleResponse) {
        chassisNumber.text = vehicle.chassis_number
        color.text = vehicle.color
        model.text = vehicle.model
        photoCount.text = vehicle.photo_count.toString()
        purchaseDate.text = vehicle.purchase_date
        purchaseDestination.text = vehicle.purchase_destination
        referenceNumber.text = vehicle.reference_number
        salesPerson.text = vehicle.sales_person
        if (vehicleImage != null){
            Glide.with(itemView.context)

                .load(vehicle.vehicle_image)
//                    .load("https://storage.googleapis.com/signedinurl.appspot.com/Garages/16132980424051000.svg%2Bxml")
//                    .load("https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/digital_ocean.png")
                .into(vehicleImage)
        }


    }
}


    }