package com.example.vilev.taxiapp42.Activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
//import com.example.vilev.taxiapp42.MainActivity
import com.example.vilev.taxiapp42.R
import kotlinx.android.synthetic.main.waiting_activity.*

/**
 * Created by vilev on 17.04.2017.
 */
class WaitingActivity: AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.waiting_activity)
        this.oddB.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.oddB-> {
                startActivity(Intent(this, MapActivity::class.java))
            }
        }
    }

}