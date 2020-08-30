package com.mtsahakis.barcode.scan

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mtsahakis.barcode.lib.REQUEST_CODE
import com.mtsahakis.barcode.lib.getBarcode
import com.mtsahakis.barcode.lib.hasBarcode
import com.mtsahakis.barcode.lib.initiateScan
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        scan_button.setOnClickListener {
            initiateScan(this)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode != Activity.RESULT_OK) {
            return
        }

        if (requestCode == REQUEST_CODE) {
            data?.let {
                if (hasBarcode(data)) {
                    val result: List<String> = getBarcode(data)
                    scan_result.text = result.joinToString()
                }
            }
        }
    }
}