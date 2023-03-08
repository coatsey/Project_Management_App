package com.example.projectmanagement.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.text.TextUtils
import android.view.WindowManager.*
import android.widget.Toast
import com.example.projectmanagement.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
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

        btn_sign_up.setOnClickListener{
            registerUser()
        }
    }

    private fun registerUser(){
        val name: String = et_name.text.toString()
        val email: String = et_email.text.toString()
        val password: String = et_password.text.toString()

        if(validateForm(name, email, password)){
            Toast.makeText(
                this@SignUpActivity,
                "Registered",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun validateForm(name: String, email: String, password: String): Boolean {
        return when {
            TextUtils.isEmpty(name) -> {
                showErrorSnackBar("Please enter name.")
                false
            }
            TextUtils.isEmpty(email) -> {
                showErrorSnackBar("Please enter email.")
                false
            }
            TextUtils.isEmpty(password) -> {
                showErrorSnackBar("Please enter password.")
                false
            }
            else -> {
                true
            }
        }
    }
}