package com.juicy.sampleapp

import android.os.Bundle
import com.juicy.lib.JuicyActivity

class MainActivity : JuicyActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openUrl("https://juicy-sample.vercel.app/")
    }
}