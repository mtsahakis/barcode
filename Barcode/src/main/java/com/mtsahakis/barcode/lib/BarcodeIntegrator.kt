@file:JvmName("BarcodeIntegrator")

package com.mtsahakis.barcode.lib

import android.app.Activity
import android.content.Intent

const val REQUEST_CODE = 1341
const val RESULT_EXTRA_BARCODE = "INTENT_RESULT_EXTRA_BARCODE"

fun initiateScan(activity: Activity) {
    val intent = Intent(activity, BarcodeScanActivity::class.java)
    activity.startActivityForResult(intent, REQUEST_CODE)
}

fun prepareIntentBarcodeDetected(result: List<String>): Intent {
    return Intent().putStringArrayListExtra(RESULT_EXTRA_BARCODE, ArrayList(result))
}

fun hasBarcode(intent: Intent): Boolean {
    return intent.hasExtra(RESULT_EXTRA_BARCODE)
}

fun getBarcode(intent: Intent): List<String> {
    return intent.getStringArrayListExtra(RESULT_EXTRA_BARCODE)
}




