package com.example.a18reciclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//Creamos el adapter añadiendole la lista de nombres
//Extiende de RecyclerView.Adapter
class RecyclerViewAdapter(private val listaNombres: List<Nombres>) :
    RecyclerView.Adapter<RecyclerViewAdapter.NombresViewHolder>() {
    //Creamos la clase NombresViewHolder que extiende de RecyclerView.ViewHolder
    class NombresViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Obtenemos las referencias a los controles del layout elemento.xml
        val imgFlag: ImageView = view.findViewById(R.id.imgFlag)
        //Instanciamos el TextView del modelo que creamos en el layout
        val tvNombre: TextView = view.findViewById(R.id.Texto)

    }

    //Creamos el ViewHolder y inflamos el layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NombresViewHolder {
        val view = LayoutInflater.from(parent.context)
            //Lo inflamos con el elemento de texto creado
            .inflate(R.layout.elemento, parent, false)
        return NombresViewHolder(view)
    }

    //Conectamos el viewHolder con el modelo
    override fun onBindViewHolder(holder: NombresViewHolder, position: Int) {
        //Accede a cada posicion de la lista y añade el nombre correspondiente a la vista
        val item = listaNombres[position]
        holder.tvNombre.text = item.nombre
        //Buscamos el ID del PNG en drawable usando el código ISO
        val context = holder.itemView.context
        val flagResId = context.resources.getIdentifier(
            item.countryCode.lowercase(),
            "drawable",
            context.packageName
        )
        //Si encuentra la imagen en la carpeta drawable, la asigna
        if (flagResId != 0) {
            holder.imgFlag.setImageResource(flagResId)
        }
    }

    override fun getItemCount(): Int = listaNombres.size
}