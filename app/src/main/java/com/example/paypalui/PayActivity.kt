package com.example.paypalui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.tool_bar.*

class PayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)

        setSupportActionBar(tool_bar_1)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        arrow_back_1.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}