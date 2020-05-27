package com.example.biblioailtech;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapterUti extends RecyclerView.Adapter<CustomAdapterUti.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList livre_id, livre_titre, livre_auteur, livre_genre, livre_disponibilite;

    CustomAdapterUti(Activity activity, Context context, ArrayList livre_id, ArrayList livre_titre, ArrayList livre_auteur, ArrayList livre_genre, ArrayList livre_disponibilite){

        this.activity = activity;
        this.context = context;
        this.livre_id = livre_id;
        this.livre_titre = livre_titre;
        this.livre_auteur = livre_auteur;
        this.livre_genre = livre_genre;
        this.livre_disponibilite = livre_disponibilite;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.textId.setText(String.valueOf(livre_id.get(position)));
        holder.textTitre.setText(String.valueOf(livre_titre.get(position)));
        holder.textAuteur.setText(String.valueOf(livre_auteur.get(position)));
        holder.textGenre.setText(String.valueOf(livre_genre.get(position)));
        holder.textDisponibilite.setText(String.valueOf(livre_disponibilite.get(position)));

    }

    @Override
    public int getItemCount() {
        return livre_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textId, textTitre, textAuteur, textGenre, textDisponibilite;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textId = itemView.findViewById(R.id.textId);
            textTitre = itemView.findViewById(R.id.textTitre);
            textAuteur = itemView.findViewById(R.id.textAuteur);
            textGenre = itemView.findViewById(R.id.textGenre);
            textDisponibilite = itemView.findViewById(R.id.textDisponibilite);


        }
    }
}
