package com.example.qrcodeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator

class SecondActivity : AppCompatActivity() {
    private var qrScanIntegrator: IntentIntegrator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        qrScanIntegrator = IntentIntegrator(this)

        // 画面の回転をさせない (今回は縦画面に固定)
        qrScanIntegrator?.setOrientationLocked(false)

        // QR 読み取り後にビープ音がなるのを止める
        qrScanIntegrator?.setBeepEnabled(false)

        // スキャン開始 (QR アクティビティ生成)
        qrScanIntegrator?.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        // 結果の取得
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if (result != null) {
            // result.contents で取得した値を参照できる
            Toast.makeText(applicationContext, result.contents, Toast.LENGTH_LONG).show()
        }

        else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}