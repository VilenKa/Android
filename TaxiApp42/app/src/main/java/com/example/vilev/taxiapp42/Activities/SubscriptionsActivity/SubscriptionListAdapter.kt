package com.example.vilev.taxiapp42.Activities.SubscriptionsActivity

/**
 * Created by vilev on 12.04.2017.
 */

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vilev.taxiapp42.R

class SubscriptionListAdapter (private val subs: List<Subscriptions>) : RecyclerView.Adapter<SubscriptionViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriptionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.subs_activity, parent, false)
        return SubscriptionViewHolder(view)
    }
    override fun onBindViewHolder(holder: SubscriptionViewHolder, position: Int) {
        val sub : Subscriptions = subs[position]
        holder.subsDur.setText(sub.Duration.toString()+" месяцев")
        holder.subsPrice.setText(sub.Price.toString()+"руб")
        if (sub.isPurachased== true)
            holder.subsPurch.setText("Подписка куплена")
        else if(sub.isPurachased==false)
            holder.subsPurch.setText("Подписка не куплена")
    }
    override fun getItemCount(): Int { return subs.size }
}