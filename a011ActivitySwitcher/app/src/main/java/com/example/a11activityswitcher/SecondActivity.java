package com.example.a11activityswitcher;

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
    Button boton;
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
        boton = findViewById(R.id.button);


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

        int resultado = numero1 + numero2;

        boton.setOnClickListener(v -> {
            intento2.putExtra("Resultado", resultado);
            intento2.setClass(SecondActivity.this, MainActivity.class);
            startActivity(intento2);
        });
    }
}