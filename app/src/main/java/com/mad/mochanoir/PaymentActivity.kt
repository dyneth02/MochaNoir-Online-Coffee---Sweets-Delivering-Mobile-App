package com.mad.mochanoir

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent

class PaymentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payment)

        val back_btn = findViewById<ImageView>(R.id.payment_back_btn)
        back_btn.setOnClickListener {
            finish()
        }

        val pay_btn = findViewById<ImageView>(R.id.pay_btn)

        pay_btn.setOnClickListener {
            val intent = Intent(this, PaymentDoneActivity::class.java)
            startActivity(intent)
        }
    }
}