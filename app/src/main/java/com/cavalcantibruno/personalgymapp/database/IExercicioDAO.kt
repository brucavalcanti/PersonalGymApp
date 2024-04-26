package com.cavalcantibruno.personalgymapp.database

import com.cavalcantibruno.personalgymapp.model.Exercicio

interface IExercicioDAO {

    fun salvar(exercicio: Exercicio,dabataseNome:String):Boolean

    fun atualizar(exercicio:Exercicio):Boolean

    fun remover(idTarefa:Int):Boolean

    fun listar(databseNome:String):List<Exercicio>


}