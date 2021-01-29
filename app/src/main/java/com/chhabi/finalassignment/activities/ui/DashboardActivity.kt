package com.chhabi.finalassignment.activities.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.chhabi.finalassignment.R

class DashboardActivity : AppCompatActivity() {
private lateinit var btnView:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btnView=findViewById(R.id.btnView)
        btnView.setOnClickListener {
            startActivity(Intent(this, CustomerviewActivity::class.java))
        }
    }
}