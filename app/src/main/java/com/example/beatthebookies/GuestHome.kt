package com.example.beatthebookies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class GuestHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_home)
    }

    fun GameModes(view: View){
        val intent = Intent(this, GameModes::class.java)
        startActivity(intent)
    }
}