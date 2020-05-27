package com.example.biblioailtech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.CDATASection;

public class AjoutActivity extends AppCompatActivity {

    EditText editTitre, editAuteur, editGenre, editDisponibilite;
    Button btnInserer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        editTitre = findViewById(R.id.editTitre);
        editAuteur = findViewById(R.id.editAuteur);
        editGenre = findViewById(R.id.editGenre);
        editDisponibilite = findViewById(R.id.editDisponibilite);
        btnInserer = findViewById(R.id.btnInserer);

        btnInserer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBaseHelper mondb = new DataBaseHelper(AjoutActivity.this);
                mondb.ajoutLivre(editTitre.getText().toString().trim(), editAuteur.getText().toString().trim(), editGenre.getText().toString().trim(), editDisponibilite.getText().toString().trim());
            }
        });
    }
}
