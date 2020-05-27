package com.example.biblioailtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button buttonVueCLient, buttonConnexion;
    ImageView Charte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonVueCLient = findViewById(R.id.buttonVueCLient);
        buttonConnexion = findViewById(R.id.buttonConnexion);
        Charte = findViewById(R.id.Charte);


        buttonVueCLient.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, AfficherLivre.class);

                        startActivity(intent);
                    }
                }
        );

        buttonConnexion.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Connexion.class);

                        startActivity(intent);
                    }
                }
        );

        Charte.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, Charte.class);

                        startActivity(intent);
                    }
                }
        );

    }



}
