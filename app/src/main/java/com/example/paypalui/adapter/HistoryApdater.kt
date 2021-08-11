package com.example.paypalui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paypalui.R
import com.example.paypalui.model.History
import kotlinx.android.synthetic.main.history_item.view.*

class HistoryApdater() : RecyclerView.Adapter<HistoryApdater.ViewHoler>() {

    var historys: MutableList<History> = mutableListOf()

    class ViewHoler(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoler {

        return ViewHoler(
            LayoutInflater.from(parent.context).inflate(R.layout.history_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHoler, position: Int) {
        val history = historys[position]
        if (history.amount > 0) {
            holder.itemView.rv_history_tv_3.setTextColor(Color.parseColor("#00c55B"))
        }
        holder.itemView.apply {
            rv_history_tv_1.text = history.name
            rv_history_tv_2.text = history.state
            rv_history_tv_3.text = history.amount.toString() + "€"
        }

    }

    override fun getItemCount(): Int = historys.size
}