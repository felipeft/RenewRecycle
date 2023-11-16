package com.example.renewrecycle_projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RecycleEmp extends AppCompatActivity {

    EditText Empresa;
    EditText Contato;
    EditText Horario;
    EditText Pesagem;
    Button Salvar;
    private TextView Voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reciclagem_emp);

        Empresa = findViewById(R.id.EmpInf);
        Contato = findViewById(R.id.ContatoInf);
        Horario = findViewById(R.id.HorarioInf);
        Pesagem = findViewById(R.id.PesagemInf);
        Salvar = findViewById(R.id.btnSalvar);
        Voltar = findViewById(R.id.btnVoltar);

        Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Alterações Salvas", Toast.LENGTH_SHORT).show();
                // Colocar no banco de dados as alterações
            }
        });

        Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // startActivity(new Intent(RecycleEmp.this, MAPA.class));
            }
        });
    }
}