package com.example.paypalui.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
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

            btn_create.isVisible = false
            btn_delete.isVisible = false
            btn_show_menu.setOnClickListener {
                if (card.isShowMenu == false) {
                    btn_show_menu.background = resources.getDrawable(R.color.brige_blue, null)
                    btn_show_menu.setImageDrawable(resources.getDrawable(R.drawable.ic_path,null))
                    btn_create.isVisible = true
                    btn_delete.isVisible = true
                    card.isShowMenu = true
                } else{
                    btn_show_menu.background = resources.getDrawable(R.color.white_three, null)
                    btn_show_menu.setImageDrawable(resources.getDrawable(R.drawable.ic_more_vert_black_18_dp,null))
                    btn_create.isVisible = false
                    btn_delete.isVisible = false
                    card.isShowMenu = false
                }
            }
        }
    }

    override fun getItemCount(): Int = cards.size
}

data class Card(val image:Int,val type:String,val id:String,var isShowMenu:Boolean)