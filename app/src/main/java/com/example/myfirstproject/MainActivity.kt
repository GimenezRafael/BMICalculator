package com.example.myfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtPeso : EditText = findViewById(R.id.edittext_peso)
        val edtaltura : EditText = findViewById(R.id.edittext_altura)

        btnCalcular.setOnClickListener() {

            val alturaStr = edtaltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()){
            val altura : Float = alturaStr.toFloat()
            val peso : Float = pesoStr.toFloat()

            val alturaFinal : Float = altura * altura
            val result : Float = peso / alturaFinal

            // esse codigo é uma intente explicita, onde explicitamente eu diezendo que eu quero sair daqui (this) para a minha proxima tela que é a ResultActivity
            // aqui vai abrir uma nova tela no app
            val intent = Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra("EXTRA_RESULT", result)
                }
            startActivity(intent)
            }else{
                Toast.makeText(this,"You need to fill in all the fields.", Toast.LENGTH_LONG).show()
            }
        }
    }
}