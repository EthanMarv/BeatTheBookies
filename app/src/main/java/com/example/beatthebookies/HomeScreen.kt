package com.example.beatthebookies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
    }

    fun GameModes(view: View){
        val intent = Intent(this, GameModes::class.java)
        startActivity(intent)
    }

    fun HistorySelectionPage(view: View){
        val intent = Intent(this, HistorySelectionPage::class.java)
        startActivity(intent)
    }

    fun AdviceSelectionPage(view: View){
        val intent = Intent(this, AdviceSelectionScreen::class.java)
        startActivity(intent)
    }

    fun addfunds(view: View){
        val myDataBase = DataBaseHelper(this)

        val id = myDataBase.getLoggedInId()

        if(id == 999){
        Toast.makeText(this,"Please create an account or Log in to add funds",Toast.LENGTH_LONG).show()

        } else{
            val intent = Intent(this, AddFunds::class.java)
            startActivity(intent)
        }

    }

}