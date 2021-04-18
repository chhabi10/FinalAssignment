package com.chhabi.finalassignment.activities.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.chhabi.finalassignment.R
import com.chhabi.finalassignment.activities.ui.Entity.User
import com.chhabi.finalassignment.activities.ui.Repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterActivity : AppCompatActivity() {

    private lateinit var etfirstname:EditText
    private lateinit var etlastname:EditText
    private lateinit var etuser:EditText
    private lateinit var etpass:EditText
    private lateinit var etconfirmpass:EditText
    private lateinit var btnsign:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        etfirstname=findViewById(R.id.etfirstname)
        etlastname=findViewById(R.id.etlastname)
        etuser=findViewById(R.id.etuser)
        etpass=findViewById(R.id.etpass)
        etconfirmpass=findViewById(R.id.etconfirmpass)
        btnsign=findViewById(R.id.btnsign)
        btnsign.setOnClickListener {

            val fname = etfirstname.text.toString()
            val lname = etlastname.text.toString()
            val username = etuser.text.toString()
            val password = etpass.text.toString()
            val confirmPassword = etconfirmpass.text.toString()
            if (password != confirmPassword) {
                etpass.error = "Password does not match"
                etpass.requestFocus()
                return@setOnClickListener
            } else {
                val user =
                    User(fname = fname, lname = lname, username = username, password = password)
                Toast.makeText(this, user.fname, Toast.LENGTH_SHORT).show()

                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val userRepository = UserRepository()
                        val response = userRepository.registerUser(user)
                        if (response.success == true) {
                            withContext(Main) {
                                Toast.makeText(
                                    this@RegisterActivity,
                                    "Register successful",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            startActivity(
                                Intent(
                                    this@RegisterActivity,
                                    SigninActivity::class.java
                                )
                            )
                        }
                    } catch (ex: Exception) {
                        withContext(Main) {
                            Toast.makeText(
                                this@RegisterActivity,
                                ex.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }
}