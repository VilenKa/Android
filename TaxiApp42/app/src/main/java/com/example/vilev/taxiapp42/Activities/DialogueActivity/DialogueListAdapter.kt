package com.example.vilev.taxiapp42.Activities.DialogueActivity

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vilev.taxiapp42.Activities.ConfirmActivity
import com.example.vilev.taxiapp42.Activities.RegistrationActivity
import com.example.vilev.taxiapp42.R

/**
 * Created by vilev on 24.04.2017.
 */
class DialogueListAdapter(private val items: ArrayList<DialogueItem>) : RecyclerView.Adapter<DialogueViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DialogueViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.dialog2, parent, false)
        view.setOnClickListener(object : View.OnClickListener {
            override fun  onClick(view: View) {
                view.getContext().startActivity(Intent(view.context, ConfirmActivity::class.java))
            }
        })
        return DialogueViewHolder(view)
    }
    override fun onBindViewHolder(holder: DialogueViewHolder, position: Int) {
        val dialogueItem : DialogueItem = items[position]
        holder.passengerName.setText(dialogueItem.loginUser)
        holder.driverName.setText(dialogueItem.loginDriver)
        if(dialogueItem.fromDriver==true) {
            holder.driverMessage.setText(dialogueItem.message)
        }
        else {
            holder.passengerMessage.setText(dialogueItem.message)
        }

    }
    override fun getItemCount(): Int { return items.size }
}