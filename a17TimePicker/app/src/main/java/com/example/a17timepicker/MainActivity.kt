package com.example.a17timepicker

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextClock
import android.widget.TextView
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var timePicker: TimePicker
    private lateinit var timeClock: TextClock
    private lateinit var horas: TextView
    private lateinit var introducirHoras: EditText
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

        timePicker = findViewById(R.id.TimePicker)
        timeClock = findViewById(R.id.TextClock)
        horas = findViewById(R.id.Horas)
        introducirHoras = findViewById(R.id.EntradaDeHoras)
        boton = findViewById(R.id.Boton)

        timePicker.setOnTimeChangedListener { _, hourOfDay, minute ->
            val time = String.format("%02d:%02d", hourOfDay, minute)
            timeClock.text = time
            horas.text = time
        }

        boton.setOnClickListener {
            val time = introducirHoras.text.toString()
            val partes=time.split(":")
            val hora=partes[0].toInt()
            val minuto=partes[1].toInt()
            horas.text = time
            timePicker.hour = hora
            timePicker.minute = minuto
        }

    }
}