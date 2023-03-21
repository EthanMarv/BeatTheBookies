package com.example.beatthebookies

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class CoinFlipAdviceHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_flip_advice_home)
    }

    fun martingale(view: View){
        val text = findViewById<TextView>(R.id.InfoTxtView)
        text.setText("The Martingale strategy is a betting system that involves doubling the bet amount after each loss in an attempt to recover previous losses and make a profit. It is based on the assumption that after a series of losses in a 50/50 game, a win is likely to occur. The strategy suggests starting with an initial bet and doubling the bet amount after each loss until a win occurs, at which point, the bet amount is reset to the initial value. While the strategy may seem sound in theory, it requires a significant amount of capital, may be limited by bookmaker or casino betting limits, and does not guarantee long-term success.\n\n\n\n1) Start with an initial bet of a certain amount.\n2)If you win the bet, start again with the same initial bet amount.\n3)If you lose the bet, double your bet amount on the next bet.\n4) Continue to double your bet amount after every loss until you win a bet.\n5) Once you win a bet, go back to the initial bet amount and start again.")
    }

    fun matchedbetting(view: View){
        val text = findViewById<TextView>(R.id.InfoTxtView)
        text.setText("Matched betting is a betting strategy that can be used to make a profit from free bets and other promotions offered by bookmakers. Although matched betting is typically used in sports betting, it can also be applied to coin flips with a slight variation. \n\nThe idea is to use a free bet or promotion to place a bet on one side of the coin flip and then use your own money to place a bet on the other side of the flip with another bookmaker. By placing opposite bets on both sides of the coin flip, you can guarantee a profit regardless of the outcome of the flip. Although the profit may be small, matched betting is a low-risk betting strategy that can be used to make consistent profits over time. \n\nHowever, it's important to note that matched betting requires careful research and planning to ensure that you are not violating any terms and conditions of the bookmakers and that it may not be applicable in all locations or legal in all jurisdictions.")
    }

    fun FlipAnalysis(view: View){
        val textView = findViewById<TextView>(R.id.InfoTxtView)

        val text = "THIS METHOD CAN ONLY BE APPLIED TO COINFLIP GAMES PLAYED IN PERSON AND NOT IN ONLINE CASINOSTHIS METHOD CAN ONLY BE APPLIED TO COINFLIP GAMES PLAYED IN PERSON AND NOT IN ONLINE CASINOS\n\n\n\nStudy your opponent's behavior to determine if they have any biases or tendencies that could affect their coin flip. However, this method requires observation skills and psychological knowledge."
        val spannableString = SpannableString(text)
        val colorSpan = ForegroundColorSpan(Color.RED)
        spannableString.setSpan(colorSpan, 0, 184, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        textView.setText(spannableString)
    }
}