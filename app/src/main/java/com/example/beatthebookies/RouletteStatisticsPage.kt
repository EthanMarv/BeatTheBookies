package com.example.beatthebookies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class RouletteStatisticsPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roulette_statistics_page)
    }

    fun update(view: View) {

        val db = DataBaseHelper(this)
        val streaks = db.getStreaksById(1)
        val textView = findViewById<TextView>(R.id.DisplayTextView)
        textView.text = "Streaks:" + streaks

        }
    }
