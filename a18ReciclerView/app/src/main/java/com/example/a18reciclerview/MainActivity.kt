package com.example.a18reciclerview

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var editText: EditText
    private lateinit var button: Button

    private lateinit var buttonEliminar: Button
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Inicialización correcta de las vistas
        recyclerView = findViewById(R.id.ReciclerView)
        button = findViewById(R.id.Boton)
        buttonEliminar = findViewById(R.id.BotonEliminar)
        editText = findViewById(R.id.Nombres)

        // 2. Configuración del RecyclerView y el Adapter
        adapter = RecyclerViewAdapter(listaNombres)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // 3. Configuración del evento de clic
        button.setOnClickListener {
            val nombre = editText.text.toString().trim()
            if (nombre.isNotEmpty()) {
                val nuevoObjeto = Nombres(nombre)
                listaNombres.add(nuevoObjeto)

                // Notificar al adaptador usando la variable 'adapter'
                adapter.notifyItemInserted(listaNombres.size - 1)

                // Scroll automático al nuevo elemento
                recyclerView.scrollToPosition(listaNombres.size - 1)

                // Limpiar el campo de texto
                editText.text.clear()
            }
        }

        buttonEliminar.setOnClickListener {
            val nombre = editText.text.toString().trim()
            if (listaNombres.isNotEmpty() && nombre.isNotEmpty()) {
                val indice = listaNombres.indexOfFirst { it.nombre == nombre }
                if (indice != -1) {
                    listaNombres.removeAt(indice)
                    adapter.notifyItemRemoved(indice)
                    editText.text.clear()
            }
        }
    }
    }
}