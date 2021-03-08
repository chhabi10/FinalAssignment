package com.chhabi.finalassignment.activities.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.chhabi.finalassignment.R

class MainActivity : AppCompatActivity() {
    private lateinit var imgv: ImageView
    private lateinit var btnenter: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgv = findViewById(R.id.imgv)
        btnenter = findViewById(R.id.btnenter)





        btnenter.setOnClickListener{
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))}



        }


    }



