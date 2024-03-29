package com.example.projectmanagement.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager.*
import com.example.projectmanagement.R
import com.example.projectmanagement.firebase.FirestoreClass


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.setFlags(
            LayoutParams.FLAG_FULLSCREEN,
            LayoutParams.FLAG_FULLSCREEN
        )

        Handler().postDelayed({

            var currentUserID = FirestoreClass().getCurrentUserID()
            if (currentUserID.isNotEmpty()){
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                startActivity(Intent(this, IntroActivity::class.java))
            }

            startActivity(Intent(this, IntroActivity::class.java))
            finish()
        }, 2500)
    }
}