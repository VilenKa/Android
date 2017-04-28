package com.example.vilev.taxiapp42.Activities.DiversListActivity

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.vilev.taxiapp42.R

/**
 * Created by vilev on 13.04.2017.
 */
class DriversListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    internal val driverf_name :     TextView
    internal val driverl_name :     TextView
    internal val driver_car :       TextView
    internal val driver_login :     TextView
    internal val driver_rating :    TextView
    internal val chatBtn :          Button

    init {
        driverf_name = itemView.findViewById(R.id.driver_f_name) as     TextView
        driverl_name = itemView.findViewById(R.id.driver_l_name) as     TextView
        driver_car = itemView.findViewById(R.id.driver_car) as          TextView
        driver_login = itemView.findViewById(R.id.driver_login) as      TextView
        driver_rating = itemView.findViewById(R.id.driver_rating) as    TextView
        chatBtn = itemView.findViewById(R.id.chatBTN) as                Button

    }
}