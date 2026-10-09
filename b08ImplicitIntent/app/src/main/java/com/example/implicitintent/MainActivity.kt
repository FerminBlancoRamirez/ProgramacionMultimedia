package com.example.implicitintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById<View?>(R.id.main),
            OnApplyWindowInsetsListener { v: View?, insets: WindowInsetsCompat? ->
                val systemBars = insets!!.getInsets(WindowInsetsCompat.Type.systemBars())
                v!!.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            })

        val boton = findViewById<Button>(R.id.boton)
        val boton2 = findViewById<Button>(R.id.boton2)


        boton.setOnClickListener(View.OnClickListener { e: View? ->
            val url = "https://github.com/FerminBlancoRamirez"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        })

        boton2.setOnClickListener(View.OnClickListener { e: View? ->
            val intent = Intent(this@MainActivity, WebViewActivity::class.java)
            intent.putExtra("url", "https://github.com/FerminBlancoRamirez")
            startActivity(intent)
        })
    }
}