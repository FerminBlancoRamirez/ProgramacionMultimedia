package com.example.b07numeroprimos;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



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
        Button boton=findViewById(R.id.boton);
        EditText texto;
        TextView respuesta;

        texto=findViewById(R.id.eTMeterNumeros);
        respuesta = findViewById(R.id.tVMultiline);
        boton.setOnClickListener(v->{
            String numeros=texto.getText().toString();
            try {
                int numeroTexto = Integer.parseInt(numeros);
                if (numeros.isEmpty() || numeroTexto>1000){
                    Toast.makeText(MainActivity.this,"No puedes clicar sin ningun valor o que el valor sea mayor que mil",Toast.LENGTH_SHORT).show();
                }
                String resultado=String.valueOf(retornarPrimo(numeroTexto));
                respuesta.setText(resultado);
            }catch (NumberFormatException e){
                e.printStackTrace();
            }
        });


    }

    public int retornarPrimo(int numero){
        int contadorPrimos = 0;
        int numeroActual = 2; // El primer número primo es el 2

        while (true) {
            if (esPrimo(numeroActual)) {
                contadorPrimos++;
                if (contadorPrimos == numero) {
                    return numeroActual;
                }
            }
            numeroActual++;
        }
    }

    private static boolean esPrimo(int numero) {
        if (numero <= 1) return false;
        if (numero <= 3) return true;
        if (numero % 2 == 0 || numero % 3 == 0) return false;

        // Comprobar divisores desde 5 hasta la raíz cuadrada de 'numero'
        for (int i = 5; i * i <= numero; i += 6) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}