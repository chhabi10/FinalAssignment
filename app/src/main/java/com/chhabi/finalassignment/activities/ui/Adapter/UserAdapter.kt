package com.chhabi.finalassignment.activities.ui.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chhabi.finalassignment.R
import com.chhabi.finalassignment.activities.ui.API.ServiceBuilder
import com.chhabi.finalassignment.activities.ui.Entity.Customer
import com.chhabi.finalassignment.activities.ui.TransferActivity


class UserAdapter(
        val lstCustomer:MutableList<Customer>,
        val context: Context

        ):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgProfile: ImageView
        val tvFullname: TextView
        val tvLastname: TextView
        val tvIdentity: TextView
        val tvdob: TextView
        val tvaddress: TextView
        val btnUpdate:ImageButton
        val btnDelete:ImageButton
        val btndonate:Button



        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            tvFullname = view.findViewById(R.id.tvFullname)
            tvLastname = view.findViewById(R.id.tvLastname)
            tvIdentity = view.findViewById(R.id.tvIdentity)
            tvdob = view.findViewById(R.id.tvdob)
            tvaddress = view.findViewById(R.id.tvaddress)
            btnUpdate=view.findViewById(R.id.btnUpdate)
            btnDelete=view.findViewById(R.id.btnDelete)
            btndonate=view.findViewById(R.id.btndonate)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.custom_user_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val customer = lstCustomer[position]
        holder.tvFullname.text = customer.fname
        holder.tvLastname.text = customer.lname
        holder.tvIdentity.text = customer.identity
        holder.tvdob.text = customer.dob
        holder.tvaddress.text = customer.address
        Glide.with(context)
                .load(customer.photo)
                .into(holder.imgProfile)
//        val imagePath = ServiceBuilder.loadImagePath() + customer.photo
//        if (!customer.photo.equals("no-photo.jpg")) {
//            Glide.with(context)
//                    .load(imagePath)
//                    .fitCenter()
//                    .into(holder.imgProfile)
//        }

        holder.btndonate.setOnClickListener {
            context.startActivity(Intent(context,TransferActivity::class.java))
        }

        holder.btnDelete.setOnClickListener {
            lstCustomer.removeAt(position)
            notifyDataSetChanged()
            Toast.makeText(context, "customer Deleted Successfully!", Toast.LENGTH_SHORT).show()
        }



    }


    override fun getItemCount(): Int {
        return lstCustomer.size
    }

}

