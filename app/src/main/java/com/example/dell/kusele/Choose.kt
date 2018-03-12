package com.example.dell.kusele

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_choose.*

class Choose : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose)
    }

    override fun onStart() {
        super.onStart()
        user.setOnClickListener {
            startActivity(Intent(this, InfoUser::class.java))
            finish()
        }

        shop.setOnClickListener {
            startActivity(Intent(this, InfoShop::class.java))
            finish()
        }
    }
}
