package com.example.beatthebookies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class AddFunds : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_funds)
    }

    fun ReturnHome(view: View){
        val intent = Intent(this, HomeScreen::class.java)
        startActivity(intent)
    }

    fun addFunds(view: View) {

        val context = this
        val mydatabase = DataBaseHelper(this)

        val oldbetamount = findViewById<TextView>(R.id.oldbalancetxt)
        val creditamount = findViewById<EditText>(R.id.CreditInput).text.toString().toInt()

        val dbHelper = DataBaseHelper(this)
        var balance = dbHelper.getBalance()

        if (balance + creditamount <= 10000) {

            balance = (balance + creditamount)

            val updatedbalance = dbHelper.updateBalance(balance)


            oldbetamount.text = ("New Balance :" + balance.toString())

        }else{
         oldbetamount.text = "Balanace cannot exceed 10,000 credits"
        }
    }

    fun viewbalanace(view: View){

        val currentbalance = findViewById<TextView>(R.id.oldbalancetxt)

        val context = this
        var db = DataBaseHelper(context)
        val dbHelper = DataBaseHelper(this)
        val balance = dbHelper.getBalance()

        currentbalance.setText("Balance : " + balance.toString())

    }
}