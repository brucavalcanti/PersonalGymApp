package com.cavalcantibruno.personalgymapp.database

import android.content.ContentValues
import android.content.Context
import android.util.Log
import com.cavalcantibruno.personalgymapp.ListaExercicioActivity
import com.cavalcantibruno.personalgymapp.model.Exercicio

class ExercicioDAO(context: Context):IExercicioDAO {

    companion object {
       const val EXERCICIODAO = "ExercicioDAO"
    }
    private val escrita = DatabaseHelper(context).writableDatabase
    private val leitura = DatabaseHelper(context).readableDatabase

    override fun salvar(exercicio: Exercicio,databaseNome:String): Boolean {
        val conteudo = ContentValues()
        conteudo.put("${DatabaseHelper.NOME_EXERCICIO}",exercicio.nomeExercicio)
        conteudo.put("${DatabaseHelper.SERIES}",exercicio.qtdSeries)
        conteudo.put("${DatabaseHelper.REPETICAO}",exercicio.qtdRepeticoes)
        conteudo.put("${DatabaseHelper.CARGA}",exercicio.cargaExercicio)
        conteudo.put("${DatabaseHelper.OBS}",exercicio.obsExercicio)
        try {
            escrita.insert("${databaseNome}",null,conteudo)
            Log.i(EXERCICIODAO, "Sucesso ao salvar excercício ")
        }catch (e:Exception){
            e.printStackTrace()
            Log.i(EXERCICIODAO, "Erro ao salvar exercicio ")
            return false
        }
        return true
    }

    override fun atualizar(exercicio: Exercicio,databaseNome: String): Boolean {
        val args = arrayOf(exercicio.idExercicio.toString())
        val conteudo = ContentValues()
        conteudo.put("${DatabaseHelper.NOME_EXERCICIO}",exercicio.nomeExercicio)
        conteudo.put("${DatabaseHelper.SERIES}",exercicio.qtdSeries)
        conteudo.put("${DatabaseHelper.REPETICAO}",exercicio.qtdRepeticoes)
        conteudo.put("${DatabaseHelper.CARGA}",exercicio.cargaExercicio)
        conteudo.put("${DatabaseHelper.OBS}",exercicio.obsExercicio)
        try {
            escrita.update(databaseNome,
                conteudo,
                "${DatabaseHelper.ID_EXERCICIO}=?",args)
            Log.i(EXERCICIODAO, "TarefaDAO: Sucesso ao atualizar tarefa ")
        }catch (e:Exception)
        {
            e.printStackTrace()
            Log.i(EXERCICIODAO, "TarefaDAO: Erro ao atualizar tarefa ")
            return false
        }
        return true
    }

    override fun remover(idTarefa: Int,nome:String): Boolean {
        val args = arrayOf(idTarefa.toString())
        try {
            escrita.delete(nome,
                "${DatabaseHelper.ID_EXERCICIO}=?",args)
            Log.i(EXERCICIODAO, "ExercicioDAO: Sucesso ao excluir exercicio ")
        }catch (e:Exception)
        {
            e.printStackTrace()
            Log.i(EXERCICIODAO, "ExercicioDAO: Erro ao excluir exercicio ")
            return false
        }
        return true
    }

    override fun listar(databaseNome: String): List<Exercicio> {
        val listaExercicio = mutableListOf<Exercicio>()
        val sql = "SELECT ${DatabaseHelper.ID_EXERCICIO}, ${DatabaseHelper.NOME_EXERCICIO}," +
                "${DatabaseHelper.SERIES},${DatabaseHelper.REPETICAO},${DatabaseHelper.CARGA}," +
                "${DatabaseHelper.OBS}," +
                "strftime('%d/%m/%Y',${DatabaseHelper.DATA_CADASTRO_EXERCICIO}) " +
                "${DatabaseHelper.DATA_CADASTRO_EXERCICIO} " +
                "FROM $databaseNome"
        val cursor = leitura.rawQuery(sql, null)

        val indiceId = cursor.getColumnIndex(DatabaseHelper.ID_EXERCICIO)
        val indiceNomeExercicio = cursor.getColumnIndex(DatabaseHelper.NOME_EXERCICIO)
        val indiceQtdSeries = cursor.getColumnIndex(DatabaseHelper.SERIES)
        val indiceRepeticao = cursor.getColumnIndex(DatabaseHelper.REPETICAO)
        val indiceCarga = cursor.getColumnIndex(DatabaseHelper.CARGA)
        val indiceObs = cursor.getColumnIndex(DatabaseHelper.OBS)
        val indiceData = cursor.getColumnIndex(DatabaseHelper.DATA_CADASTRO_EXERCICIO)

        while (cursor.moveToNext())
        {
            val idExercicio = cursor.getInt(indiceId)
            val nomeExercicio = cursor.getString(indiceNomeExercicio)
            val qtdSeries = cursor.getInt(indiceQtdSeries)
            val qtdRep = cursor.getString(indiceRepeticao)
            val carga = cursor.getInt(indiceCarga)
            val observacao = cursor.getString(indiceObs)
            val dataCadastro = cursor.getString(indiceData)

            listaExercicio.add(
                Exercicio(idExercicio,nomeExercicio,qtdSeries,qtdRep,carga,observacao,dataCadastro)
            )
        }
        return listaExercicio
    }
}