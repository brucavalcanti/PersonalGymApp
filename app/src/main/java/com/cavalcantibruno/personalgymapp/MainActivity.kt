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
        binding.cardQuarta.setOnClickListener {
            val intent = Intent(this,ListaExercicioActivity::class.java)
            intent.putExtra("NomeDatabase",binding.textQuarta.text.toString())
            startActivity(intent)
        }
        binding.cardQuinta.setOnClickListener {
            val intent = Intent(this,ListaExercicioActivity::class.java)
            intent.putExtra("NomeDatabase",binding.textQuinta.text.toString())
            startActivity(intent)
        }
        binding.cardSexta.setOnClickListener {
            val intent = Intent(this,ListaExercicioActivity::class.java)
            intent.putExtra("NomeDatabase",binding.textSexta.text.toString())
            startActivity(intent)
        }
        binding.cardSab.setOnClickListener {
            val intent = Intent(this,ListaExercicioActivity::class.java)
            intent.putExtra("NomeDatabase",binding.textSab.text.toString())
            startActivity(intent)
        }
        binding.cardDom.setOnClickListener {
            val intent = Intent(this,ListaExercicioActivity::class.java)
            intent.putExtra("NomeDatabase",binding.textDom.text.toString())
            startActivity(intent)
        }

    }
}