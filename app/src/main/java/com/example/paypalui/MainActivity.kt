package com.example.paypalui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paypalui.adapter.ContactAdapter
import com.example.paypalui.adapter.HistoryApdater
import com.example.paypalui.model.Contact
import com.example.paypalui.model.History
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.child_layout.*

class MainActivity : AppCompatActivity() {
    private lateinit var lisContacts: MutableList<Contact>
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var historyApdater: HistoryApdater
    private lateinit var historys: MutableList<History>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lisContacts = mutableListOf()
        historys = mutableListOf()
        addListContact()
        addListHistorys()

        contactAdapter = ContactAdapter()
        contactAdapter.listContact = lisContacts

        historyApdater = HistoryApdater()
        historyApdater.historys = historys

        rv_contact.adapter = contactAdapter
        rv_contact.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        rv_history.adapter = historyApdater
        rv_history.layoutManager = LinearLayoutManager(this)
        rv_history.setHasFixedSize(true)
        var dividerItemDecoration =
            DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL)
        dividerItemDecoration.setDrawable(getDrawable(R.drawable.divider_item)!!)
        rv_history.addItemDecoration(
            dividerItemDecoration
        )
        floatingActionButton.setOnClickListener {
            startActivity(Intent(this, PayActivity::class.java))
        }

        btn_nav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.pay -> {
                    startActivity(Intent(this, PayActivity::class.java))
                    true
                }
                R.id.cards ->{
                    startActivity(Intent(this,CardsActivity::class.java))
                    true
                }
                else ->true
            }

        }


    }

    private fun addListHistorys() {
        historys.apply {
            add(History("El corte inglés", "Pago aceptado", -50))
            add(History("Maria Lujan", "Pago aceptado", 650))
            add(History("Maria Lujan", "Pago aceptado", 250))
            add(History("El corte inglés", "Pago aceptado", -50))
            add(History("El corte inglés", "Pago aceptado", -50))
            add(History("El corte inglés", "Pago aceptado", -50))
            add(History("El corte inglés", "Pago aceptado", -50))
        }
    }

    private fun addListContact() {
        lisContacts.apply {
            add(Contact(R.drawable.bitmap_copy, "Carlos Roca"))
            add(Contact(R.drawable.bitmap_copy_3, "Ruby Sanz"))
            add(Contact(R.drawable.bitmap_copy_4, "Mary Rich"))
            add(Contact(R.drawable.bitmap_copy_5, "José Porto"))
            add(Contact(R.drawable.bitmap_copy_3, "More"))

        }
    }
}