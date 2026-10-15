package com.example.a12ejerciciodeexamen;

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

    Intent intent;
    Intent intent2;
    EditText galones;
    EditText pintas;
    Button mandarDatos;
    TextView solucion;

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
        intent=new Intent();
        galones=findViewById(R.id.GalonesRecoger);
        pintas=findViewById(R.id.PintasRecoger);
        mandarDatos=findViewById(R.id.Boton);
        solucion=findViewById(R.id.Solucion);

        mandarDatos.setOnClickListener(view -> {
            if(funciona()){
                intent.setClass(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        intent2=getIntent();
        if (intent2 != null && intent2.hasExtra("solucion")){
            double solucionSecond=intent2.getDoubleExtra("solucion", 0);
            double galonesSecond=intent2.getDoubleExtra("galones", 0);
            double pintasSecond=intent2.getDoubleExtra("pintas", 0);
            galones.setText(String.valueOf(galonesSecond));
            pintas.setText(String.valueOf(pintasSecond));
            solucion.append(String.valueOf(solucionSecond));
        }



    }

    public boolean funciona(){

        double numero1=0;
        double numero2=0;
        if (!galones.getText().toString().isEmpty()){
            numero1=Double.parseDouble(galones.getText().toString());
            intent.putExtra("galones", numero1);

        }else {
            galones.setError("Por favor introduce un numero");
            return false;
        }
        if (!pintas.getText().toString().isEmpty()){
            numero2=Double.parseDouble(pintas.getText().toString());
            intent.putExtra("pintas", numero2);
        }else {
            pintas.setError("Por favor introduce un numero");
            return false;
        }

        return true;
    }
}