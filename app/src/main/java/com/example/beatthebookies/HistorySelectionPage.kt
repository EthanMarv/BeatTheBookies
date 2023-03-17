package com.example.beatthebookies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HistorySelectionPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_selection_page)
    }

    fun RouletteHistoryPage(view: View){
        val intent = Intent(this, RouletteHistoryPage::class.java)
        startActivity(intent)
    }

    fun CoinFlipHistoryPage(view: View){
        val intent = Intent(this, CoinFlipHistoryPage::class.java)
        startActivity(intent)
    }
}