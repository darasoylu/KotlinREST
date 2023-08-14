package com.darasoylu.kotlinrest.ui.homeScreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.darasoylu.kotlinrest.R
import com.darasoylu.kotlinrest.databinding.UserItemLayoutBinding
import com.darasoylu.kotlinrest.model.User

class HomeFragmentAdapter(private val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<HomeFragmentAdapter.ViewHolder>() {

    private var userList = emptyList<User>()

    inner class ViewHolder(val binding: UserItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            UserItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.userFname.text = userList[position].firstName
        holder.binding.userLname.text = userList[position].lastName
        holder.binding.userAge.text = userList[position].age.toString()
        Glide.with(holder.binding.root)
            .load(userList[position].image)
            .centerInside()
            .error(R.drawable.ic_baseline_error_24)
            .into(holder.binding.userImage)

        holder.binding.userImage.setOnClickListener {
            itemClickListener.onItemClick(userList[position].id!!)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(newUserList: List<User>) {
        userList = newUserList
        notifyDataSetChanged()
    }
}