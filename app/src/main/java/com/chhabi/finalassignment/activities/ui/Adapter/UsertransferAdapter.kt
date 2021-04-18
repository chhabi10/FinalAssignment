package com.chhabi.finalassignment.activities.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chhabi.finalassignment.R
import com.chhabi.finalassignment.activities.ui.Entity.Useraccount

class UsertransferAdapter(
        val lstUseraccount: MutableList<Useraccount>,
        val context: Context

): RecyclerView.Adapter<UsertransferAdapter.UseraccountViewHolder>(){

    class UseraccountViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvname: TextView
        val tvnumber: TextView
        val tvamount: TextView
        val tvremarks: TextView
        val btndelete: ImageButton

        init {
            tvname=view.findViewById(R.id.tvname)
            tvnumber=view.findViewById(R.id.tvnumber)
            tvamount=view.findViewById(R.id.tvamount)
            tvremarks=view.findViewById(R.id.tvremarks)
            btndelete=view.findViewById(R.id.btndelete)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UseraccountViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.account_layout, parent, false)
        return UseraccountViewHolder(view)
    }

    override fun onBindViewHolder(holder: UseraccountViewHolder, position: Int) {
        val useraccount = lstUseraccount[position]
        holder.tvname.text = useraccount.Accountname
        holder.tvnumber.text = useraccount.Accountnumber
        holder.tvamount.text=useraccount.amount
        holder.tvremarks.text=useraccount.remarks

    }

    override fun getItemCount(): Int {
        return lstUseraccount.size
    }


}

