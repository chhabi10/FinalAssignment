package com.chhabi.finalassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity(), View.OnClickListener {



private lateinit var imgv:ImageView
    private lateinit var btnenter: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imgv=findViewById(R.id.imgv)
        btnenter= findViewById(R.id.btnenter)

        btnenter.setOnClickListener(this)



    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}