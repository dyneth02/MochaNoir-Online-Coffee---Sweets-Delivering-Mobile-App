package com.mad.mochanoir

import android.graphics.Typeface
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.mad.mochanoir.databinding.ActivityProductGalleryBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProductGalleryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductGalleryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductGalleryBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        navigation()

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.cart -> {
                    replaceFragment(Cart())
                    true
                }
                else -> false
            }
        }
    }

    private fun navigation() {
        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        replaceFragment(CoffeeBeans())

        val menuItems = listOf(
            getString(R.string.classic_coffee),
            getString(R.string.coffee_beans),
            getString(R.string.desserts),
            getString(R.string.signature_appetizers)
        )

        for (item in menuItems) {
            val textView = TextView(this).apply {
                text = item
                setPadding(32, 16, 32, 16)
                setTextColor(ContextCompat.getColor(this@ProductGalleryActivity, R.color.white))
                textSize = 12f
                setTypeface(null, Typeface.NORMAL)
                typeface = ResourcesCompat.getFont(this@ProductGalleryActivity, R.font.poppins_semibold)
            }

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply { setMargins(0, 0, 37, 0) }
            textView.layoutParams = params

            textView.setOnClickListener {
                when (item) {
                    getString(R.string.classic_coffee) -> replaceFragment(ClassicCoffee())
                    getString(R.string.coffee_beans) -> replaceFragment(CoffeeBeans())
                    getString(R.string.desserts) -> replaceFragment(Desserts())
                    getString(R.string.signature_appetizers) -> replaceFragment(SignatureAppetizers())
                    else -> Toast.makeText(this, "Unknown item clicked", Toast.LENGTH_SHORT).show()
                }
            }

            linearLayout.addView(textView)
        }
    }

    private fun replaceFragment(frag: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFrameLayout, frag)
            .commit()
    }
}
