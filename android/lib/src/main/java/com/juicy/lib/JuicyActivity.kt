package com.juicy.lib

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.webkit.WebView
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity

open class JuicyActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        webView = WebView(applicationContext)
        setContentView(webView)
        webView.settings.javaScriptEnabled = true

        onBackPressedDispatcher.addCallback{
            if (webView.canGoBack())
                webView.goBack()
            else
                moveTaskToBack(true)
        }
    }

    fun openUrl(url: String){
        webView.loadUrl(url)
    }

}