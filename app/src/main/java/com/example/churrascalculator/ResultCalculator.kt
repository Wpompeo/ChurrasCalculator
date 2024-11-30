package com.example.churrascalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

const val KEY_RESULT_BEER = "ResultCalculator.KEY_BEER"
const val KEY_RESULT_MEAT = "ResultCalculator.kEY_MEAT"
const val KEY_RESULT_DRINKS = "ResultCalculator.KEY_DRINKS"

class ResultCalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_calculator)

        val resultBeer = intent.getFloatExtra(KEY_RESULT_BEER, 0f)
        val resultMeat = intent.getFloatExtra(KEY_RESULT_MEAT, 0f)
        val resultDrinks = intent.getFloatExtra(KEY_RESULT_DRINKS, 0f)

        val meat = findViewById<TextView>(R.id.tv_carne)
        val meatFormat = "%.2f Kg".format(resultMeat)
        meat.text = meatFormat


        val beer = findViewById<TextView>(R.id.tv_cerveja)
        val beerFormat = "%.2f Latas".format(resultBeer)
        beer.text = beerFormat


        val drink = findViewById<TextView>(R.id.tv_refrigerante)
        val drinkFormat = "%.2f Litros".format(resultDrinks)
        drink.text = drinkFormat

        val btnRecall = findViewById<Button>(R.id.btn_recalc)
        btnRecall.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btnFinish = findViewById<Button>(R.id.btn_finish)
        btnFinish.setOnClickListener {
            Snackbar.make(btnFinish, "Finalizando o aplicativo...", Snackbar.LENGTH_SHORT).show()
            btnFinish.postDelayed({
                finishAffinity()
            }, 200)
        }
    }
}