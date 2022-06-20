package br.com.igti.frases.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.igti.frases.data.Frase
import br.com.igti.frases.databinding.ListItemFrasesBinding

class FrasesAdapter(private val listaDeFrases: List<Frase>) :
    RecyclerView.Adapter<FrasesAdapter.ViewHolder>() {

    private lateinit var binding: ListItemFrasesBinding

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Frase) {
            binding.apply {
                tvAutor.text = item.autor
                tvFrase.text = item.frase
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ListItemFrasesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item = listaDeFrases[position])
    }

    override fun getItemCount(): Int = listaDeFrases.size
}