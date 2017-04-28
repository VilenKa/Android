package com.example.vilev.taxiapp42.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.vilev.taxiapp42.R
import kotlinx.android.synthetic.main.confirm_activity.*

/**
 * Created by vilev on 17.04.2017.
 */
class ConfirmActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirm_activity)
        this.confirmB.setOnClickListener(this)
        this.backB.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.confirmB-> {
                startActivity(Intent(this, WaitingActivity::class.java))
            }
            R.id.backB ->{
                startActivity(Intent(this, MapActivity::class.java))
            }
        }
    }

}