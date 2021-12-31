package com.example.qrcodeapp

import android.Manifest
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.qrcodeapp.databinding.ActivityMainBinding
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions

@RuntimePermissions
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Viewの取得
        binding.btnScan.setOnClickListener {
            openCameraWithPermissionCheck()
        }

        binding.btnHistry.setOnClickListener {
            val intent = Intent(this, History::class.java)
            startActivity(intent)
        }
    }

    @NeedsPermission(Manifest.permission.CAMERA)
    fun openCamera() {

    }

}
