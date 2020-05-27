package com.example.biblioailtech;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;



public class DataBaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Biblioailtech.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Livre";
    private static final String COL_ID = "id";
    private static final String COL_TITRE = "titre";
    private static final String COL_AUTEUR = "auteur";
    private static final String COL_GENRE = "genre";
    private static final String COL_DISPONIBILITE = "disponibilite";

     DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String strSQL = "CREATE TABLE " + TABLE_NAME +
                        " ("+ COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        COL_TITRE + " TEXT, " +
                        COL_AUTEUR + " TEXT, " +
                        COL_GENRE + " TEXT, " +
                        COL_DISPONIBILITE + " TEXT);";
        db.execSQL(strSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void ajoutLivre(String titre, String auteur, String genre, String disponibilite){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_TITRE, titre);
        cv.put(COL_AUTEUR, auteur);
        cv.put(COL_GENRE, genre);
        cv.put(COL_DISPONIBILITE, disponibilite);

        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            Toast.makeText(context, "le livre n'a pas pu être ajouter !", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "le livre a été ajouter !", Toast.LENGTH_SHORT).show();

        }
    }

    Cursor affTousLivres(){

        String strSQL = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;

        if(db != null) {
            cursor = db.rawQuery(strSQL, null);
        }

        return cursor;
    }

    void ModifLivre(String row_id, String titre, String auteur, String genre, String disponibilite){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_TITRE, titre);
        cv.put(COL_AUTEUR, auteur);
        cv.put(COL_GENRE, genre);
        cv.put(COL_DISPONIBILITE, disponibilite);

        long result = db.update(TABLE_NAME, cv, "id=?", new String[] {row_id});

        if(result == -1){

            Toast.makeText(context, "Le livre n'a pas pu être modifier !", Toast.LENGTH_SHORT).show();

        }else{

            Toast.makeText(context, "Le livre a été modifier !", Toast.LENGTH_SHORT).show();

        }

    }

    void SuppIdLivre(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "id=?", new String[] {row_id});

        if(result == -1){
            Toast.makeText(context, "Le livre n'a pas pu être supprimer !", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Le livre a été supprimer !", Toast.LENGTH_SHORT).show();
        }
    }
}
