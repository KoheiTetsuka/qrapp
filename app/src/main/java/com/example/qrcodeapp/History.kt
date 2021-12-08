package com.example.qrcodeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class History : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        // Viewの取得
        val btnBack: Button = findViewById(R.id.btnBack)

        btnBack.setOnClickListener {
            finish()
        }
    }
}