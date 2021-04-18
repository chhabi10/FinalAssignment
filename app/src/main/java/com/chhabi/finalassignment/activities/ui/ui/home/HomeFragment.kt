package com.chhabi.finalassignment.activities.ui.ui.home

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
import com.chhabi.finalassignment.activities.ui.Repository.CustomerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var recyclerViewUser: RecyclerView


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerViewUser=root.findViewById(R.id.recyclerViewUser)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {

            loadCustomer()

        })
        return root
    }
    private fun loadCustomer() {

        CoroutineScope(Dispatchers.IO).launch {
            try{
                val customerRepository= CustomerRepository()
                val response=customerRepository.getAllCustomer()
                val lstCustomer = response.data!!
                withContext(Main){
                    recyclerViewUser.adapter=UserAdapter(lstCustomer!!,requireContext())
                    recyclerViewUser.layoutManager= LinearLayoutManager(requireContext())
                }
            }
            catch (ex:Exception){
                withContext(Main){
                    Toast.makeText(requireContext(),
                            "Error : ${ex.toString()}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}