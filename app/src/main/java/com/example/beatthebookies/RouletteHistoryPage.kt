package com.example.beatthebookies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class RouletteHistoryPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roulette_history_page)
    }

    fun update(view: View) {

        val context = this
        var db = DataBaseHelper(context)

        val btn_update = findViewById<Button>(R.id.btn_update)
        val tvResult = findViewById<TextView>(R.id.tvResult)


        var data = db.getRouletteResults()

        tvResult.text = ""

        for (i in 0..(data.size-1)){
            tvResult.append(data.get(i).Id.toString() + "                           " + data.get(i).Result + "                   " + data.get(i).Colour +  "\n")

        }
    }
}