package com.example.beatthebookies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class GameModes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_modes)
    }

    fun CoinFlipBtn(view: View){
        val intent = Intent(this, CoinFlipGame::class.java)
        startActivity(intent)
    }

    fun roulette(view : View){
        val intent = Intent(this, RouletteGame::class.java)
        startActivity(intent)
    }

}