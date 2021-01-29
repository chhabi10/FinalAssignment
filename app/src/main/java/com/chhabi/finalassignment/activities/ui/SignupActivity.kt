package com.chhabi.finalassignment.activities.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.chhabi.finalassignment.R
import com.chhabi.finalassignment.activities.ui.Db.CustomerDb
import com.chhabi.finalassignment.activities.ui.Entity.Customer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SignupActivity : AppCompatActivity() {
    private lateinit var etfname:EditText
    private lateinit var etlname: EditText
    private lateinit var etusername: EditText
    private lateinit var etpassword: EditText
    private lateinit var etage : EditText
    private lateinit var etaddress: EditText
    private lateinit var btnsign: Button

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


        btnsign.setOnClickListener {
            val fname = etfname.text.toString()
            val lname = etlname.text.toString()
            val username = etusername.text.toString()
            val password = etpassword.text.toString()
            val age= etage.text.toString()
            val address=etaddress.text.toString()


                val customer = Customer(fname, lname, username, password,age,address)
                CoroutineScope(Dispatchers.IO).launch {
                    CustomerDb.getInstance(this@SignupActivity).getCustomerDao().registercustomer(customer)
                }
                Toast.makeText(this, "Customer register", Toast.LENGTH_SHORT).show()
        }


    }


    }






