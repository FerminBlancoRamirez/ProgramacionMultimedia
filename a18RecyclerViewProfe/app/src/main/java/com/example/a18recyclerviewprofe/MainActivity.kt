package com.example.a18recyclerviewprofe



import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    // Instanciación del ViewModel mediante KTX
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adaptador: MiAdaptador
    private lateinit var boton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.ReciclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Inicializamos el adaptador pasando la acción a realizar al pulsar (eliminar)
        adaptador = MiAdaptador { posicion ->
            viewModel.eliminarPais(posicion)
        }
        recyclerView.adapter = adaptador

        boton = findViewById(R.id.Boton)
        boton.setOnClickListener {
            val nuevoPais = findViewById<EditText>(R.id.Nombres).text.toString()
            viewModel.agregarPais(nuevoPais)
        }

        // Observamos el estado expuesto por el ViewModel
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.paises.collect { listaActualizada ->
                    adaptador.actualizarLista(listaActualizada)
                }
            }
        }
    }
}