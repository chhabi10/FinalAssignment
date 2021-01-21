package com.chhabi.finalassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity(), View.OnClickListener{
    private lateinit var tvappname: TextView
    private lateinit var etusername: EditText
    private lateinit var etpassword: EditText
    private lateinit var btnlogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvappname= findViewById(R.id.tvappname)
        etusername= findViewById(R.id.etusername)
        etpassword= findViewById(R.id.etpassword)
        btnlogin= findViewById(R.id.btnlogin)


        btnlogin.setOnClickListener(this)

        }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }

}
