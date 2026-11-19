package com.example.a19cardview

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    /*Declarar instancias globales */
    private var recycler: RecyclerView? = null
    private var adapter: AnimeAdapter? = null
    private var lManager: RecyclerView.LayoutManager? = null
    private var repositorio: DataRepository? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        //AUN NO ESTA
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Obtener el Recycler
        recycler = findViewById(R.id.recyclerView)
        recycler?.setHasFixedSize(true)

        // Usar un administrador para LinearLayout
        lManager = LinearLayoutManager(this)
        recycler?.layoutManager = lManager

        // Crear un nuevo adaptador
        repositorio = DataRepository()
        val animeAdapter = AnimeAdapter(repositorio!!.obtenerListaAnimes())
        adapter = animeAdapter
        recycler?.adapter = adapter

        val btnAgregar = findViewById<Button>(R.id.button)
        btnAgregar.setOnClickListener {
            val nuevoAnime = Anime(0, "", 0)
            animeAdapter.addAnime(nuevoAnime)
            recycler?.scrollToPosition(animeAdapter.itemCount - 1)
        }
    }
}