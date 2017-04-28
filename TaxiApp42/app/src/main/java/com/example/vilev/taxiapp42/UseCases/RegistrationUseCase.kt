package com.example.vilev.taxiapp42.UseCases

/**
 * Created by vilev on 12.04.2017.
 */
import android.util.Log
import com.google.gson.JsonParser
import com.example.vilev.taxiapp42.AppConfig
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import okhttp3.FormBody
import okhttp3.Request
import okhttp3.Response
/**
 * Created by vilev on 09.04.2017.
 */
class RegistrationUseCase : UseCase<String, RegistrationUseCase.Parameters>(Schedulers.io()){
    class Parameters(val surname:   String,
                     val name:      String,
                     val faculty:   String,
                     val login:     String,
                     val password:  String,
                     val avatar:    String)

    override fun buildObservable(parameters: Parameters): Observable<String> {
        return Observable.create {
            subscriber->
            val body = FormBody.Builder()
                    .add("f_name", parameters.name)
                    .add("l_name", parameters.surname)
                    .add("faculty", parameters.faculty)
                    .add("login", parameters.login)
                    .add("password", parameters.password)
                    .add("photo", parameters.avatar)
                    .build()
            val request= Request.Builder().url(AppConfig.url+"users/register").post(body).build()

            val response:String= AppConfig.client.newCall(request).execute().body().string()
            Log.i("resp",response)
            val userObj = JsonParser().parse(response).asJsonObject

            if (!userObj.isJsonNull) {
                subscriber.onNext(userObj.get("f_name").asString)
                subscriber.onComplete()
               // subscriber.onError(Throwable(userObj.get("message").asString))

            }
        }

    }
}
