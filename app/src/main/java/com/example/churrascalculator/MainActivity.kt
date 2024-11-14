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
        edtAdults.text?.clear()
        val edtChildren = findViewById<TextInputEditText>(R.id.edt_criancas)
        val edtHours = findViewById<TextInputEditText>(R.id.edt_horas)
        val btnCalculate = findViewById<Button>(R.id.btn_calc)

        btnCalculate.setOnClickListener {
            val adultsStr: String = edtAdults.text.toString()
            val childrenStr: String = edtChildren.text.toString()
            val hoursStr: String = edtHours.text.toString()

            if (adultsStr == "" || childrenStr == "" || hoursStr == "") {
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



                if (hours.toInt() == 1 || hours.toInt() == 2) {
                    val childrenMeat = children * 200 / 1000
                    val adultsMeat = adults * 400 / 1000
                    val meat = childrenMeat + adultsMeat
                    val beerAdults = adults * 4 * hours
                    val refrigeratorChildren = (adults + children) * 400 / 1000

                    val intent = Intent(this, ResultCalculator::class.java)
                    intent.putExtra(KEY_RESULT_BEER, beerAdults)
                    intent.putExtra(KEY_RESULT_MEAT, meat)
                    intent.putExtra(KEY_RESULT_DRINKS, refrigeratorChildren)
                    startActivity(intent)

                } else {
                    val childrenMeat = children * 250 / 1000
                    val adultsMeat = adults * 500 / 1000
                    val meat = childrenMeat + adultsMeat
                    val beerAdults = adults * ( 45 / 10 ) * hours
                    val refrigeratorChildren = (adults + children) * 600 / 1000

                    val intent = Intent(this, ResultCalculator::class.java)
                    intent.putExtra(KEY_RESULT_BEER, beerAdults)
                    intent.putExtra(KEY_RESULT_MEAT, meat)
                    intent.putExtra(KEY_RESULT_DRINKS, refrigeratorChildren)
                    startActivity(intent)
                }
            }
        }
    }
}