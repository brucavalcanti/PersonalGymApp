package com.cavalcantibruno.personalgymapp

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cavalcantibruno.personalgymapp.database.DatabaseHelper
import com.cavalcantibruno.personalgymapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val content = ContentValues()


        content.put(DatabaseHelper.NOME_EXERCICIO,"Supino")
        content.put(DatabaseHelper.SERIES,3)
        content.put(DatabaseHelper.REPETICAO,"12-15")
        content.put(DatabaseHelper.CARGA,16)
        content.put(DatabaseHelper.OBS,"Nenhuma")
        val db = DatabaseHelper(this)
        db.writableDatabase.insert("Segunda",null,content)
        /*content.put(DatabaseHelper.NOME_EXERCICIO,"Supino Inclinado")
        content.put(DatabaseHelper.SERIES,3)
        content.put(DatabaseHelper.REPETICAO,"12-15")
        content.put(DatabaseHelper.CARGA,16)
        content.put(DatabaseHelper.OBS,"Nenhuma")
        val db2 = DatabaseHelper(this)
        db2.writableDatabase.insert("Segunda",null,content)
        content.put(DatabaseHelper.NOME_EXERCICIO,"Crucifixo")
        content.put(DatabaseHelper.SERIES,3)
        content.put(DatabaseHelper.REPETICAO,"10-15")
        content.put(DatabaseHelper.CARGA,16)
        content.put(DatabaseHelper.OBS,"Até a Falha")
        val db3 = DatabaseHelper(this)
        db3.writableDatabase.insert("Segunda",null,content)*/
        /*val a = db.readableDatabase.rawQuery("SELECT ${DatabaseHelper.NOME_EXERCICIO} FROM Segunda",null)
        while(a.moveToNext())
        {

        }
        Log.i(DatabaseHelper.DATABASE, "${a.toString()}")*/

        /*databaseAdapter = DatabaseAdapter()
        binding.rvDatabase.adapter = databaseAdapter
        binding.rvDatabase.layoutManager = LinearLayoutManager(this)*/
        binding.cardView.setOnClickListener {
            val intent = Intent(this,ListaExercicioActivity::class.java)
            intent.putExtra("NomeDatabase",binding.textSegunda.text.toString())
            startActivity(intent)
        }
        binding.cardTerca.setOnClickListener {
            val intent = Intent(this,ListaExercicioActivity::class.java)
            intent.putExtra("NomeDatabase",binding.textTerca.text.toString())
            startActivity(intent)
        }

    }
}