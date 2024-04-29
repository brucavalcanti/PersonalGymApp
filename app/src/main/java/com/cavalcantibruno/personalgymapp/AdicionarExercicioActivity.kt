package com.cavalcantibruno.personalgymapp

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.cavalcantibruno.personalgymapp.database.ExercicioDAO
import com.cavalcantibruno.personalgymapp.databinding.ActivityAdicionarExercicioBinding
import com.cavalcantibruno.personalgymapp.model.Exercicio

class AdicionarExercicioActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityAdicionarExercicioBinding.inflate(layoutInflater)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState:Bundle?){
        val nome = intent.getStringExtra("NomeDatabase").toString()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var exercicio:Exercicio? = null
        val bundle = intent.extras
        if(bundle !=null)
        {
            exercicio = bundle.getSerializable("exercicio",Exercicio::class.java)
            var series = exercicio?.qtdSeries.toString()
            var carga = exercicio?.cargaExercicio.toString()
            //Caso venha algum valor inteiro como null, por default ele aparecerá como vazio
            if(series == "null")
            {
                series = ""
            }
            if(carga  == "null")
            {
                carga = ""
            }

            binding.editNome.setText(exercicio?.nomeExercicio)
            binding.editSeries.setText(series)
            binding.editRep.setText(exercicio?.qtdRepeticoes)
            binding.editCarga.setText(carga)
            binding.editObs.setText(exercicio?.obsExercicio)
        }


        binding.addButton.setOnClickListener {
            if(binding.editNome.text.isNotEmpty())
            {

                if(exercicio !=null)
                {
                    editar(exercicio,nome)
                }else {
                    salvar(nome)
                }
            }else
            {
                Toast.makeText(this, "Preencha o nome do exercicio", Toast.LENGTH_SHORT).show()
            }

        }



    }

    private fun editar(exercicio: Exercicio,nome: String) {
        val nomeExercicio = binding.editNome.text.toString()
        var qtdSeries = binding.editSeries.text.toString()
        val qtdRep = binding.editRep.text.toString()
        var carga = binding.editCarga.text.toString()
        val obs = binding.editObs.text.toString()
        if(qtdSeries.isEmpty())
        {
            qtdSeries = "0"
        }
        if(carga.isEmpty())
        {
            carga = "0"
        }
        val exercicioAtualizar = Exercicio(exercicio.idExercicio,nomeExercicio,qtdSeries.toInt(),
            qtdRep,carga.toInt(),obs,"default")
        val exercicioDAO = ExercicioDAO(this)
        if (exercicioDAO.atualizar(exercicioAtualizar,nome)) {
            Toast.makeText(
                this, "Exercício atualizado com sucesso",
                Toast.LENGTH_SHORT
            ).show()
        }
        finish()
    }


    private fun salvar(nome:String) {

        val nomeExercicio = binding.editNome.text.toString()
        var qtdSeries = binding.editSeries.text.toString()
        val qtdRep = binding.editRep.text.toString()
        var carga = binding.editCarga.text.toString()
        val obs = binding.editObs.text.toString()
        if(qtdSeries.isEmpty())
        {
            qtdSeries = "0"
        }
        if(carga.isEmpty())
        {
            carga = "0"
        }
        val exercicio = Exercicio(-1, nomeExercicio,qtdSeries.toInt(),
            qtdRep,carga.toInt(),obs,"default")

        val exercicioDAO = ExercicioDAO(this)

        if (exercicioDAO.salvar(exercicio,nome)) {
            Toast.makeText(
                this, "Tarefa Cadastrada com Sucesso",
                Toast.LENGTH_SHORT
            ).show()
        }
        finish()
    }

}