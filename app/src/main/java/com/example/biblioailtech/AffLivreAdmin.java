package com.example.biblioailtech;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AffLivreAdmin extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton BtnAjout;

    DataBaseHelper mondb;
    ArrayList<String> livre_id, livre_titre, livre_auteur, livre_genre, livre_disponibilite;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aff_livre_admin);

        recyclerView = findViewById(R.id.recyclerView);
        BtnAjout = findViewById(R.id.BtnAjout);

        BtnAjout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(AffLivreAdmin.this, AjoutActivity.class);
                        startActivity(intent);
                    }
                }
        );

        mondb = new DataBaseHelper(AffLivreAdmin.this);

        livre_id = new ArrayList<>();
        livre_titre = new ArrayList<>();
        livre_auteur = new ArrayList<>();
        livre_genre = new ArrayList<>();
        livre_disponibilite = new ArrayList<>();

        DisplayData();
        customAdapter = new CustomAdapter(AffLivreAdmin.this, this, livre_id, livre_titre, livre_auteur, livre_genre, livre_disponibilite);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(AffLivreAdmin.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){

            recreate();

        }
    }

    void DisplayData(){
        Cursor cursor = mondb.affTousLivres();
        if(cursor.getCount() == 0){
            Toast.makeText(AffLivreAdmin.this, "Aucune donnée a été trouver !", Toast.LENGTH_LONG).show();
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
