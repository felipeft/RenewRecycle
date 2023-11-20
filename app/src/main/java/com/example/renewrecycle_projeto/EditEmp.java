package com.example.renewrecycle_projeto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class EditEmp extends AppCompatActivity {

    EditText Nome;
    EditText Email;
    EditText Celular;
    EditText Endereco;
    EditText Senha;
    Button Salvar;
    private TextView Voltar;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String empID;
    String EmpID;
    String CNPJ;
    String Horario;
    String Peso;

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
                SalvarDadosUser();
                Toast.makeText(getApplicationContext(), "Alterações Salvas", Toast.LENGTH_SHORT).show();
               // startActivity(new Intent(EditEmp.this, InicioEmp.class));
            }
        });

        Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditEmp.this, InicioEmp.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        empID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference DocRefer = db.collection("Empresas").document(empID);
        DocRefer.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if (documentSnapshot != null){
                    Nome.setText(documentSnapshot.getString("nome"));
                    Email.setText(email);
                    Celular.setText(documentSnapshot.getString("celular"));
                    Endereco.setText(documentSnapshot.getString("endereco"));
                    CNPJ = documentSnapshot.getString("cnpj");
                    Horario = documentSnapshot.getString("horario");
                    Peso = documentSnapshot.getString("peso");
                }
            }
        });
    }

    private void SalvarDadosUser(){
        String nome = Nome.getText().toString();
        String celular = Celular.getText().toString();
        String endereco = Endereco.getText().toString();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String,Object> users = new HashMap<>();
        users.put("nome", nome);
        users.put("celular", celular);
        users.put("endereco", endereco);
        users.put("cnpj", CNPJ);
        users.put("horario", Horario);
        users.put("peso", Peso);

        EmpID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        DocumentReference docRefer = db.collection("Empresas").document(EmpID);
        docRefer.set(users).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("db","Sucesso ao salvar os dados");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d("db_error","Erro ao salvar os dados" + e.toString());
                    }
                });
    }
}