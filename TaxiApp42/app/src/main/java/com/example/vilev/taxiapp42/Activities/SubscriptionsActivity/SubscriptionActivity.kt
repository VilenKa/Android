package com.example.vilev.taxiapp42.Activities.SubscriptionsActivity

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

/**
 * Created by vilev on 04.04.2017.
 */
class SubscriptionActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myList = RecyclerView(this)
        val list = generateSubscriptions()
        myList.setBackgroundColor(Color.WHITE)

        setContentView(myList)

        val adapter = SubscriptionListAdapter(list)
        val layoutManager = LinearLayoutManager(this)
        myList.layoutManager = layoutManager
        myList.adapter = adapter
    }

    private fun generateSubscriptions() : List<Subscriptions>
    {
        var subs = ArrayList<Subscriptions>(15)///

        subs.add(Subscriptions(5, 29.5f, false))
        subs.add(Subscriptions(6, 265.5f, false))
        subs.add(Subscriptions(7, 5.5f, true))
        subs.add(Subscriptions(8, 5.5f, true))
        return subs
    }
}