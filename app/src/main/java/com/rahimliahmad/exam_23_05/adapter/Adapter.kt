package com.rahimliahmad.exam_23_05.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rahimliahmad.exam_23_05.R
import com.rahimliahmad.exam_23_05.model.PopluarMovies
import com.squareup.picasso.Picasso

class Adapter (list : List<PopluarMovies>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    var list : List<PopluarMovies>
    init {
        this.list=list
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id = itemView.findViewById<TextView>(R.id.id)
        var language = itemView.findViewById<TextView>(R.id.language)
        var poster= itemView.findViewById<ImageView>(R.id.imageView)
        var popularity=itemView.findViewById<TextView>(R.id.popularity)
        var orginal_title=itemView.findViewById<TextView>(R.id.original_tittle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.reccle_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.setText(list.get(position).id)
        holder.popularity.setText(list.get(position).populuarity)
        holder.orginal_title.setText(list.get(position).orginal_tittle)
        holder.language.setText(list.get(position).language)
        Picasso.get().load(list.get(position).poster).resize(800, 800).centerCrop().into(holder.poster)
    }
}