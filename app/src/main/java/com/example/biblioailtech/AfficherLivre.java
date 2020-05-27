package com.example.biblioailtech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class AfficherLivre extends AppCompatActivity {
    RecyclerView recyclerView;
    DataBaseHelper mondb;
    ArrayList<String> livre_id, livre_titre, livre_auteur, livre_genre, livre_disponibilite;
    CustomAdapterUti customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficher_livre);
        recyclerView = findViewById(R.id.recyclerView2);

        mondb = new DataBaseHelper(AfficherLivre.this);

        livre_id = new ArrayList<>();
        livre_titre = new ArrayList<>();
        livre_auteur = new ArrayList<>();
        livre_genre = new ArrayList<>();
        livre_disponibilite = new ArrayList<>();

        DisplayData();
        customAdapter = new CustomAdapterUti(AfficherLivre.this, this, livre_id, livre_titre, livre_auteur, livre_genre, livre_disponibilite);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(AfficherLivre.this));
    }


    void DisplayData(){
        Cursor cursor = mondb.affTousLivres();
        if(cursor.getCount() == 0){
            Toast.makeText(AfficherLivre.this, "Aucune donnée a été trouver !", Toast.LENGTH_LONG).show();
        }else {

            while (cursor.moveToNext()){
                livre_id.add(cursor.getString(0));
                livre_titre.add(cursor.getString(1));
                livre_auteur.add(cursor.getString(2));
                livre_genre.add(cursor.getString(3));
                livre_disponibilite.add(cursor.getString(4));

            }
        }
    }
}
