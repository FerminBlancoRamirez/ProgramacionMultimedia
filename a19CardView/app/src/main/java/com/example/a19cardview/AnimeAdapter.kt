package com.example.a19cardview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a19cardview.AnimeAdapter.AnimeViewHolder


//ojo
/**
 * Creado por Hermosa Programación
 */
class AnimeAdapter(private val items: MutableList<Anime?>) :
    RecyclerView.Adapter<AnimeViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): AnimeViewHolder {
        // Creamos una nueva vista inflando el layout anime_card.xml
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.anime_card, viewGroup, false)
        return AnimeViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: AnimeViewHolder, i: Int) {
        val item = items[i]
        if (item != null) {
            if (item.imagen != 0) {
                viewHolder.imagen.setImageResource(item.imagen)
            } else {
                viewHolder.imagen.setImageDrawable(null)
            }
            viewHolder.nombre.text = item.nombre ?: ""
            viewHolder.visitas.text = if ((item.nombre.isNullOrEmpty()) && item.visitas == 0) "" else "Visitas: ${item.visitas}"
        }
    }

    fun addAnime(anime: Anime) {
        items.add(anime)
        notifyItemInserted(items.size - 1)
    }

    //CLASE INTERNA ESTATICA PARA MANIPULAR LAS CARDS
    class AnimeViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // Campos respectivos de un item
        val imagen: ImageView = v.findViewById(R.id.imagen)
        val nombre: TextView = v.findViewById(R.id.nombre)
        val visitas: TextView = v.findViewById(R.id.visitas)
    }
}
