package com.cavalcantibruno.personalgymapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context: Context):SQLiteOpenHelper(context,NOME_BD,null,VERSAO) {

    companion object{
        const val VERSAO = 1
        const val NOME_EXERCICIO = "nomeExercicio"
        const val ID_EXERCICIO = "idExercicio"
        const val SERIES ="qtdSerie"
        const val REPETICAO = "qtdRep"
        const val CARGA ="carga"
        const val OBS = "observacao"
        const val DATABASE = "DatabaseHelper"
        const val NOME_BD ="PersonalGymApp.db"
    }


        val nomeTabelas = arrayOf("Segunda","Terca","Quarta","Quinta","Sexta")

    override fun onCreate(db: SQLiteDatabase?) {
        //Tabela para segunda

        Log.i(DATABASE, "onCreate: Cheguei aqui ")
       for(i in nomeTabelas.indices) {
           Log.i(DATABASE, "onCreate: Cheguei aqui ")
           val sql = "CREATE TABLE IF NOT EXISTS ${nomeTabelas[i]} (" +
                   "$ID_EXERCICIO INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                   "$NOME_EXERCICIO VARCHAR(70)," +
                   "$SERIES TINYINT," +
                   "$REPETICAO VARCHAR(10)," +
                   "$CARGA TINYINT," +
                   "$OBS VARCHAR(70));"
           try {
               db?.execSQL(sql)
               Log.i(DATABASE, "onCreate: Sucesso ao Criar a tabela ${nomeTabelas[i]} ")
           } catch (e: Exception) {
               e.printStackTrace()
               Log.i(DATABASE, "onCreate: Erro ao Criar as tabelas ")
           }
       }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //teste
    }
}