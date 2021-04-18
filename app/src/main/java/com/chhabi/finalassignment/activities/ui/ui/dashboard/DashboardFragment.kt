package com.chhabi.finalassignment.activities.ui.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chhabi.finalassignment.R
import com.chhabi.finalassignment.activities.ui.Adapter.UserAdapter
import com.chhabi.finalassignment.activities.ui.Adapter.UsertransferAdapter
import com.chhabi.finalassignment.activities.ui.Repository.CustomerRepository
import com.chhabi.finalassignment.activities.ui.Repository.UseraccountRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var recyclerViewUser: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        recyclerViewUser=root.findViewById(R.id.recyclerViewUser)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            loadUseraccount()
        })
        return root
    }
    private fun loadUseraccount() {

        CoroutineScope(Dispatchers.IO).launch {
            try{
                val repository= UseraccountRepository()
                val response=repository.getAllUseraccount()
                val lstUseraccount = response.data!!
                withContext(Dispatchers.Main){

                    recyclerViewUser.adapter= UsertransferAdapter(lstUseraccount!!,requireContext())
                    recyclerViewUser.layoutManager= LinearLayoutManager(requireContext())
                }
            }
            catch (ex:Exception){
                withContext(Dispatchers.Main){
                    Toast.makeText(requireContext(),
                            "Error : ${ex.toString()}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    }