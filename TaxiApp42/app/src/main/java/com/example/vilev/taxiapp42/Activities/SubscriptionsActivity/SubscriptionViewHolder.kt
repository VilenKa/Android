package com.example.vilev.taxiapp42.Activities.SubscriptionsActivity


import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.vilev.taxiapp42.R


/**
 * Created by vilev on 27.03.2017.
 */
class SubscriptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)   {

    internal val subsDur: TextView
    internal val subsPrice: TextView
    internal val subsPurch: TextView

    init {
        subsDur = itemView.findViewById(R.id.subsDur) as TextView
        subsPrice = itemView.findViewById(R.id.subsPrice) as TextView
        subsPurch = itemView.findViewById(R.id.subsPurch) as TextView
    }
}