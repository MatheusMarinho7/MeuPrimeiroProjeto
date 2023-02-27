package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)
        val Result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = Result.toString()

        /*  MENOR QUE 18,5    ABAIXO DO PESO
          ENTRE 18,5 E 24,9	NORMAL
          ENTRE 25 E 29,9	Obesidade I
          ENTRE 30 e 39,99	Obesidade II (severa)
          MAIOR QUE 40	Obesidade grave III  */

        var classificacao = ""
        if (Result < 18.5f) {
            classificacao = "ABAIXO DO PESO"
        } else if (Result >= 18.5f && Result <= 24.9f) {
            classificacao = "NORMAL"
        } else if (Result >= 25f && Result <= 29.9f) {
            classificacao = "SOBREPESO"
        } else if (Result >= 30f && Result <= 39.9f) {
            classificacao = "OBOSIDADE"
        } else {
            classificacao = "OBESIDADE GRAVE"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

        }

         override fun onOptionsItemSelected(item: MenuItem): Boolean {
            finish()
             return super.onOptionsItemSelected(item)

        }
    }
