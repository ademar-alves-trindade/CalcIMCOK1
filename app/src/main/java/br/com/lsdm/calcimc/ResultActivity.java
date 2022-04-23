package br.com.lsdm.calcimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView tvNome;
    TextView tvAltura;
    TextView tvPeso;

    TextView tvRes;
    TextView tvResClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvNome = findViewById(R.id.textViewNome);
        tvAltura = findViewById(R.id.textViewAltura);
        tvPeso = findViewById(R.id.textViewPeso);
        tvRes = findViewById(R.id.textViewIMC);
        tvResClass = findViewById(R.id.textViewClasse);


        //getIntent().getDoubleExtra(tvAltura);
        Bundle valores = getIntent().getExtras();

        String nome = valores.getString("nome");
        Double alt = valores.getDouble("alt");
        Double peso = valores.getDouble("peso");


        tvNome.setText(nome);
        tvAltura.setText("Altura: " + alt + " m");
        tvPeso.setText("Peso: " + peso + " kg");

        calcularIMC(alt, peso);
    }
        private void calcularIMC (double altura, double peso){
            double imc = peso / (altura * altura);

            tvRes.setText(String.format("%.2f", imc));

            if (imc >= 19 && imc <25){
                tvResClass.setText("Peso Ideal");
            } else if (imc >= 25 && imc <30) {
                tvResClass.setText("Sobrepeso");
            }else if (imc >= 30 && imc <35){
                tvResClass.setText("Obsidade Grau 1");
            }else if (imc >= 35 && imc <40){
                tvResClass.setText("Obsidade Grau 2");
            }else{
                tvResClass.setText("Obsidade Grau 3");
            }
        }
}