package com.example.projectmanagement.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager.*
import com.example.projectmanagement.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        setupActionBar()

        window.setFlags(
            LayoutParams.FLAG_FULLSCREEN,
            LayoutParams.FLAG_FULLSCREEN
        )
    }

    private fun setupActionBar(){
        setSupportActionBar(toolbar_sign_up_activity)

        val actionBar = supportActionBar
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_black_color_back_24dp)
        }

        toolbar_sign_up_activity.setNavigationOnClickListener { onBackPressed() }
    }
}