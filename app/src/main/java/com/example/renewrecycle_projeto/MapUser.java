package com.example.renewrecycle_projeto;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MapUser extends AppCompatActivity {

    private static final String TAG = "MapUser";
    private FirebaseFirestore db;
    private ListView userListview;
    private List<User> empresas; // Lista de User (não DocumentSnapshot)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa_user);

        db = FirebaseFirestore.getInstance();
        userListview = findViewById(R.id.userListView);
        empresas = new ArrayList<>(); // Inicializa a lista

        // Recupera todos os documentos da coleção "usuarios"
        db.collection("Empresas")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            List<String> userNames = new ArrayList<>();

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                // Para cada documento, converte para a classe de modelo User
                                User empresa = document.toObject(User.class);
                                empresas.add(empresa); // Adiciona o User à lista
                                userNames.add(empresa.getNome());
                            }

                            // Exibe a lista de nomes na ListView
                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                                    MapUser.this,
                                    android.R.layout.simple_list_item_1,
                                    userNames
                            );
                            userListview.setAdapter(arrayAdapter);

                            // Configura o OnItemClickListener
                            userListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    // Verifica se a posição é válida
                                    if (position >= 0 && position < empresas.size()) {
                                        // Obtém o User clicado
                                        User empresaSelecionada = empresas.get(position);

                                        // Inicia a nova Activity passando os dados necessários
                                        Intent intent = new Intent(MapUser.this, RecycleUser.class);
                                        intent.putExtra("nome", empresaSelecionada.getNome());
                                        intent.putExtra("endereco", empresaSelecionada.getEndereco());
                                        intent.putExtra("celular", empresaSelecionada.getCelular());
                                        intent.putExtra("horario", empresaSelecionada.getHorario());
                                        intent.putExtra("peso", empresaSelecionada.getPeso());
                                        // Adicione mais dados conforme necessário

                                        startActivity(intent);
                                    } else {
                                        Log.e(TAG, "Invalid position: " + position);
                                    }
                                }
                            });

                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });

    }
}