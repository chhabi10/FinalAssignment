package com.chhabi.finalassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText


class LoginActivity : AppCompatActivity(){
    private lateinit var tvappname: TextView
    private lateinit var etusername: TextInputEditText
    private lateinit var etpassword: TextInputEditText
    private lateinit var btnlogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvappname= findViewById(R.id.tvappname)
        etusername= findViewById(R.id.etusername)
        etpassword= findViewById(R.id.etpassword)
        btnlogin= findViewById(R.id.btnlogin)


       btnlogin.setOnClickListener {


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
