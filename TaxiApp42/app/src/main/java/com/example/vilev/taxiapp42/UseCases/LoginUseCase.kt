package com.example.vilev.taxiapp42.UseCases

/**
 * Created by vilev on 12.04.2017.
 */
import com.example.vilev.taxiapp42.AppConfig
import com.example.vilev.taxiapp42.AppConfig.Companion.url
import com.google.gson.JsonParser

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import okhttp3.FormBody
import okhttp3.Request
import okhttp3.Response
import android.R.attr.password
import android.util.Log
import com.example.vilev.taxiapp42.User
//import sun.security.jgss.GSSUtil.login
import okhttp3.HttpUrl
import com.google.gson.Gson
import com.google.gson.GsonBuilder





class LoginUseCase : UseCase<String, LoginUseCase.Parameters>(Schedulers.io()) {
    class Parameters(val login:     String,
                     val password:  String)




    override fun buildObservable(parameters: Parameters): Observable<String> {
        return Observable.create {
            subscribe ->
            val url="http://89.223.29.6:8080/taxi/users/login?login=${parameters.login}&password=${parameters.password}"

            val request = Request.Builder()
                    .url(url)
                    .get()
                    .build()
            val response: String = AppConfig.client.newCall(request).execute().body().string()

            val userObj = JsonParser().parse(response).asJsonObject

            if (!userObj.isJsonNull&&userObj.get("code").asInt==0) {
                val builder = GsonBuilder()
                val gson = builder.create()
                var user : User=gson.fromJson(userObj.get("response"), User::class.java)

                subscribe.onNext(user.login)
                subscribe.onComplete()


            }
        }
    }


}