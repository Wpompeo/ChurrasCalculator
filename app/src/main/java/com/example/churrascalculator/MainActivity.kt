package com.example.churrascalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtAdults = findViewById<TextInputEditText>(R.id.edt_adultos)
        val edtChildren = findViewById<TextInputEditText>(R.id.edt_criancas)
        val edtHours = findViewById<TextInputEditText>(R.id.edt_horas)
        val btnCalculate = findViewById<Button>(R.id.btn_calc)

        btnCalculate.setOnClickListener {
            val adultsStr: String = edtAdults.text.toString()
            val childrenStr: String = edtChildren.text.toString()
            val hoursStr: String = edtHours.text.toString()

            if( adultsStr == "" || childrenStr == "" || hoursStr == ""  ){
                Snackbar.make(
                    edtAdults,
                    "Preencha todos os campos!",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else {

                val adults = adultsStr.toFloat()
                val children = childrenStr.toFloat()
                val hours = hoursStr.toFloat()

                val childrenMeat = children * 0.100
                val adultsMeat = adults * 0.300
                val beerAdults = adults * 4 * hours
                val refrigeratorChildren = (adults + children) * 0.400

                val intent = Intent(this, ResultCalculator::class.java)
                startActivity(intent)
            }


        }
    }
}