package com.example.vilev.taxiapp42.Activities.DialogueActivity

import android.app.DownloadManager
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.example.vilev.taxiapp42.AppConfig
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import io.reactivex.Observable
import okhttp3.Request
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.sql.DriverManager.getDrivers
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.observers.DisposableObserver
import java.sql.DriverManager.getDrivers
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast






class DialogueActivity : AppCompatActivity() {

    var messagesOut = ArrayList<DialogueItem>(15)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myList = RecyclerView(this)
        val list = generateItems()
        myList.setBackgroundColor(Color.WHITE)


        setContentView(myList)


        val adapter = DialogueListAdapter(list)
        val layoutManager = LinearLayoutManager(this)
        myList.layoutManager = layoutManager
        myList.adapter = adapter
    }


    private fun generateItems(): ArrayList<DialogueItem> {
        var messages = ArrayList<DialogueItem>(15)

        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", true ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", false ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", true ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", false ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", true ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", false ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", true ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", false ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", true ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", false ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", true ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", false ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", true ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", false ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", true ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", false ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", true ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", false ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", true ))
        messages.add(DialogueItem("Пассажир","Водитель","Сообщение", false ))

        return messages
    }

    private fun generateItems(loginUser: String, loginDriver: String): List<DialogueItem> {
        var messages = ArrayList<DialogueItem>(15)
        var url = "http://89.223.29.6:8080/taxi/chats?login_user=$loginUser&login_driver=$loginDriver"

        val request = Request.Builder()
                .url(url)
                .get()
                .build()
        val response: String = AppConfig.client.newCall(request).execute().body().string()
        Log.i("responseMessages","$response")
        val respObj = JsonParser().parse(response).asJsonObject
        if (!respObj.isJsonNull && respObj.get("code").asInt == 0) {
            val gson = GsonBuilder().create()
            val messageList = respObj.get("response").asJsonArray
            for (i in 0..messageList.size())
                messages.add(gson.fromJson(messageList[i], DialogueItem::class.java))
        }
        return messages
    }
}