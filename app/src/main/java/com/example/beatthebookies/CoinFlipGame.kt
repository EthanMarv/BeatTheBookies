package com.example.beatthebookies

import android.content.Intent
import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast

class CoinFlipGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_flip_game)

        onTap()
    }

    private var balancE : Int = 2000

    private var HeadStreak : Int = 0
    private var TailStreak : Int = 0
    private var HNextChance : Int = 2
    private var TNextChance : Int = 2

    val headbox = findViewById<RadioButton>(R.id.HeadsBtn)
    val tailbox = findViewById<RadioButton>(R.id.TailsBtn)

    fun GoToCFHistory(view: View){
        val intent = Intent(this, CoinFlipHistoryPage::class.java)
        startActivity(intent)
    }

    private fun onTap() {

        val iv_coin = findViewById<ImageView>(R.id.iv_coin)


        iv_coin.setOnClickListener {
            val result = (1..2).random()  // try && IF HEADS.ischecked()
            if (result == 1) {

                val newHeads = CoinFlipHistory(-1,"Heads")
                val mydatabase = DataBaseHelper(this)
                val result = mydatabase.addCoinFlipResult(newHeads)

                HeadStreak = HeadStreak + 1
                TailStreak = 0

                HNextChance = HNextChance * 2
                TNextChance = 2

                val Streak = findViewById<TextView>(R.id.streaktxt)
                Streak.setText("The Coin Has Hit Heads " + Integer.toString(HeadStreak) + " Times in row!")

                val NextChance = findViewById<TextView>(R.id.NextChance)
                NextChance.setText("The chances of it hitting Heads " + (HeadStreak + 1) + " times in a row is 1 in " + Integer.toString(HNextChance))

                val balanceTxt = findViewById<TextView>(R.id.balancetxt)
                balanceTxt.setText("Balance : " + Integer.toString(balancE))


                flipCoin(R.drawable.heads, "heads")

            } else {

                val newTails = CoinFlipHistory(-1,"Tails")
                val mydatabase = DataBaseHelper(this)
                val result = mydatabase.addCoinFlipResult(newTails)

                TailStreak = TailStreak + 1
                HeadStreak = 0

                TNextChance = TNextChance * 2
                HNextChance = 2

                val Streak = findViewById<TextView>(R.id.streaktxt)
                Streak.setText("The Coin Has Hit Tails " + Integer.toString(TailStreak) + " Times in row!")

                val NextChance = findViewById<TextView>(R.id.NextChance)
                NextChance.setText("The chances of it hitting Tails " + (TailStreak + 1) + " times in a row is 1 in " + Integer.toString(TNextChance))

                val balanceTxt = findViewById<TextView>(R.id.balancetxt)

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
}
