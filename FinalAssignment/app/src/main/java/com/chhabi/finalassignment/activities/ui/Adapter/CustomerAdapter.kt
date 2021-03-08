package com.chhabi.finalassignment.activities.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chhabi.finalassignment.R
import com.chhabi.finalassignment.activities.ui.API.ServiceBuilder
import com.chhabi.finalassignment.activities.ui.Entity.Customer

class CustomerAdapter(
val lstStudent:MutableList<Customer>,
val context: Context
):RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() {
    class CustomerViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgProfile: ImageView
        val tvFullName: TextView
        val tvAge: TextView
        val tvAddress: TextView
        val btnDelete: ImageButton
        val btnUpdate: ImageButton

        init {
            imgProfile=view.findViewById(R.id.imgProfile)
            tvFullName=view.findViewById(R.id.tvFullName)
            tvAge=view.findViewById(R.id.tvAge)
            tvAddress=view.findViewById(R.id.tvAddress)
            btnDelete=view.findViewById(R.id.btnDelete)
            btnUpdate=view.findViewById(R.id.btnUpdate)
        }


    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.customer_layout,parent,false)
        return CustomerViewHolder(view)
    }


    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val student = lstStudent[position]
        holder.tvFullName.text = student.fullname
        holder.tvAge.text = student.age.toString()
        holder.tvAddress.text = student.address
        Glide.with(context)
            .load(student.photo)
            .into(holder.imgProfile)
        val imagePath = ServiceBuilder.loadImagePath() + student.photo
        if (!student.photo.equals("no-photo.jpg")) {
            Glide.with(context)
                .load(imagePath)
                .fitCenter()
                .into(holder.imgProfile)
        }

        holder.btnDelete.setOnClickListener {
            lstStudent.removeAt(position)
            notifyDataSetChanged()
            Toast.makeText(context, "Student Deleted Successfully!", Toast.LENGTH_SHORT).show()
        }


    }
    override fun getItemCount(): Int {
        return lstStudent.size
    }
}