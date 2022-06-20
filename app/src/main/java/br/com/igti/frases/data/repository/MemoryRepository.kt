package br.com.igti.frases.data.repository

import br.com.igti.frases.data.Frase

class MemoryRepository(novaLista: MutableList<Frase>) {
    private val listDb: MutableList<Frase> = novaLista

    fun salvar(frase: Frase) {
        listDb.add(frase)
    }

    fun limparLista() {
        listDb.clear()
    }

    fun exibirLista() = listDb.toList()
}