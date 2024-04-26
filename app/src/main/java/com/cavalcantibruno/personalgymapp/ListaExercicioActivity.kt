package com.cavalcantibruno.personalgymapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.cavalcantibruno.personalgymapp.adapter.ExercicioAdapter
import com.cavalcantibruno.personalgymapp.database.ExercicioDAO
import com.cavalcantibruno.personalgymapp.databinding.ActivityListaExercicioBinding
import com.cavalcantibruno.personalgymapp.databinding.ActivityMainBinding
import com.cavalcantibruno.personalgymapp.model.Exercicio

class ListaExercicioActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityListaExercicioBinding.inflate(layoutInflater)
    }

    private var listaExercicio = emptyList<Exercicio>()
    private var exercicioAdapter:ExercicioAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val nome = intent.getStringExtra("NomeDatabase").toString()
        binding.fabAdicionar.setOnClickListener {
            val intent = Intent(this,AdicionarExercicioActivity::class.java)
            startActivity(intent)
        }


        listaExercicio = ExercicioDAO(this).listar(nome)

        listaExercicio.forEach { exercicio->
            Log.i("info_db", "{${exercicio.idExercicio} - ${exercicio.nomeExercicio} - " +
                    "${exercicio.qtdSeries} - ${exercicio.qtdRepeticoes} - " +
                    "${exercicio.cargaExercicio} - ${exercicio.obsExercicio}}\n")
        }

        exercicioAdapter = ExercicioAdapter()
        binding.rvListaExercicio.adapter = exercicioAdapter
        binding.rvListaExercicio.layoutManager = LinearLayoutManager(this)
    }

    private fun atualizarListaExercicio()

    {
        val nome = intent.getStringExtra("NomeDatabase").toString()
        listaExercicio = ExercicioDAO(this).listar(nome)
        //Método que vai ficar recarregando a lista na tela, sem precisar recarregar o recyclerview
        exercicioAdapter?.recarregarLista(listaExercicio)
        /*listaTarefas.forEach { tarefa->
            Log.i("info_db", "{${tarefa.idTarefa} - ${tarefa.descricao} - ${tarefa.dataCadastro}}\n")
        }*/
    }
    override fun onStart()
    {
        super.onStart()
        atualizarListaExercicio()
    }
}