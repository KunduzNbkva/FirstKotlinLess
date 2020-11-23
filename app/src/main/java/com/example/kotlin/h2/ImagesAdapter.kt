package com.example.kotlin.h2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.R
import kotlinx.android.synthetic.main.images_list.view.*

class ImagesAdapter(val list: ArrayList<String>) : RecyclerView.Adapter<ImagesAdapter.ViewHolder>() {
  lateinit var holder: ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.images_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        this.holder=holder
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(s: String) {
           Glide.with(itemView.context).load(s).into(itemView.image_view)
        }

    }

}