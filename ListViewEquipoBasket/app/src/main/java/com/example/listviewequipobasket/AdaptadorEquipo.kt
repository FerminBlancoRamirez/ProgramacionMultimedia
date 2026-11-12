package com.example.listviewequipobasket

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class AdaptadorEquipo// Set the layout resource ID
//constructor
    (
    context: Context, // Add this field to store the layout resource ID
    private val layoutResId: Int, //COMO  IMPLEMENTO UN BORRADO EN EL ADAPTADOR????????????????????????
    // Lo que vamos a cargar en cada uno de los equipo.xml que van a las posiciones del listView
    private val listaEquipos: MutableList<Equipo>
) : ArrayAdapter<Equipo?>(
    context,
    layoutResId, listaEquipos
) {
    //metodo que lleva la cuenta de los equipos que hay en el listView
    override fun getCount(): Int {
        return listaEquipos.size
    }

    //me devuelve un objeto Equipo en la posicion pasada por parametro
    override fun getItem(position: Int): Equipo? {
        return listaEquipos.get(position)
    }

    //la gente dice que sobra
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //falta inflar cada vista EQUIPO.xml con los datos del objeto Equipo (ES EL BIND ENTRE EL DATO Y LA VISTA
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (view == null) {
            val inflater = LayoutInflater.from(getContext())
            //ojo con el layoutResId
            //view = inflater.inflate(layoutResId, parent, false);
            view = inflater.inflate(R.layout.equipo, parent, false)
        }
        //para bindear
        val clubName = view.findViewById<TextView>(R.id.tv_clubName)
        val country = view.findViewById<TextView>(R.id.tv_country)
        val city = view.findViewById<TextView>(R.id.tv_city)
        val year = view.findViewById<TextView>(R.id.tv_year)
        val imagen = view.findViewById<ImageView>(R.id.iv_escudo)
        //obtener el objeto Equipo en la posicion pasada por parametro
        val elemento = listaEquipos.get(position)
        //setear los datos en los TextView
        clubName.setText(elemento.nombre)
        country.setText(elemento.pais)
        city.setText(elemento.ciudad)
        year.setText(elemento.fundacion.toString())
        imagen.setImageResource(elemento.idImage)

        //falta borrar el equipo de la lista
        view.setOnClickListener(View.OnClickListener { view1: View? ->
            listaEquipos.remove(elemento)
            notifyDataSetChanged()
        })

        return view
    }


    fun addEquipo(equipo: Equipo?) {
        listaEquipos.add(equipo!!)
        notifyDataSetChanged()
    }
}




