package com.claytoneduard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // atributos
    private EditText ediValor;
    private TextView textPorcentagem, textGorjeta, txtTotal;
    private SeekBar seekBarGorjeta;
    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //capturando dados da View
        ediValor = findViewById(R.id.editValor);
        textPorcentagem = findViewById(R.id.textPorcentagem);
        textGorjeta = findViewById(R.id.textGorjeta);
        txtTotal = findViewById(R.id.textTotal);
        seekBarGorjeta = findViewById(R.id.seekBarGorjeta);

        // Listener Seekbar

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                porcentagem = progress;
                textPorcentagem.setText(Math.round(porcentagem) + " %");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular() {
        String valorRecuperado = ediValor.getText().toString();
        if (valorRecuperado.equals("") || valorRecuperado == null) {

            //alerta simples
            Toast.makeText(getApplicationContext(), "Digite um valor primeiro!", Toast.LENGTH_LONG).show();

        } else {

            //Converter string para double
            double valorDigitado = Double.parseDouble(valorRecuperado);

            // calcula a gorjeta total
            double gorjeta = valorDigitado * (porcentagem / 100);

            double total = gorjeta + valorDigitado;

            // exibe a gorjeta e total
            //textGorjeta.setText("R$ " + Math.round(gorjeta));
            textGorjeta.setText("R$ " + gorjeta);

            // valor total
            txtTotal.setText("R$ " + total);

        }
    }


}