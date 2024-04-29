package com.cavalcantibruno.personalgymapp.model

import java.io.Serializable

data class Exercicio(
    val idExercicio: Int,
    val nomeExercicio: String,
    val qtdSeries:Int,
    val qtdRepeticoes:String,
    val cargaExercicio: Int,
    val obsExercicio:String,
    val dataCadastro:String
) :Serializable