package com.mad.mochanoir

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        val btn_sign_out = findViewById<Button>(R.id.go_back)
        val btn_track_order = findViewById<Button>(R.id.btn_track_order)

        btn_sign_out.setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }

        btn_track_order.setOnClickListener {
            val i = Intent(this, TrackOrderActivity::class.java)
            startActivity(i)
        }
    }
}