package com.example.beatthebookies

import android.content.Intent
import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.text.set

class CoinFlipGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_flip_game)

        onTap()

    }

    private var HeadStreak : Int = 0
    private var TailStreak : Int = 0
    private var HNextChance : Int = 2
    private var TNextChance : Int = 2

    fun GoToCFHistory(view: View){
        val intent = Intent(this, CoinFlipHistoryPage::class.java)
        startActivity(intent)
    }
    private fun onTap() {

        val context = this
        var db = DataBaseHelper(context)

        val dbHelper = DataBaseHelper(this)
        var balance = dbHelper.getBalance()

        val iv_coin = findViewById<ImageView>(R.id.iv_coin)
        val balanceText = findViewById<TextView>(R.id.balancetxt)

        balanceText.setText("Balance : " + balance)

        iv_coin.setOnClickListener {
            val result = (1..2).random()
            if (result == 1) {


                val context = this
                var db = DataBaseHelper(context)

                val dbHelper = DataBaseHelper(this)
                var balance = dbHelper.getBalance()

                val newHeads = CoinFlipHistory(-1,"Heads")
                val mydatabase = DataBaseHelper(this)
                val result = mydatabase.addCoinFlipResult(newHeads)
                val betamount = findViewById<EditText>(R.id.betAmountInput).text.toString().toInt()

                val headsbox = findViewById<RadioButton>(R.id.HeadsBtn)
                val tailsbox = findViewById<RadioButton>(R.id.TailsBtn)


                HeadStreak = HeadStreak + 1
                TailStreak = 0

                HNextChance = HNextChance * 2
                TNextChance = 2

                val Streak = findViewById<TextView>(R.id.streaktxt)
                Streak.setText("The Coin Has Hit Heads " + Integer.toString(HeadStreak) + " Times in row!")

                val NextChance = findViewById<TextView>(R.id.NextChance)
                NextChance.setText("The chances of it hitting Heads " + (HeadStreak + 1) + " times in a row is 1 in " + Integer.toString(HNextChance))

                if(headsbox.isChecked && betamount > 0 && betamount <= balance){

                    balance = (balance + betamount)
                    val updatebalance = dbHelper.updateBalance(balance)
                    val transferbalance = dbHelper.transferbalancewhereId()

                    val balanceTxt = findViewById<TextView>(R.id.balancetxt)
                    balanceTxt.setText("Balance : " + balance.toString())
                }

                if(tailsbox.isChecked && betamount > 0 && betamount <= balance){

                    balance = (balance - betamount)
                    val updatebalance = dbHelper.updateBalance(balance)
                    val transferbalance = dbHelper.transferbalancewhereId()

                    val balanceTxt = findViewById<TextView>(R.id.balancetxt)
                    balanceTxt.setText("Balance : " + balance.toString())
                }

                if(betamount > balance || betamount < 0){
                    Toast.makeText(this, "Invalid Bet Amount", Toast.LENGTH_SHORT).show()
                }

                flipCoin(R.drawable.heads, "heads")

            } else {

                val context = this
                var db = DataBaseHelper(context)
                val dbHelper = DataBaseHelper(this)
                var balance = dbHelper.getBalance()

                val newTails = CoinFlipHistory(-1,"Tails")
                val mydatabase = DataBaseHelper(this)
                val result = mydatabase.addCoinFlipResult(newTails)
                val betamount = findViewById<EditText>(R.id.betAmountInput).text.toString().toInt()

                val headsbox = findViewById<RadioButton>(R.id.HeadsBtn)
                val tailsbox = findViewById<RadioButton>(R.id.TailsBtn)


                TailStreak = TailStreak + 1
                HeadStreak = 0

                TNextChance = TNextChance * 2
                HNextChance = 2

                val Streak = findViewById<TextView>(R.id.streaktxt)
                Streak.setText("The Coin Has Hit Tails " + Integer.toString(TailStreak) + " Times in row!")

                val NextChance = findViewById<TextView>(R.id.NextChance)
                NextChance.setText("The chances of it hitting Tails " + (TailStreak + 1) + " times in a row is 1 in " + Integer.toString(TNextChance))

                if(headsbox.isChecked && betamount > 0 && betamount <= balance){

                    balance = (balance - betamount)
                    val updatebalance = dbHelper.updateBalance(balance)
                    val transferbalance = dbHelper.transferbalancewhereId()

                    val balanceTxt = findViewById<TextView>(R.id.balancetxt)
                    balanceTxt.setText("Balance : " + balance.toString())
                }

                if(tailsbox.isChecked && betamount > 0 && betamount <= balance){

                    balance = (balance + betamount)
                    val updatebalance = dbHelper.updateBalance(balance)
                    val transferbalance = dbHelper.transferbalancewhereId()

                    val balanceTxt = findViewById<TextView>(R.id.balancetxt)
                    balanceTxt.setText("Balance : " + balance.toString())
                }

                if(betamount > balance || betamount < 0){
                    Toast.makeText(this, "Invalid Bet Amount", Toast.LENGTH_SHORT).show()
                }

                flipCoin(R.drawable.tails, "tails")
            }
        }
    }

    private fun flipCoin(resultImage: Int, resultText: String) {

        val imageView = findViewById<ImageView>(R.id.iv_coin)
        imageView.animate().apply {
            duration = 750
            rotationXBy(900f)
            imageView.isClickable = false
        }.withEndAction{

            imageView.setImageResource(resultImage)
            Toast.makeText(this, resultText, Toast.LENGTH_SHORT).show()
            imageView.isClickable = true
        }
    }

    fun HalfStake(view: View) {
        val editText = findViewById<EditText>(R.id.betAmountInput)

        val currentValue = editText.text.toString().toIntOrNull()

        if (currentValue == null) {

        } else {
            val doubledValue = currentValue / 2
            editText.setText(doubledValue.toString())
        }
    }

    fun DoubleStake(view: View) {
        val editText = findViewById<EditText>(R.id.betAmountInput)

        val currentValue = editText.text.toString().toIntOrNull()

        if (currentValue == null) {
            // Handle invalid input
        } else {
            val doubledValue = currentValue * 2
            editText.setText(doubledValue.toString())
        }
    }

    fun MaxStake(view: View) {

        val context = this
        var db = DataBaseHelper(context)

        val tvResult = findViewById<TextView>(R.id.betAmountInput)

        val dbHelper = DataBaseHelper(this) // Replace "this" with your activity or fragment context
        val balance = dbHelper.getBalance()

        val editText = findViewById<EditText>(R.id.betAmountInput)

        val currentValue = editText.text.toString().toIntOrNull()

        if (currentValue == null) {
            // Handle invalid input
        } else {
            val doubledValue = balance
            editText.setText(doubledValue.toString())
        }
    }

    fun ClearStake(view: View) {
        val editText = findViewById<EditText>(R.id.betAmountInput)

        val currentValue = editText.text.toString().toIntOrNull()

        if (currentValue == null) {
            // Handle invalid input
        } else {
            val doubledValue = 0
            editText.setText(doubledValue.toString())
        }
    }
}