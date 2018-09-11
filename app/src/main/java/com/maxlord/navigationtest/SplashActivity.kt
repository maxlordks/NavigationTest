package com.maxlord.navigationtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.core.os.postDelayed
import androidx.navigation.ActivityNavigator
import androidx.navigation.findNavController

class SplashActivity : AppCompatActivity() {

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Log.e("STARTING", "NAVTEST")
        handler.postDelayed(2000) {
            aaa()
        }
    }

    fun aaa() {
        Log.e("STARTING", "NAVigating")

//        findNavController(R.id.my_nav_host_fragment)
//                .navigate(SplashActivityDirections.mainFromSplashAction())
//        ActivityNavigator(this).navigate(SplashActivityDirections.mainFromSplashAction())
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
