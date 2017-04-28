package com.example.vilev.taxiapp42.Activities.DialogueActivity

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.vilev.taxiapp42.R
import kotlinx.android.synthetic.main.dialog2.*

/**
 * Created by vilev on 24.04.2017.
 */
class DialogueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    internal val passengerName : TextView
    internal val passengerMessage : TextView
    internal val driverName : TextView
    internal val driverMessage : TextView

    init{
        passengerName = itemView.findViewById(R.id.passengerNameTV) as TextView
        passengerMessage = itemView.findViewById(R.id.passengerMessageTV) as TextView
        driverName = itemView.findViewById(R.id.driverNameTV) as TextView
        driverMessage = itemView.findViewById(R.id.driverMessageTV) as TextView
    }
}