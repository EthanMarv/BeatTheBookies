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

        val dbHelper = DataBaseHelper(this) // Replace "this" with your activity or fragment context
        val balanceList = dbHelper.getBalance()

        tvResult.text = balanceList.toString()
    }

    fun double(view: View) {

        val context = this
        val mydatabase = DataBaseHelper(this)

        val tvResult = findViewById<TextView>(R.id.textView3)

        val dbHelper = DataBaseHelper(this) // Replace "this" with your activity or fragment context
        var balanceList = dbHelper.getBalance()

        balanceList = balanceList - 1999

        val updatedatabase = mydatabase.updateBalance(balanceList)

        tvResult.text = balanceList.toString()

    }
}
