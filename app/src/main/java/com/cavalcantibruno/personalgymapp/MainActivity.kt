package com.cavalcantibruno.personalgymapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.cavalcantibruno.personalgymapp.database.DatabaseHelper

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val content = ContentValues()

        content.put(DatabaseHelper.NOME_EXERCICIO,"Supino")
        content.put(DatabaseHelper.SERIES,3)
        content.put(DatabaseHelper.REPETICAO,"12-15")
        content.put(DatabaseHelper.CARGA,16)
        content.put(DatabaseHelper.OBS,"Nenhuma")
        val db = DatabaseHelper(this)
        db.writableDatabase.insert("Segunda",null,content)
        val a = db.readableDatabase.rawQuery("SELECT ${DatabaseHelper.NOME_EXERCICIO} FROM Segunda",null)
        while(a.moveToNext())
        {

        }
        Log.i(DatabaseHelper.DATABASE, "${a.toString()}")


    }
}