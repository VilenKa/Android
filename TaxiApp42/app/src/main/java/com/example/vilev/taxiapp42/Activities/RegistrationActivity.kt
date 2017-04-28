package com.example.vilev.taxiapp42.Activities

/**
 * Created by vilev on 12.04.2017.
 */
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.orhanobut.hawk.Hawk
//import com.example.vilev.taxiapp42.MainActivity
import com.example.vilev.taxiapp42.Presenters.Contracts.RegistrationContract
import com.example.vilev.taxiapp42.Presenters.RegistrationPresenter
import com.example.vilev.taxiapp42.R
import kotlinx.android.synthetic.main.registration_activity.*

/**
 * Created by vilev on 27.03.2017.
 */
class RegistrationActivity : AppCompatActivity(), View.OnClickListener, RegistrationContract.View {


    val presenter = RegistrationPresenter(this)
    var image: String = "avatar"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_activity)
        this.regist_registB.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.regist_registB-> {
                presenter.onRegistration(
                        this.regist_login.text.toString(),
                        this.regist_password.text.toString(),
                        this.regist_surname.text.toString(),
                        this.regist_name.text.toString(),
                        this.regist_faculty.text.toString(),
                        image)
                startActivity(Intent(this, LoginActivity::class.java))
            }
            }
        }

    override fun onRegistrationFailure(errorMessage: String) {
    }

    override fun onRegistrationSuccess(token: String) {
        startActivity(Intent(this, WaitingActivity::class.java))
    }



}
