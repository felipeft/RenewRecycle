package com.example.renewrecycle_projeto;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login_Empresa extends AppCompatActivity{

    EditText Email;
    EditText Senha;
    Button Entrar;
    private TextView Pessoal;
    private TextView Cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_empresa);

        Email = findViewById(R.id.edtEmail);
        Senha = findViewById(R.id.edtSenha);
        Entrar = findViewById(R.id.btnEntrar);
        Pessoal = findViewById(R.id.ContaEmp);
        Cadastro = findViewById(R.id.Cadastrar);

        Entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Empresa.this, InicioEmp.class));
            }
        });

        Pessoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Empresa.this, MainActivity.class));
            }
        });

        Cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login_Empresa.this, Create_Emp.class));
            }
        });

    }
}
