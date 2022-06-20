package br.com.igti.frases.ui.incluirfrase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import br.com.igti.frases.R
import br.com.igti.frases.data.Frase
import br.com.igti.frases.databinding.ActivityIncluirFraseBinding
import br.com.igti.frases.ui.main.MainActivity

class IncluirFraseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIncluirFraseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIncluirFraseBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        configurarListeners()
    }

    private fun configurarListeners() {
        configurarListenerBtnSalvar()
        configurarListenerBtnCancelar()
    }

    private fun configurarListenerBtnSalvar() {
        binding.btnSalvar.setOnClickListener {
            salvarFrase()
        }
    }

    private fun salvarFrase() {

        binding.apply {
            val autor = autoresFraseED.text.toString()
            val frase = frasesET.text.toString()

            autoresFraseTIL.error = if (autor.isEmpty()) {
                getString(R.string.err_sem_autor)
            } else {
                null
            }

            fraseTIL.error = if (frase.isEmpty()) {
                getString(R.string.err_sem_frase)
            } else {
                null
            }

            if (autor.isNotEmpty() && frase.isNotEmpty()) {
//                Toast.makeText(
//                    applicationContext,
//                    "Autor $autor Frase $frase",
//                    Toast.LENGTH_LONG
//                ).show()
//                finish()
                Log.i("igtiInfo", "Autor: $autor, Frase: $frase")
                Intent().apply {
                    putExtra(MainActivity.RETORNO, Frase(
                        autor = autor,
                        frase = frase
                    ))
                    setResult(RESULT_OK, this)
                }
                finish()
            } else {
                Log.i("igtiInfo", "dados não salvos")
            }

        }
    }

    private fun configurarListenerBtnCancelar() {
        binding.btnCancelar.setOnClickListener { finish() }
    }
}