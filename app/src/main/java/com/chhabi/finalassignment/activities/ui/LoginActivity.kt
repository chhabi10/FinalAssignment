package com.chhabi.finalassignment.activities.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.chhabi.finalassignment.R
import com.google.android.material.textfield.TextInputEditText


class LoginActivity : AppCompatActivity(){
    private lateinit var tvappname: TextView
    private lateinit var tvregister:TextView
    private lateinit var etusername: EditText
    private lateinit var etpassword: EditText
    private lateinit var btnlogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvappname= findViewById(R.id.tvappname)
        tvregister=findViewById(R.id.tvregister)
        etusername= findViewById(R.id.etusername)
        etpassword= findViewById(R.id.etpassword)
        btnlogin= findViewById(R.id.btnlogin)


        tvregister.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignupActivity::class.java))
        }

       btnlogin.setOnClickListener {
           validate()


           if (etusername.text.toString() == "chhabi" && etpassword.text.toString() == "chhabi123") {
               val intent = Intent(this, MainActivity::class.java)
               startActivity(intent)
           } else {
               Toast.makeText(this, " username or password is incorrect", Toast.LENGTH_SHORT).show()
               etusername.error = "Username or password is incorrect"
               etusername.requestFocus()
           }
       }

        }

    private fun validate(): Boolean {
        var flag = true
        when {
            TextUtils.isEmpty(etusername.text) -> {
                etusername.error = "Username or password is incorrect"
                etusername.requestFocus()
                flag = false
            }
        }
        return flag
    }




}
