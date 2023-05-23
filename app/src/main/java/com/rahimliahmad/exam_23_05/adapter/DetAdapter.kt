package com.rahimliahmad.exam_23_05.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rahimliahmad.exam_23_05.R
import com.rahimliahmad.exam_23_05.model.Detail
import com.squareup.picasso.Picasso

class DetAdapter (list : List<Detail>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    var list : List<Detail>
    init {
        this.list=list
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       var detail= itemView.findViewById<TextView>(R.id.detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.reccle_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.detail.setText(list.get(position).backdrop_path)

    }
}