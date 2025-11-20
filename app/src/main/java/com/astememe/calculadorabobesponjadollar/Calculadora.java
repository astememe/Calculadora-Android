package com.astememe.calculadorabobesponjadollar;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculadora extends AppCompatActivity {
    ImageView esponja;
    String calculo;
    Double resultado;
    String numero_introducido;
    TextView caja_calculo;
    Button div;
    Button num_1;
    Button num_2;
    Button num_3;
    Button num_4;
    Button num_5;
    Button num_6;
    Button num_7;
    Button num_8;
    Button num_9;
    Button num_0;

    Button porcentaje;
    Button igual;
    Button borrar;
    Button nuke;
    Button plus;
    Button minus;
    Button multi;
    List<Button> botonesCalculo;
    List<Button> botonesNumericos;


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

        num_1 = findViewById(R.id.num1);
        num_2 = findViewById(R.id.num2);
        num_3 = findViewById(R.id.num3);
        num_4 = findViewById(R.id.num4);
        num_5 = findViewById(R.id.num5);
        num_6 = findViewById(R.id.num6);
        num_7 = findViewById(R.id.num7);
        num_8 = findViewById(R.id.num8);
        num_9 = findViewById(R.id.num9);
        num_0 = findViewById(R.id.num0);

        plus = findViewById(R.id.symbol_plus);
        minus = findViewById(R.id.symbol_minus);
        multi = findViewById(R.id.symbol_multi);
        div = findViewById(R.id.symbol_div);
        porcentaje = findViewById(R.id.symbol_percent);
        igual = findViewById(R.id.symbol_equal);
        borrar = findViewById(R.id.boton_borrar);
        nuke = findViewById(R.id.nuke);

        caja_calculo = findViewById(R.id.cajaresultado);

        botonesNumericos = new ArrayList<>(Arrays.asList(
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

        botonesCalculo = new ArrayList<>(Arrays.asList(
                findViewById(R.id.symbol_plus),
                findViewById(R.id.symbol_minus),
                findViewById(R.id.symbol_multi),
                findViewById(R.id.symbol_div),
                findViewById(R.id.symbol_percent),
                findViewById(R.id.symbol_decimal),
                findViewById(R.id.symbol_equal),
                findViewById(R.id.boton_borrar)
        ));

        esponja = findViewById(R.id.esponja);


        calculo = "";
        resultado = 0.0;

        for (Button botonNumerico:botonesNumericos) {
            botonNumerico.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mostrarNumero(botonNumerico);
                }
            });
        }

        for (Button simbolo:botonesCalculo) {
            simbolo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mostrarSimbolo(simbolo);
                }
            });
        }

        nuke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculo = "";
                caja_calculo.setText(calculo);
            }
        });
    }

    public void mostrarSimbolo(Button simbolo) {
        boolean esSimbolo = false;
        if (simbolo.getText().toString().equals("=")) {
            if (calculo.endsWith(div.getText().toString() + num_0.getText().toString())) {
                caja_calculo.setText("Undefined");
                calculo = calculo.substring(0, calculo.length()-2);
            }
            else {
                caja_calculo.setText(Double.toString(calcular(calculo)));
                calculo = caja_calculo.getText().toString();
            }
        }
        else {
            for (Button botonCalculo: botonesCalculo) {
                if (!calculo.isEmpty() && String.valueOf(calculo.charAt(calculo.length()-1)).equals(botonCalculo.getText().toString())) {
                    esSimbolo = true;
                }
            }
            if (simbolo.getText().toString().equals(borrar.getText().toString())) {
                calculo = calculo.substring(0, calculo.length()-1);
                caja_calculo.setText(calculo);
            }
            if (!calculo.isEmpty() && !esSimbolo) {
                caja_calculo.setText(calculo);
                if (simbolo.getText().toString().equals("%")) {
                    calculo += "/100*";
                } else {
                    calculo += simbolo.getText().toString();
                }
                numero_introducido = "";
                caja_calculo.setText(calculo);
            }
        }
    }

    public void mostrarNumero(Button numero) {
        calculo += numero.getText().toString();
        numero_introducido += numero.getText().toString();
        caja_calculo.setText(calculo);
    }

    public double calcular(String calculo) {
        Expression expression = new Expression(calculo);
        if (expression.calculate() == 69.0 || expression.calculate() >= 1000000) {
            Glide
                    .with(this)
                    .load("https://i.pinimg.com/564x/02/2a/75/022a75f3f3b099fd5293d0712b6dfe63.jpg")
                    .centerCrop()
                    .into(esponja);
        }
        else {
            Glide
                    .with(this)
                    .clear(esponja);
        }
        return expression.calculate();
    }
}