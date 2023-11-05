package com.example.renewrecycle_projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Create_User extends AppCompatActivity {

    Button User;
    Button Company;
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
        setContentView(R.layout.create_user);

        User = findViewById(R.id.btnUser);
        Company = findViewById(R.id.btnCompany);
        Nome = findViewById(R.id.NomeUser);
        Email = findViewById(R.id.EmailUser);
        Celular = findViewById(R.id.CelularUser);
        Endereco = findViewById(R.id.AddressUser);
        Senha = findViewById(R.id.SenhaUser);
        Salvar = findViewById(R.id.btnSalvar);
        Voltar = findViewById(R.id.btnVoltar);

        Company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Create_User.this, Create_Emp.class));
            }
        });

        Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SALVAR NO BANCO DE DADOS
                Toast.makeText(getApplicationContext(), "Você foi cadastrado", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Create_User.this, MainActivity.class));
            }
        });

        Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Create_User.this, MainActivity.class));
            }
        });
    }
}