package com.example.beatthebookies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AdviceSelectionScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advice_selection_screen)
    }

    fun CoinFlipAdvice(view: View){
        val intent = Intent(this, CoinFlipAdviceHome::class.java)
        startActivity(intent)
    }

    fun RouletteAdvice(view: View){
        val intent = Intent(this, RouletteAdvicePage::class.java)
        startActivity(intent)
    }
}