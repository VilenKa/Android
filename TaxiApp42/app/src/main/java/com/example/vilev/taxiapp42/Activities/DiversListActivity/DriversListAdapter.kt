package com.example.vilev.taxiapp42.Activities.DiversListActivity

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vilev.taxiapp42.Activities.ConfirmActivity
import com.example.vilev.taxiapp42.Activities.DialogueActivity.DialogueActivity
import com.example.vilev.taxiapp42.Activities.LoginActivity
//import com.example.vilev.taxiapp42.MainActivity
import com.example.vilev.taxiapp42.R

/**
 * Created by vilev on 13.04.2017.
 */
class DriversListAdapter(private val items: List<Driver>) : RecyclerView.Adapter<DriversListViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriversListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.rate_activity, parent, false)
        view.setOnClickListener(object : View.OnClickListener {
            override fun  onClick(view: View) {
                view.getContext().startActivity(Intent(view.context, ConfirmActivity::class.java))
            }
        })
        return DriversListViewHolder(view)
    }
    override fun onBindViewHolder(holder: DriversListViewHolder, position: Int) {
        val driver : Driver = items[position]
        holder.driverf_name.setText(driver.f_name)
        holder.driverl_name.setText(driver.l_name)
        holder.driver_car.setText(driver.car)
        holder.driver_login.setText(driver.login)
        holder.driver_rating.setText(driver.rating)
        holder.chatBtn.setOnClickListener {
            v->
            v.getContext().startActivity(Intent(v.context, DialogueActivity::class.java)) }
    }
    override fun getItemCount(): Int { return items.size }
}