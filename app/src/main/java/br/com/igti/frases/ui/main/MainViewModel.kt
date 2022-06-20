package br.com.igti.frases.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.igti.frases.data.Frase
import br.com.igti.frases.data.repository.MemoryRepository

class MainViewModel: ViewModel() {
    private var memoryRepository: MemoryRepository = MemoryRepository(mutableListOf())
    private val _listaDeFrases = MutableLiveData<List<Frase>>()

    val listaDeFrases: LiveData<List<Frase>> = _listaDeFrases

    fun inciarDados() {
        _listaDeFrases.value = memoryRepository.exibirLista()
    }

    fun salvarFrase(frase: Frase) {
        Log.i("igtiInfo", "Frase recebida: $frase")

        memoryRepository.salvar(frase)
        atulaizarListaFrases()
    }

    fun limparListaDeFrases() {
        Log.i("igtiInfo", "inicia porcesso de limpeza do repo.")
        memoryRepository.limparLista()
        atulaizarListaFrases()
    }

    private fun atulaizarListaFrases() {
       _listaDeFrases.value = memoryRepository.exibirLista()
    }
}