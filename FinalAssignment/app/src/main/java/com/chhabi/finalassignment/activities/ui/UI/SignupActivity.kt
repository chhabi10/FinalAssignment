package com.chhabi.finalassignment.activities.ui.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.chhabi.finalassignment.R
import com.chhabi.finalassignment.activities.ui.Entity.User
import com.chhabi.finalassignment.activities.ui.Repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception


class SignupActivity : AppCompatActivity() {
    private lateinit var etfname:EditText
    private lateinit var etlname: EditText
    private lateinit var etusername: EditText
    private lateinit var etpassword: EditText
    private lateinit var etage : EditText
    private lateinit var etaddress: EditText
    private lateinit var btnsign: Button
    private lateinit var cpassword:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        etfname = findViewById(R.id.etfname)
        etlname = findViewById(R.id.etlname)
        etusername = findViewById(R.id.etusername)
        etpassword = findViewById(R.id.etPassword)
        etage = findViewById(R.id.etage)
        etaddress = findViewById(R.id.etfname)
        btnsign = findViewById(R.id.btnsign)
        cpassword=findViewById(R.id.cpassword)


        btnsign.setOnClickListener {
            val fname = etfname.text.toString()
            val lname = etlname.text.toString()
            val username = etusername.text.toString()
            val password = etpassword.text.toString()
            val age= etage.text.toString().toInt()
            val address=etaddress.text.toString()
            val confirmpassword=cpassword.text.toString()


            if (password != confirmpassword) {
                cpassword.error= "Password does not match"
                cpassword.requestFocus()
                return@setOnClickListener
            }
            else{
                val user= User(fname=fname,lname = lname,username = username,password = password,age = age,address = address)
             CoroutineScope(
                     Dispatchers.IO).launch {
                 try {
                     val userRepository = UserRepository()
                     val response = userRepository.registerUser(user)
                     if (response.success == true) {
                         withContext(Main) {
                             Toast.makeText(
                                     this@SignupActivity,
                                     "register successfull",
                                     Toast.LENGTH_SHORT
                             ).show()
                         }
                     }
                 } catch (ex: Exception) {
                     withContext(Main) {
                         Toast.makeText(
                                 this@SignupActivity,
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














