package com.example.biblioailtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Connexion extends AppCompatActivity {

    EditText editIdentifiant, editMdp;
    Button btnConnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        editIdentifiant = findViewById(R.id.editIdentifiant);
        editMdp = findViewById(R.id.editMdp);
        btnConnexion = findViewById(R.id.btnConnexion);

        btnConnexion.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Valid(editIdentifiant.getText().toString(), editMdp.getText().toString());
                    }
                }
        );
    }

    public void Valid(String Identifiant, String Mdp){
        if (Identifiant.equals("Admin") && Mdp.equals("biblioailtech")){
            Intent intent = new Intent(Connexion.this, AffLivreAdmin.class);

            startActivity(intent);
        }else {
            Toast.makeText(Connexion.this, "L'identifiant ou le mot de passe est incorrect", Toast.LENGTH_SHORT).show();
        }
    }
}
