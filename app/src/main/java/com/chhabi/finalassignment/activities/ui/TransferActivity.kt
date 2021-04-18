package com.chhabi.finalassignment.activities.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.chhabi.finalassignment.R
import com.chhabi.finalassignment.activities.ui.Entity.Useraccount
import com.chhabi.finalassignment.activities.ui.Repository.UseraccountRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class TransferActivity : AppCompatActivity(){

    private lateinit var etname: EditText
    private lateinit var etnumber: EditText
    private lateinit var etamount: EditText
    private lateinit var etremarks: EditText
    private lateinit var btnsend: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer)


        etname = findViewById(R.id.etname)
        etnumber = findViewById(R.id.etnumber)
        etamount = findViewById(R.id.etamount)
        etremarks = findViewById(R.id.etremarks)
        btnsend = findViewById(R.id.btnsend)
        btnsend.setOnClickListener{
            addUseraccount()
        }


    }
    private fun addUseraccount() {
        val name = etname.text.toString()
        val number = etnumber.text.toString()
        val amount = etamount.text.toString()
        val remarks = etremarks.text.toString()


        val account = Useraccount(Accountname = name, Accountnumber = number, amount = amount, remarks = remarks)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val useraccountRepository = UseraccountRepository()
                val response = useraccountRepository.addUseraccount(account)
                if (response.success == true) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                                this@TransferActivity,
                                "User added successfully",
                                Toast.LENGTH_SHORT
                        ).show()
                    }
                    startActivity(
                            Intent(
                                    this@TransferActivity,
                                    ButtomNav::class.java
                            )
                    )
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                            this@TransferActivity,
                            ex.toString(),
                            Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }
}

