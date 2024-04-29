package com.cavalcantibruno.personalgymapp.database

import com.cavalcantibruno.personalgymapp.model.Exercicio

interface IExercicioDAO {

    fun salvar(exercicio: Exercicio,databaseNome:String):Boolean

    fun atualizar(exercicio:Exercicio,databaseNome:String):Boolean

    fun remover(idTarefa:Int,nome:String):Boolean

    fun listar(databseNome:String):List<Exercicio>


}