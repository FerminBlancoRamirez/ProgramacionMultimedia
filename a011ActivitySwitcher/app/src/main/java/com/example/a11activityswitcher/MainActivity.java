package com.example.a11activityswitcher;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText texto1;
    EditText texto2;
    Button boton;
    TextView resultado;
    Intent intento;
    Intent intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        texto1 = findViewById(R.id.editTextNumber);
        texto2 = findViewById(R.id.editTextNumber2);
        boton = findViewById(R.id.button);
        resultado=findViewById(R.id.resultado);
        intento = new Intent();
        intent2 = getIntent();


        boton.setOnClickListener(v -> {

           if (funciona()) {
               intento.setClass(MainActivity.this, SecondActivity.class);
               startActivity(intento);
           }
        });

        if (intent2 != null && intent2.hasExtra("Resultado")) {
            int numeroResultado = intent2.getIntExtra("Resultado", 0);
            resultado.setText(String.valueOf(numeroResultado));
        }
    }

    public boolean funciona(){

        int numero1=0;
        int numero2=0;
        if (!texto1.getText().toString().isEmpty()){
            numero1=Integer.parseInt(texto1.getText().toString());
            intento.putExtra("numero1", numero1);

        }else {
            texto1.setError("Por favor introduce un numero");
            return false;
        }
        if (!texto2.getText().toString().isEmpty()){
            numero2=Integer.parseInt(texto2.getText().toString());
            intento.putExtra("Numero2", numero2);
        }else {
            texto2.setError("Por favor introduce un numero");
            return false;
        }

        return true;
    }
}