package com.example.a16calendarpicker

import                   android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var mostrarFecha: EditText
    private lateinit var introducirFecha: EditText
    private lateinit var calendario: CalendarView
    private lateinit var boton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mostrarFecha = findViewById(R.id.ResultadoCalendario)
        introducirFecha = findViewById(R.id.IntroducirFecha)
        calendario = findViewById(R.id.Calendario)
        boton = findViewById(R.id.Boton)



        calendario.setOnDateChangeListener { view, year, month, dayOfMonth ->
            mostrarFecha.setText("$dayOfMonth/${month + 1}/$year")
        }
        val formatoFecha = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        boton.setOnClickListener {
            val textoFecha = introducirFecha.text.toString()
            try{
                val fecha: Date? = formatoFecha.parse(textoFecha)
                if (fecha!=null){
                    calendario.setDate(fecha.time, true, true)
                }
            }catch (e:java.text.ParseException){
                e.printStackTrace()
                Toast.makeText(this, "Formato de fecha incorrecto", Toast.LENGTH_SHORT).show()
            }

        }

    }
}