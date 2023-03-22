package com.example.beatthebookies

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView

class RouletteAdvicePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roulette_advice_page)
    }
    fun one(view: View){
        val text = findViewById<TextView>(R.id.InfoTxtView)
        text.setText("The Martingale strategy is a betting system that involves doubling the bet amount after each loss in an attempt to recover previous losses and make a profit. It is based on the assumption that after a series of losses in a 50/50 game, a win is likely to occur. The strategy suggests starting with an initial bet and doubling the bet amount after each loss until a win occurs, at which point, the bet amount is reset to the initial value. While the strategy may seem sound in theory, it requires a significant amount of capital, may be limited by bookmaker or casino betting limits, and does not guarantee long-term success.\n\n1) Start with an initial bet of a certain amount.\n2)If you win the bet, start again with the same initial bet amount.\n3)If you lose the bet, double your bet amount on the next bet.\n4) Continue to double your bet amount after every loss until you win a bet.\n5) Once you win a bet, go back to the initial bet amount and start again.")
    }

    fun two(view: View){
        val text = findViewById<TextView>(R.id.InfoTxtView)
        text.setText("The D'Alembert strategy is a betting system commonly used in casino games like roulette, where the player bets on even-money bets such as red or black, odd or even, and high or low. This strategy is based on the principle of equilibrium, where it is assumed that over time, the number of wins and losses will balance out.\n\nThe D'Alembert strategy is relatively simple to use. The player starts with a base bet amount and increases it by one unit after each loss, and decreases it by one unit after each win. The idea behind this strategy is that the player is more likely to win after a loss and vice versa.\n\nFor example, let's say a player starts with a base bet of £10. If they lose their first bet, they would increase their bet to £11 for the next spin. If they lose again, they would increase their bet to £12 for the next spin, and so on. If they win a spin, they would decrease their bet by£1 for the next spin.\n\nOne advantage of the D'Alembert strategy is that it is a relatively low-risk strategy that can help players manage their bankroll. However, it's important to note that no betting system can guarantee a win, and players should always gamble responsibly and within their means. Additionally, the effectiveness of the D'Alembert strategy depends on a player's luck and how frequently they win or lose, so it's important to carefully consider the risks before using this strategy.")
    }

    fun three(view: View){
        val text = findViewById<TextView>(R.id.InfoTxtView)
        text.setText("The James Bond strategy is a popular betting strategy used in roulette that is named after the famous fictional spy, James Bond. This strategy is designed to cover as many numbers on the table as possible and requires the player to make three bets on each spin. Here's how it works:\n\n1)Place a bet of£10 on the 0 slot\n2)Place a bet of£50 on the numbers 13-18, which covers a total of six numbers.\nPlace a bet of£140 on the high numbers (19-36), which covers a total of 14 numbers.\n\nThis strategy covers a total of 17 numbers on the table, leaving only 20 numbers uncovered. The player has a chance to win big if the ball lands on one of the covered numbers, and if the ball lands on one of the uncovered numbers, the player will lose all three bets.\n\nIf the ball lands on the 0 slot, the player will win £160 (£350 - £190), which is a profit of £50. If the ball lands on any of the covered numbers (13-18), the player will win £100 (£150 - £50), which is a profit of £40. If the ball lands on any of the high numbers (19-36), the player will win £80 (£220 - £140), which is a profit of £30.\n\nOne advantage of the James Bond strategy is that it allows the player to cover a large portion of the table while still having the potential to win big. However, like all betting strategies, there is still a risk involved.")
    }
}
