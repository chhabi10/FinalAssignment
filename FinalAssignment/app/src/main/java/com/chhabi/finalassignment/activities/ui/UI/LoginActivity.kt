package com.chhabi.finalassignment.activities.ui.UI

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import com.chhabi.finalassignment.R
import com.chhabi.finalassignment.activities.ui.API.ServiceBuilder
import com.chhabi.finalassignment.activities.ui.Repository.UserRepository
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class LoginActivity : AppCompatActivity() {


    private val permissions = arrayOf(
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.ACCESS_FINE_LOCATION
    )

    private lateinit var tvappname: TextView
    private lateinit var tvregister: TextView
    private lateinit var etusername: EditText
    private lateinit var etpassword: EditText
    private lateinit var btnlogin: Button
    private lateinit var constraintLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tvappname = findViewById(R.id.tvappname)
        tvregister = findViewById(R.id.tvregister)
        etusername = findViewById(R.id.etusername)
        etpassword = findViewById(R.id.etpassword)
        btnlogin = findViewById(R.id.btnlogin)
        constraintLayout = findViewById(R.id.constraintLayout)


        checkRunTimePermission()

        btnlogin.setOnClickListener {
            login()
        }

        tvregister.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignupActivity::class.java))
        }
    }

    private fun checkRunTimePermission() {
        if (!hasPermission()) {
            requestPermission()
        }
    }

    private fun hasPermission(): Boolean {
        var hasPermission = true
        for (permission in permissions) {
            if (ActivityCompat.checkSelfPermission(
                            this,
                            permission
                    ) != PackageManager.PERMISSION_GRANTED
            ) {
                hasPermission = false
                break
            }
        }
        return hasPermission
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this@LoginActivity, permissions, 1)
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
                    saveUsernamePassword()
                    startActivity(
                            Intent(
                                    this@LoginActivity,
                                    DashboardActivity::class.java
                            )
                    )
                    finish()
                } else {
                    withContext(Dispatchers.Main) {
                        val snack =
                                Snackbar.make(
                                        constraintLayout,
                                        "Invalid credentials",
                                        Snackbar.LENGTH_LONG
                                )
                        snack.setAction("OK", View.OnClickListener {
                            snack.dismiss()
                        })
                        snack.show()
                    }
                }
            } catch (ex: IOException) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                            this@LoginActivity,
                            ex.toString(),
                            Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun saveUsernamePassword() {
        val username = etusername.text.toString()
        val password = etpassword.text.toString()
        val sharedPref = getSharedPreferences("UsernamePasswordPref", MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("username", username)
        editor.putString(" password", password)
        editor.apply()
    }
}

