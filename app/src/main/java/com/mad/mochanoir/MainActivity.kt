package com.mad.mochanoir

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mad.mochanoir.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)

        val fragmentToLoad = intent?.getStringExtra("fragmentToLoad")

        if (fragmentToLoad == "go_to_cart") {
            replaceFragment(Cart())
        }
        else {
            replaceFragment(Home())
        }

        val profile_pic = findViewById<ImageView>(R.id.profile_pic)
        profile_pic.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(Home())
                R.id.search -> replaceFragment(Search())
                R.id.cart -> replaceFragment(Cart())

                else -> {}
            }
            true
        }
    }

    private fun replaceFragment(frag : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainFrameLayout, frag)
        fragmentTransaction.commit()
    }
}