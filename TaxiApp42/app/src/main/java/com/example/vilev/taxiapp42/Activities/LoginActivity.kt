package com.example.vilev.taxiapp42.Activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
//import com.example.vilev.taxiapp42.Activities.DialogActivity.DialogActivity
import com.example.vilev.taxiapp42.Activities.DialogueActivity.DialogueActivity
import com.example.vilev.taxiapp42.Activities.SubscriptionsActivity.SubscriptionActivity
import com.example.vilev.taxiapp42.Activities.DiversListActivity.DriversListActivity
//import com.example.vilev.taxiapp42.MainActivity
import com.example.vilev.taxiapp42.Presenters.Contracts.LoginContract
import com.example.vilev.taxiapp42.Presenters.LoginPresenter
import com.example.vilev.taxiapp42.R
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_main.*




/**
 * Created by vilev on 15.04.2017.
 */
class LoginActivity: AppCompatActivity(), View.OnClickListener, LoginContract.View {

    val presenter = LoginPresenter(this);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.main_loginB.setOnClickListener(this)
        this.main_registB.setOnClickListener(this)
        this.callBtn.setOnClickListener(this)



    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.main_loginB -> {
                presenter.onLogin(this.login_name.text.toString(), this.login_password.text.toString())
            }
            R.id.main_registB -> {
                startActivity(Intent(this, RegistrationActivity::class.java))
            }
            R.id.callBtn->{
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:89511234567")))
            }
        }
    }

    override fun onLoginSuccess(login: String) {
        startActivity(Intent(this, MapActivity::class.java))
    }

    override fun onLoginFailure(errorMessage: String) {
        Log.i("onvloginfail", errorMessage)
    }
}