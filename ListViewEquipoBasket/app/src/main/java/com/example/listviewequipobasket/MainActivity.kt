package com.example.listviewequipobasket

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.OnApplyWindowInsetsListener
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var listView: ListView? = null
    var button: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById<View?>(R.id.main),
            OnApplyWindowInsetsListener { v: View?, insets: WindowInsetsCompat? ->
                val systemBars = insets!!.getInsets(WindowInsetsCompat.Type.systemBars())
                v!!.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            })

        listView = findViewById<ListView>(R.id.listView)
        val equipoRepository = EquipoRepository()
        val adaptadorEquipo = AdaptadorEquipo(
            this, R.layout.equipo,
            equipoRepository.listaEquipos
        )
        listView!!.setAdapter(adaptadorEquipo)

        button = findViewById<Button>(R.id.button)
        button!!.setOnClickListener(View.OnClickListener { view: View? ->
            // Crear un nuevo equipo y agregarlo al adaptador
            val nombre = findViewById<TextView>(R.id.nombre)
            val ciudad = findViewById<TextView>(R.id.ciudad)
            val pais = findViewById<TextView>(R.id.pais)
            val fundacion = findViewById<TextView>(R.id.fundacion)
            val imagen = findViewById<ImageView?>(R.id.logo)

            //imagen.getId da problemas --> imagen.getId()
            //imagen getDrawable da un drawable pero no la id de esa imagen
            //por ejemplo R.drawable.avatar_7

            //FALTA DE LOGICA DE PROGRAMA
            val equipo = Equipo(
                nombre.getText().toString(),
                ciudad.getText().toString(), pais.getText().toString(),
                fundacion.getText().toString().toInt(),
                R.drawable.avatar_7
            )
            adaptadorEquipo.addEquipo(equipo)
            listView!!.setSelection(adaptadorEquipo.getCount() - 1)
        })
    }
}