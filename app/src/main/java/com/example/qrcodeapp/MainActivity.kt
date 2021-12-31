package com.example.qrcodeapp

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.qrcodeapp.databinding.ActivityMainBinding
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions

@RuntimePermissions
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val barcodeLauncher = registerForActivityResult(ScanContract()) { result ->
        if (result.contents == null) {
            Log.i(MainActivity::class.java.name, "Cancelled")
        } else {
            Log.i(MainActivity::class.java.name, "Scanned: ${result.contents}")
        }
    }

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
        barcodeLauncher.launch(ScanOptions())
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResult(requestCode, grantResults)
    }

}
