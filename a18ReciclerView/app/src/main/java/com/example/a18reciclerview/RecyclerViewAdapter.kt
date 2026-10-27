package com.example.a18reciclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val listaNombres: List<Nombres>) :
    RecyclerView.Adapter<RecyclerViewAdapter.NombresViewHolder>() {

    class NombresViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNombre: TextView = view.findViewById(android.R.id.text1) // O tu id personalizado
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NombresViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)
        return NombresViewHolder(view)
    }

    override fun onBindViewHolder(holder: NombresViewHolder, position: Int) {
        holder.tvNombre.text = listaNombres[position].nombre
    }

    override fun getItemCount(): Int = listaNombres.size
}