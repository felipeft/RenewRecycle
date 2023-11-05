package com.example.renewrecycle_projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditEmp extends AppCompatActivity {

    EditText Nome;
    EditText Email;
    EditText Celular;
    EditText Endereco;
    EditText Senha;
    Button Salvar;
    private TextView Voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_emp);

        Nome = findViewById(R.id.NomeCompany);
        Email = findViewById(R.id.EmailCompany);
        Celular = findViewById(R.id.CelularCompany);
        Endereco = findViewById(R.id.AddressCompany);
        Senha = findViewById(R.id.SenhaCompany);
        Salvar = findViewById(R.id.btnSalvar);
        Voltar = findViewById(R.id.btnVoltar);

        Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SALVAR NO BANCO DE DADOS
                Toast.makeText(getApplicationContext(), "Alterações Salvas", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditEmp.this, InicioEmp.class));
            }
        });

        Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditEmp.this, InicioEmp.class));
            }
        });
    }
}