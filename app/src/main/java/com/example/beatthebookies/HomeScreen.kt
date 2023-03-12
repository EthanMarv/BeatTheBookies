package com.example.beatthebookies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
    }

    fun GameModes(view: View){
        val intent = Intent(this, GameModes::class.java)
        startActivity(intent)
    }
}