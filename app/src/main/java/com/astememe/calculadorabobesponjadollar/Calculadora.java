package com.astememe.calculadorabobesponjadollar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculadora extends AppCompatActivity {
    String calculo;
    Double resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button num_1 = findViewById(R.id.num1);
        Button num_2 = findViewById(R.id.num2);
        Button num_3 = findViewById(R.id.num3);
        Button num_4 = findViewById(R.id.num4);
        Button num_5 = findViewById(R.id.num5);
        Button num_6 = findViewById(R.id.num6);
        Button num_7 = findViewById(R.id.num7);
        Button num_8 = findViewById(R.id.num8);
        Button num_9 = findViewById(R.id.num9);
        Button num_0 = findViewById(R.id.num0);

        Button plus =           findViewById(R.id.symbol_plus);
        Button minus =          findViewById(R.id.symbol_minus);
        Button multi =          findViewById(R.id.symbol_multi);
        Button div =            findViewById(R.id.symbol_div);
        Button porcentaje =     findViewById(R.id.symbol_percent);
        Button igual =          findViewById(R.id.symbol_equal);
        Button borrar =         findViewById(R.id.boton_borrar);
        Button nuke =           findViewById(R.id.nuke);

        TextView caja_calculo = findViewById(R.id.cajaresultado);

        List<Button> botonesNumericos = new ArrayList<>(Arrays.asList(
                findViewById(R.id.num0),
                findViewById(R.id.num1),
                findViewById(R.id.num2),
                findViewById(R.id.num3),
                findViewById(R.id.num4),
                findViewById(R.id.num5),
                findViewById(R.id.num6),
                findViewById(R.id.num7),
                findViewById(R.id.num8),
                findViewById(R.id.num9),
                findViewById(R.id.num0)
                ));

        List<Button> botonesCalculo = new ArrayList<>(Arrays.asList(
                findViewById(R.id.symbol_plus),
                findViewById(R.id.symbol_minus),
                findViewById(R.id.symbol_multi),
                findViewById(R.id.symbol_div),
                findViewById(R.id.symbol_percent),
                findViewById(R.id.symbol_equal),
                findViewById(R.id.boton_borrar),
                findViewById(R.id.nuke)
        ));


        calculo = "";
        resultado = 0.0;

        for (Button botonNumerico:botonesNumericos) {
            botonNumerico.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    caja_calculo.setText(caja_calculo.getText().toString() + botonNumerico.getText().toString());
                }
            });
        }
    }





}