package com.example.controlpatri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // find your website
        val findWV = findViewById<View>(R.id.WebView) as WebView
        findWV.loadUrl("https://controlpatri.urbanovitalino.adv.br/") // find your website
        val webSett = findWV.settings

        webSett.javaScriptEnabled = true // enable javascript
        webSett.domStorageEnabled = true // storage data for optimization
        findWV.webViewClient = WebViewClient() // manage page navigation

        // key steps
        findWV.canGoBack()
        findWV.setOnKeyListener(View.OnKeyListener { view, i, keyEvent ->
            if (i == KeyEvent.KEYCODE_BACK
                && keyEvent.action == MotionEvent.ACTION_UP
                && findWV.canGoBack()
            ) {
                findWV.goBack()
                return@OnKeyListener true
            }
            false
        })
    }
}