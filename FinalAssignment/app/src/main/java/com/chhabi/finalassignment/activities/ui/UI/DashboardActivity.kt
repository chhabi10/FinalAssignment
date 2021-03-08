package com.chhabi.finalassignment.activities.ui.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.chhabi.finalassignment.R

class DashboardActivity : AppCompatActivity() {

    private lateinit var addcustomer: Button
    private lateinit var viewcustomer: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        addcustomer=findViewById(R.id.addcustomer)
        viewcustomer=findViewById(R.id.viewcustomer)

        addcustomer.setOnClickListener {
            startActivity(Intent(this,AddUserActivity::class.java))
        }
        viewcustomer.setOnClickListener {
            startActivity(Intent(this,ViewuserActivity::class.java))
        }
    }
}