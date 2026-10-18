package com.example.a13calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class SecondActivity extends AppCompatActivity {

    TextView texto1;
    TextView texto2;
    Button botonSuma;
    Button botonResta;
    Button botonMultiplicacion;
    Button botonDividir;
    Intent intento;
    Intent intento2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        texto1 = findViewById(R.id.textView3);
        texto2 = findViewById(R.id.textView4);
        botonSuma = findViewById(R.id.buttonSuma);
        botonResta = findViewById(R.id.buttonResta);
        botonMultiplicacion = findViewById(R.id.buttonMultiplicacion);
        botonDividir = findViewById(R.id.buttonDividir);


        intento = getIntent();
        intento2 = new Intent();

        int numero1 = 0;
        int numero2 = 0;

        if (intento != null) {
            numero1 = intento.getIntExtra("numero1", 0);
            numero2 = intento.getIntExtra("Numero2", 0);
        }

        texto1.setText(String.valueOf(numero1));
        texto2.setText(String.valueOf(numero2));

        double resultadoSuma = numero1 + numero2;
        double resultadoResta = numero1 - numero2;
        double resultadoMultiplicacion = numero1 * numero2;
        double resultadoDivision = numero1 / numero2;

        botonSuma.setOnClickListener(v -> {
            intento2.putExtra("Resultado", resultadoSuma);
            intento2.setClass(SecondActivity.this, MainActivity.class);
            startActivity(intento2);
        });
        botonResta.setOnClickListener(v -> {
            intento2.putExtra("Resultado", resultadoResta);
            intento2.setClass(SecondActivity.this, MainActivity.class);
            startActivity(intento2);
        });
        botonMultiplicacion.setOnClickListener(v -> {
            intento2.putExtra("Resultado", resultadoMultiplicacion);
            intento2.setClass(SecondActivity.this, MainActivity.class);
            startActivity(intento2);
        });
        botonDividir.setOnClickListener(v -> {
            intento2.putExtra("Resultado", resultadoDivision);
            intento2.setClass(SecondActivity.this, MainActivity.class);
            startActivity(intento2);
        });
    }
}