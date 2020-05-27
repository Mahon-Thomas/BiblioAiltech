package com.example.biblioailtech;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ModifActivity extends AppCompatActivity {

    EditText editTitre, editAuteur, editGenre, editDisponibilite;
    Button btnModif, btnSupp;
    String id, titre, auteur, genre, disponibilite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modif);

        editTitre = findViewById(R.id.editTitre2);
        editAuteur = findViewById(R.id.editAuteur2);
        editGenre = findViewById(R.id.editGenre2);
        editDisponibilite = findViewById(R.id.editDisponibilite2);
        btnModif = findViewById(R.id.btnModif);
        btnSupp = findViewById(R.id.btnSupp);




        getAndSetIntentData();
        ActionBar ab = getSupportActionBar();
        if(ab != null) {

            ab.setTitle(titre);
        }


        btnModif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataBaseHelper mondb = new DataBaseHelper(ModifActivity.this);
                mondb.ModifLivre(id, editTitre.getText().toString(), editAuteur.getText().toString(), editGenre.getText().toString(), editDisponibilite.getText().toString());
                finish();
            }
        });

        btnSupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                confirmDialog();
            }
        });



    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("titre") && getIntent().hasExtra("auteur") && getIntent().hasExtra("genre") && getIntent().hasExtra("disponibilite")){
            // On récupère les données à modifier (get)

            id = getIntent().getStringExtra("id");
            titre = getIntent().getStringExtra("titre");
            auteur = getIntent().getStringExtra("auteur");
            genre = getIntent().getStringExtra("genre");
            disponibilite = getIntent().getStringExtra("disponibilite");

            // On modifie les donnée (set)

            editTitre.setText(titre);
            editAuteur.setText(auteur);
            editGenre.setText(genre);
            editDisponibilite.setText(disponibilite);


        }else {

            Toast.makeText(ModifActivity.this, "Pas de donnée..", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(titre);
        builder.setMessage("Voulez vous supprimer vraiment supprimer ce livre ?");
        builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                DataBaseHelper mondb = new DataBaseHelper(ModifActivity.this);
                mondb.SuppIdLivre(id);
                finish();
            }
        });

        builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }

}
