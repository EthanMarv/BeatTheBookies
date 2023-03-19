package com.example.beatthebookies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class Balancetest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_balancetest)
    }

    fun update(view: View) {

        val context = this
        var db = DataBaseHelper(context)

        val tvResult = findViewById<TextView>(R.id.textView3)

        val dbHelper = DataBaseHelper(this)
        val balanceList = dbHelper.getBalance()

        tvResult.text = balanceList.toString()
    }

    fun double(view: View) {

        val context = this
        val mydatabase = DataBaseHelper(this)

        val tvResult = findViewById<TextView>(R.id.textView3)

        val dbHelper = DataBaseHelper(this)
        var balanceList = dbHelper.getBalance()

        balanceList += 2

        val updatedbal = mydatabase.updateBalance(balanceList)

        tvResult.text = balanceList.toString()



    }
}
