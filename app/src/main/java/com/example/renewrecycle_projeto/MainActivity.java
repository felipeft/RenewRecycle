package com.example.renewrecycle_projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText Email;
    EditText Senha;
    Button Entrar;
    private TextView Emp;
    private TextView Cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = findViewById(R.id.edtEmail);
        Senha = findViewById(R.id.edtSenha);
        Entrar = findViewById(R.id.btnEntrar);
        Emp = findViewById(R.id.ContaEmp);
        Cadastro = findViewById(R.id.Cadastrar);

        Entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InicioUser.class));
            }
        });

        Emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Login_Empresa.class));
            }
        });

        Cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Create_User.class));
            }
        });
    }
}