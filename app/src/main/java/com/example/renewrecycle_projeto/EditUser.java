package com.example.renewrecycle_projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditUser extends AppCompatActivity {

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
        setContentView(R.layout.edit_user);

        Nome = findViewById(R.id.NomeUser);
        Email = findViewById(R.id.EmailUser);
        Celular = findViewById(R.id.CelularUser);
        Endereco = findViewById(R.id.AddressUser);
        Senha = findViewById(R.id.SenhaUser);
        Salvar = findViewById(R.id.btnSalvar);
        Voltar = findViewById(R.id.btnVoltar);

        Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SALVAR NO BANCO DE DADOS
                Toast.makeText(getApplicationContext(), "Alterações Salvas", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(EditUser.this, InicioUser.class));
            }
        });

        Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditUser.this, InicioUser.class));
            }
        });
    }
}