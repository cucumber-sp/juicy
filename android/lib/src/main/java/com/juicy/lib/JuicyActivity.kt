package com.juicy.lib

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.webkit.ServiceWorkerClient
import android.webkit.ServiceWorkerController
import android.webkit.WebView

open class JuicyActivity : Activity() {

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

        setContentView(webView)
    }

    fun openUrl(url: String){
        webView.loadUrl(url)
    }

    override fun onBackPressed() {
        if (webView.canGoBack())
            webView.goBack()
        else
            moveTaskToBack(true)
    }

}