package com.example.dell.kusele

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Infoproduit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infoproduit)
        intent.getByteArrayExtra("Image")
    }
}
