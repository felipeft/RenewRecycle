package com.example.renewrecycle_projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RecycleUser extends AppCompatActivity {

    Button Reciclar;
    private TextView Voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reciclagem_user);

        Reciclar = findViewById(R.id.btnRecycle);
        Voltar = findViewById(R.id.btnVoltar);

        Reciclar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(RecycleUser.this, MAPA.class));
            }
        });
    }

    private void showDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.modal_recycle);

        EditText kg = dialog.findViewById(R.id.kg);
        Button ok = dialog.findViewById(R.id.btnOK);
        TextView voltar = dialog.findViewById(R.id.btnVoltar);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Atualizar pontuação
                Toast.makeText(getApplicationContext(), "Pontos adicionados", Toast.LENGTH_SHORT).show();
            }
        });

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT) );
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}