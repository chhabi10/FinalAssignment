package com.chhabi.finalassignment.activities.ui.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chhabi.finalassignment.R
import com.chhabi.finalassignment.activities.ui.Adapter.CustomerAdapter
import com.chhabi.finalassignment.activities.ui.Repository.CustomerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewuserActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewuser)


        recyclerView=findViewById(R.id.recyclerView)

        loadStudents()
    }

    private fun loadStudents() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val customerRepository = CustomerRepository()
                val response = customerRepository.getAllCustomer()
                if(response.success==true){
                    // Put all the student details in lstStudents
                    val lstStudents = response.data
                    withContext(Dispatchers.Main){
                        recyclerView.adapter = CustomerAdapter(lstStudents!!,this@ViewuserActivity)
                        recyclerView.layoutManager = LinearLayoutManager(this@ViewuserActivity)
                    }
                }
            }catch(ex : Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(this@ViewuserActivity,
                        "Error : ${ex.toString()}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
