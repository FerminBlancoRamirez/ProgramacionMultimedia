package com.example.implicitintent

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// 1. IMPORTANTE: Import del WebView de Android
class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_web_view)

        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById<View?>(R.id.main),
            OnApplyWindowInsetsListener { v: View?, insets: WindowInsetsCompat? ->
                val systemBars = insets!!.getInsets(WindowInsetsCompat.Type.systemBars())
                v!!.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            })

        val boton = findViewById<Button>(R.id.boton3)

        // 2. CORREGIDO: Usar el tipo de dato WebView
        val webView = findViewById<WebView>(R.id.webView)

        boton.setOnClickListener(View.OnClickListener { e: View? ->
            webView.setWebViewClient(WebViewClient())
            val webSettings = webView.getSettings()
            webSettings.setJavaScriptEnabled(true)
            val url = getIntent().getStringExtra("url")
            if (url != null && !url.isEmpty()) {
                webView.loadUrl(url)
            }
        })
    }
}