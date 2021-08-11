package com.example.paypalui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paypalui.R
import kotlinx.android.synthetic.main.list_card_item.view.*

class ListCardAdapter() : RecyclerView.Adapter<ListCardAdapter.Viewholder>() {

    var cards : MutableList<Card> = mutableListOf()
    class Viewholder(itemView:View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCardAdapter.Viewholder {
        return Viewholder(LayoutInflater.from(parent.context).inflate(R.layout.list_card_item,parent,false))
    }

    override fun onBindViewHolder(holder: ListCardAdapter.Viewholder, position: Int) {
        val card = cards[position]
        holder.itemView.apply {
            iv_item_1.setImageDrawable(resources.getDrawable(card.image,null))
            tv_item_1.text = card.type
            tv_item_2.text = card.id
        }
    }

    override fun getItemCount(): Int = cards.size
}

data class Card(val image:Int,val type:String,val id:String)