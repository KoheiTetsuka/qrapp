package com.example.qrcodeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Viewの取得
        val btnScan: Button = findViewById(R.id.btnScan)
        val btnHistry: Button = findViewById(R.id.btnHistry)

        btnScan.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        btnHistry.setOnClickListener {
            val intent = Intent(this, History::class.java)
            startActivity(intent)
        }

    }

}
