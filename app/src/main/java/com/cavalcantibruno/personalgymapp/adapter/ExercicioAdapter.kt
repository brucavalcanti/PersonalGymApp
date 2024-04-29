package com.cavalcantibruno.personalgymapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cavalcantibruno.personalgymapp.databinding.ItemExercicioBinding
import com.cavalcantibruno.personalgymapp.model.Exercicio

class ExercicioAdapter(
    val onClickExcluir:(Int)-> Unit,
    val onClickEditar:(Exercicio) -> Unit
):RecyclerView.Adapter<ExercicioAdapter.ExercicioViewHolder>() {

    private var listaExercicios:List<Exercicio> = emptyList()

    fun recarregarLista(lista:List<Exercicio>)
    {
        this.listaExercicios = lista
        notifyDataSetChanged()
    }
    inner class ExercicioViewHolder(itemBinding: ItemExercicioBinding)
        :RecyclerView.ViewHolder(itemBinding.root){

            private val binding:ItemExercicioBinding

            init {
                binding = itemBinding
            }

            fun binding(exercicio: Exercicio)
            {
                binding.textNome.text=exercicio.nomeExercicio
                binding.textSeries.text = exercicio.qtdSeries.toString() + "x"
                binding.textRep.text = exercicio.qtdRepeticoes
                binding.textCarga.text=exercicio.cargaExercicio.toString() + "KG"
                binding.textObs.text = exercicio.obsExercicio
                binding.textData.text = exercicio.dataCadastro
                binding.btnExcluir.setOnClickListener {
                    onClickExcluir(exercicio.idExercicio)
                }
                binding.btnEditar.setOnClickListener {
                    onClickEditar(exercicio)
                }
            }
        }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExercicioViewHolder {
        val itemExercicioBinding = ItemExercicioBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return ExercicioViewHolder(itemExercicioBinding)
    }

    override fun getItemCount(): Int {
        return listaExercicios.size
    }

    override fun onBindViewHolder(holder: ExercicioViewHolder, position: Int) {
        val exercicio = listaExercicios[position]
        holder.binding(exercicio)
    }



}