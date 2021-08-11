package com.example.paypalui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paypalui.adapter.Card
import com.example.paypalui.adapter.ListCardAdapter
import kotlinx.android.synthetic.main.activity_cards.*
import kotlinx.android.synthetic.main.tool_bar_2.*

class CardsActivity : AppCompatActivity() {
    lateinit var cards : MutableList<Card>
    lateinit var adapter: ListCardAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)
        setSupportActionBar(tool_bar_2)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        cards = mutableListOf()
        initItemCard()

        adapter = ListCardAdapter()
        adapter.cards = cards
        setUpRv()

        btn_back.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }

    private fun setUpRv() {
        rv_cards.adapter = adapter
        rv_cards.layoutManager = LinearLayoutManager(this)
    }

    private fun initItemCard() {
        cards.add(Card(R.drawable.ic_mastercard_2,"Mastercard","****9889"))
        cards.add(Card(R.drawable.ic_combined_shape,"Visa-black","****9896"))
        cards.add(Card(R.drawable.ic_combined_shape,"Visa","****9823"))
        cards.add(Card(R.drawable.ic_mastercard_2,"Mastercard","****9823"))
        cards.add(Card(R.drawable.ic_mastercard_2,"Mastercard","****9239"))
        cards.add(Card(R.drawable.ic_mastercard_2,"Mastercard","****9239"))
        cards.add(Card(R.drawable.ic_mastercard_2,"Mastercard","****9239"))
        cards.add(Card(R.drawable.ic_mastercard_2,"Mastercard","****9239"))
        cards.add(Card(R.drawable.ic_mastercard_2,"Mastercard","****9239"))

    }
}