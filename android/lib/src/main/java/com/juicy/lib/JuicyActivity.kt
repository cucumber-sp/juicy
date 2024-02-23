package com.juicy.lib

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.ServiceWorkerClient
import android.webkit.ServiceWorkerController
import android.webkit.WebView
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity

open class JuicyActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {

        val serviceWorkerController = ServiceWorkerController.getInstance()
        serviceWorkerController.setServiceWorkerClient(ServiceWorkerClient())
        serviceWorkerController.serviceWorkerWebSettings.allowFileAccess = true
        serviceWorkerController.serviceWorkerWebSettings.allowContentAccess = true

        super.onCreate(savedInstanceState)

        webView = WebView(applicationContext)
        webView.settings.javaScriptEnabled = true

        onBackPressedDispatcher.addCallback{
            if (webView.canGoBack())
                webView.goBack()
            else
                moveTaskToBack(true)
        }

        setContentView(webView)
    }

    fun openUrl(url: String){
        webView.loadUrl(url)
    }

}