package com.example.a12ejerciciodeexamen;

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

    TextView galonesSecond;
    TextView pintasSecond;
    TextView solucionLitros;
    Button botonCalcular;
    Button MandarResultado;
    Intent intento;
    Intent intento2;
    double galonesNumero=0.0;
    double pintasNumero=0.0;
    double solucion=0.0;

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

        galonesSecond=findViewById(R.id.GalonesSecond);
        pintasSecond=findViewById(R.id.PintasSecond);
        solucionLitros=findViewById(R.id.SolucionSecond);
        botonCalcular=findViewById(R.id.Boton2);
        MandarResultado=findViewById(R.id.Boton3);
        intento=new Intent();
        intento2=getIntent();

        if (intento2 != null){
            galonesNumero=intento2.getDoubleExtra("galones", 0);
            pintasNumero=intento2.getDoubleExtra("pintas", 0);
        }

        galonesSecond.append(String.valueOf(galonesNumero));
        pintasSecond.append(String.valueOf(pintasNumero));

        botonCalcular.setOnClickListener(e->{
            solucion = galonesALitros(galonesNumero)+pintasALitros(pintasNumero);
            solucionLitros.append(String.valueOf(solucion));
        });

        MandarResultado.setOnClickListener(e->{
            intento.putExtra("solucion", solucion);
            intento.putExtra("galones", galonesNumero);
            intento.putExtra("pintas", pintasNumero);
            intento.setClass(SecondActivity.this, MainActivity.class);
            startActivity(intento);
        });
    }

    public double galonesALitros(double galones){
        return galones*3.785; //estadounidenses
    }

    public double pintasALitros(double pintas){
        return pintas*0.454; //estadounidenses
    }
}