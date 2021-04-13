package com.example.vgxchange.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.vgxchange.api.dto.Game;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBaseManager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Game.db";
    private static final int DATABASE_VERSION = 2;

    public DataBaseManager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //méthode de création de la table game
    @Override
    public void onCreate(SQLiteDatabase db) {
        String strCreate = "CREATE TABLE game ("
                +"id_game INTEGER primary key autoincrement,"
                +"name text not null,"
                +"price INTEGER not null,"
                +"date_ text not null"
                +")";
        db.execSQL( strCreate );
        Log.i("DATABASE", "onCreate");
    }

    //méthode de mise à jour de la table si oldVersion n'est pas égal à newVersion alors un onUpgrade est utilisé
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String strSql = "drop table game";
        db.execSQL(strSql);
        this.onCreate(db);
        Log.i("DATABASE","onUpgarde");
    }

    //méthode à remplacer un get de l'api
    public void insertGame (String name, int price ){
        name = name.replace("'","''");
        String strSql = "insert into game (name, price, date_) values ('"
                + name + "'," + price +","+new Date().getTime() + ")";
        this.getWritableDatabase().execSQL(strSql);
        Log.i("DATABASE", "insertGame");
    }

    //li toutes la base de donnée Games
    public List<Game> readGames(){
        List<Game> games = new ArrayList<>();

        //recup toutes les colonnes de la table
        String strSql = "select * from game";
        Cursor cursor = this.getReadableDatabase().rawQuery(strSql, null);
        cursor.moveToFirst();

        while (! cursor.isAfterLast()){
            Game game = new Game(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getInt(3));
            games.add(game);
            cursor.moveToNext();
        }
        cursor.close();

        return games;


    }
}
