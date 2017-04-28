package com.example.vilev.taxiapp42.Activities.DiversListActivity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.vilev.taxiapp42.Activities.ConfirmActivity
import com.example.vilev.taxiapp42.AppConfig
import com.example.vilev.taxiapp42.R
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import okhttp3.Request

//import kotlinx.android.synthetic.main.rate_activity.*

/**
 * Created by vilev on 13.04.2017.
 */
class DriversListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myList = RecyclerView(this)
        val list = generateItems()
        val list1 =generateItems(2,0)
        myList.setOnClickListener(object : View.OnClickListener {
            override fun  onClick(view: View) {
                view.getContext().startActivity(Intent(view.context, ConfirmActivity::class.java))
            }
        })
        myList.setBackgroundColor(Color.WHITE)

        setContentView(myList)

        val adapter = DriversListAdapter(list)
        val layoutManager = LinearLayoutManager(this)
        myList.layoutManager = layoutManager
        myList.adapter = adapter
    }

    private fun generateItems(): List<Driver> {
        var drivers = ArrayList<Driver>(15)
        drivers.add(Driver("Имя","Фамилия","Логин","Машина","Рейтинг"))
        drivers.add(Driver("Имя","Фамилия","Логин","Машина","Рейтинг"))
        drivers.add(Driver("Имя","Фамилия","Логин","Машина","Рейтинг"))
        drivers.add(Driver("Имя","Фамилия","Логин","Машина","Рейтинг"))
        drivers.add(Driver("Имя","Фамилия","Логин","Машина","Рейтинг"))
        drivers.add(Driver("Имя","Фамилия","Логин","Машина","Рейтинг"))
        drivers.add(Driver("Имя","Фамилия","Логин","Машина","Рейтинг"))
        drivers.add(Driver("Имя","Фамилия","Логин","Машина","Рейтинг"))
        drivers.add(Driver("Имя","Фамилия","Логин","Машина","Рейтинг"))
        drivers.add(Driver("Имя","Фамилия","Логин","Машина","Рейтинг"))
        drivers.add(Driver("Имя","Фамилия","Логин","Машина","Рейтинг"))
        drivers.add(Driver("Имя","Фамилия","Логин","Машина","Рейтинг"))
        drivers.add(Driver("Имя","Фамилия","Логин","Машина","Рейтинг"))
        drivers.add(Driver("Имя","Фамилия","Логин","Машина","Рейтинг"))

        return drivers
    }




    private fun generateItems(count: Int, offset :Int ): List<Driver> {

        var drivers = ArrayList<Driver>(15)
        var url = "http://89.223.29.6:8080/taxi/drivers?count=$count&offset=$offset"

        val request = Request.Builder()
                .url(url)
                .get()
                .build()
        val response: String = AppConfig.client.newCall(request).execute().body().string()
        Log.i("drivers", "$response")
        val respObj = JsonParser().parse(response).asJsonObject

        if (!respObj.isJsonNull&&respObj.get("code").asInt==0){
            val gson=GsonBuilder().create()
            val driverList = respObj.get("response").asJsonArray
            for(i in 0..driverList.size())
                drivers.add(gson.fromJson(driverList[i], Driver::class.java))
        }
        return drivers

    }
}
