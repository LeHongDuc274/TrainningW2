package com.example.paypalui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paypalui.R
import com.example.paypalui.model.Contact
import kotlinx.android.synthetic.main.contact_item.view.*

class ContactAdapter() : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    var listContact : MutableList<Contact> = mutableListOf()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.contact_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = listContact[position]
        holder.itemView.apply {
            iv_item.setImageResource(contact.image)
            tv_item.text = contact.name
        }
    }

    override fun getItemCount(): Int  = listContact.size

    fun setContacts(contacts: MutableList<Contact>){
        this.listContact = contacts
        notifyDataSetChanged()
    }

}