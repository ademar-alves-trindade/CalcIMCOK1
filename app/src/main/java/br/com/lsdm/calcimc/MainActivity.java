package br.com.lsdm.calcimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etNome;
    EditText etAlt;
    EditText etPeso;
    Button botCad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            etNome = findViewById(R.id.editTextNome);
            etAlt = findViewById(R.id.editTexAltura);
            etPeso = findViewById(R.id.editTextPeso);
            botCad = findViewById(R.id.buttonCadastrar);

    }

    public void resultado(View view) {

        String nome = etNome.getText().toString();
        Double alt = Double.parseDouble(etAlt.getText().toString());
        Double peso = Double.parseDouble(etPeso.getText().toString());


        Intent intencao = new Intent(MainActivity.this, ResultActivity.class);

        intencao.putExtra("nome", nome);
        intencao.putExtra("alt", alt);
        intencao.putExtra("peso", peso);
        startActivity(intencao);
    }
}