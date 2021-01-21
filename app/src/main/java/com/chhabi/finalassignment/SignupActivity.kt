package com.chhabi.finalassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class SignupActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etfname: EditText
    private lateinit var etlname: EditText

    private lateinit var etusername: EditText

    private lateinit var etpassword: EditText
    private lateinit var etage : EditText
    private lateinit var etaddress: EditText
    private lateinit var btnsign: Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        etfname= findViewById(R.id.etfname)
        etlname= findViewById(R.id.etlname)
        etusername= findViewById(R.id.etusername)
        etpassword= findViewById(R.id.etpassword)
        etage= findViewById(R.id.etage)
        etaddress= findViewById(R.id.etfname)
        btnsign= findViewById(R.id.btnsign)

        btnsign.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}