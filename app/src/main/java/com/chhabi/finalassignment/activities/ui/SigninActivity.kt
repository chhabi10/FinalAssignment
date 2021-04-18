package com.chhabi.finalassignment.activities.ui

import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.chhabi.finalassignment.R
import com.chhabi.finalassignment.activities.ui.API.ServiceBuilder
import com.chhabi.finalassignment.activities.ui.Repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class SigninActivity : AppCompatActivity() {
    private lateinit var sensorManager: SensorManager
    private var sensor: Sensor? = null
    private lateinit var etusername: EditText
    private lateinit var etpassword: EditText
    private lateinit var btnlogin: Button
    private lateinit var tvregister: TextView
    private lateinit var tvskip: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        tvregister = findViewById(R.id.tvregister)
        etusername = findViewById(R.id.etusername)
        etpassword = findViewById(R.id.etpassword)
        btnlogin = findViewById(R.id.btnlogin)
        tvregister = findViewById(R.id.tvregister)
        tvskip = findViewById(R.id.tvskip)






        btnlogin.setOnClickListener {
            login()
        }

        tvregister.setOnClickListener {
            startActivity(Intent(this@SigninActivity, RegisterActivity::class.java))
        }
        tvskip.setOnClickListener {
            startActivity(Intent(this@SigninActivity, ButtomNav::class.java))

        }
    }


    private fun login() {
        val username = etusername.text.toString()
        val password = etpassword.text.toString()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val repository = UserRepository()
                val response = repository.checkUser(username, password)
                if (response.success == true) {
                    ServiceBuilder.token = "Bearer ${response.token}"
//             ServiceBuilder.userData=response.userData!!

                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                                this@SigninActivity,
                                "Login success",
                                Toast.LENGTH_SHORT
                        ).show()
                    }

                    startActivity(
                            Intent(
                                    this@SigninActivity,
                                    CustomerActivity::class.java
                            )
                    )
                    finish()
                }
            } catch (ex: IOException) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                            this@SigninActivity,
                            ex.toString(),
                            Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }

    }




}






