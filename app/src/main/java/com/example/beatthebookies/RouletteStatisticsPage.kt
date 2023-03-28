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

        val mydatabase = DataBaseHelper(this)

        var ZeroStreak = mydatabase.getStreaksById(37)
        var OneStreak = mydatabase.getStreaksById(1)
        var TwoStreak = mydatabase.getStreaksById(2)
        var ThreeStreak = mydatabase.getStreaksById(3)
        var FourStreak = mydatabase.getStreaksById(4)
        var FiveStreak = mydatabase.getStreaksById(5)
        var SixStreak = mydatabase.getStreaksById(6)
        var SevenStreak = mydatabase.getStreaksById(7)
        var EightStreak = mydatabase.getStreaksById(8)
        var NineStreak = mydatabase.getStreaksById(9)
        var TenStreak = mydatabase.getStreaksById(10)
        var ElevenStreak = mydatabase.getStreaksById(11)
        var TwelveStreak = mydatabase.getStreaksById(12)
        var ThirteenStreak = mydatabase.getStreaksById(13)
        var FourteenStreak = mydatabase.getStreaksById(14)
        var FifteenStreak = mydatabase.getStreaksById(15)
        var SixteenStreak = mydatabase.getStreaksById(16)
        var SeventeenStreak = mydatabase.getStreaksById(17)
        var EighteenStreak = mydatabase.getStreaksById(18)
        var NineteenStreak = mydatabase.getStreaksById(19)
        var TwentyStreak = mydatabase.getStreaksById(20)
        var TwentyOneStreak = mydatabase.getStreaksById(21)
        var TwentyTwoStreak = mydatabase.getStreaksById(22)
        var TwentyThreeStreak = mydatabase.getStreaksById(23)
        var TwentyFourStreak = mydatabase.getStreaksById(24)
        var TwentyFiveStreak = mydatabase.getStreaksById(25)
        var TwentySixStreak = mydatabase.getStreaksById(26)
        var TwentySevenStreak = mydatabase.getStreaksById(27)
        var TwentyEightStreak = mydatabase.getStreaksById(28)
        var TwentyNineStreak = mydatabase.getStreaksById(29)
        var ThirtyStreak = mydatabase.getStreaksById(30)
        var ThirtyOneStreak = mydatabase.getStreaksById(31)
        var ThirtyTwoStreak = mydatabase.getStreaksById(32)
        var ThirtyThreeStreak = mydatabase.getStreaksById(33)
        var ThirtyFourStreak = mydatabase.getStreaksById(34)
        var ThirtyFiveStreak = mydatabase.getStreaksById(35)
        var ThirtySixStreak = mydatabase.getStreaksById(36)
        var a1To12Streak = mydatabase.getStreaksById(38)
        var a13To24Streak = mydatabase.getStreaksById(39)
        var a25To36Steak = mydatabase.getStreaksById(40)
        var TopRowStreak = mydatabase.getStreaksById(41)
        var MiddleRowStreak = mydatabase.getStreaksById(42)
        var BottomRowStreak = mydatabase.getStreaksById(43)
        var a1To18Streak = mydatabase.getStreaksById(44)
        var EvenStreak = mydatabase.getStreaksById(45)
        var RedStreak = mydatabase.getStreaksById(46)
        var BlackStreak = mydatabase.getStreaksById(47)
        var oddStreak = mydatabase.getStreaksById(48)
        var a19To36Streak = mydatabase.getStreaksById(49)



        var a0chance = if (ZeroStreak > 0) Math.pow(37.0, ZeroStreak.toDouble() + 1).toInt() else 37
        var a1chance = if (OneStreak > 0) Math.pow(37.0, OneStreak.toDouble() + 1).toInt() else 37
        var a2chance = if (TwoStreak > 0) Math.pow(37.0, TwoStreak.toDouble() + 1).toInt() else 37
        var a3chance = if (ThreeStreak > 0) Math.pow(37.0, ThreeStreak.toDouble() + 1).toInt() else 37
        var a4chance = if (FourStreak > 0) Math.pow(37.0, FourStreak.toDouble() + 1).toInt() else 37
        var a5chance = if (FiveStreak > 0) Math.pow(37.0, FiveStreak.toDouble() + 1).toInt() else 37
        var a6chance = if (SixStreak > 0) Math.pow(37.0, SixStreak.toDouble() + 1).toInt() else 37
        var a7chance = if (SevenStreak > 0) Math.pow(37.0, SevenStreak.toDouble() + 1).toInt() else 37
        var a8chance = if (EightStreak > 0) Math.pow(37.0, EightStreak.toDouble() + 1).toInt() else 37
        var a9chance = if (NineStreak > 0) Math.pow(37.0, NineStreak.toDouble() + 1).toInt() else 37
        var a10chance = if (TenStreak > 0) Math.pow(37.0, TenStreak.toDouble() + 1).toInt() else 37
        var a11chance = if (ElevenStreak > 0) Math.pow(37.0, ElevenStreak.toDouble() + 1).toInt() else 37
        var a12chance = if (TwelveStreak > 0) Math.pow(37.0, TwelveStreak.toDouble() + 1).toInt() else 37
        var a13chance = if (ThirteenStreak > 0) Math.pow(37.0, ThirteenStreak.toDouble() + 1).toInt() else 37
        var a14chance = if (FourteenStreak > 0) Math.pow(37.0, FourteenStreak.toDouble() + 1).toInt() else 37
        var a15chance = if (FifteenStreak > 0) Math.pow(37.0, FifteenStreak.toDouble() + 1).toInt() else 37
        var a16chance = if (SixteenStreak > 0) Math.pow(37.0, SixteenStreak.toDouble() + 1).toInt() else 37
        var a17chance = if (SeventeenStreak > 0) Math.pow(37.0, SeventeenStreak.toDouble() + 1).toInt() else 37
        var a18chance = if (EighteenStreak > 0) Math.pow(37.0, EighteenStreak.toDouble() + 1).toInt() else 37
        var a19chance = if (NineteenStreak > 0) Math.pow(37.0, NineteenStreak.toDouble() + 1).toInt() else 37
        var a20chance = if (TwentyStreak > 0) Math.pow(37.0, TwentyStreak.toDouble() + 1).toInt() else 37
        var a21chance = if (TwentyOneStreak > 0) Math.pow(37.0, TwentyOneStreak.toDouble() + 1).toInt() else 37
        var a22chance = if (TwentyTwoStreak > 0) Math.pow(37.0, TwentyTwoStreak.toDouble() + 1).toInt() else 37
        var a23chance = if (TwentyThreeStreak > 0) Math.pow(37.0, TwentyThreeStreak.toDouble() + 1).toInt() else 37
        var a24chance = if (TwentyFourStreak > 0) Math.pow(37.0, TwentyFourStreak.toDouble() + 1).toInt() else 37
        var a25chance = if (TwentyFiveStreak > 0) Math.pow(37.0, TwentyFiveStreak.toDouble() + 1).toInt() else 37
        var a26chance = if (TwentySixStreak > 0) Math.pow(37.0, TwentySixStreak.toDouble() + 1).toInt() else 37
        var a27chance = if (TwentySevenStreak > 0) Math.pow(37.0, TwentySevenStreak.toDouble() + 1).toInt() else 37
        var a28chance = if (TwentyEightStreak > 0) Math.pow(37.0, TwentyEightStreak.toDouble() + 1).toInt() else 37
        var a29chance = if (TwentyNineStreak > 0) Math.pow(37.0, TwentyNineStreak.toDouble() + 1).toInt() else 37
        var a30chance = if (ThirtyStreak > 0) Math.pow(37.0, ThirtyStreak.toDouble() + 1).toInt() else 37
        var a31chance = if (ThirtyOneStreak > 0) Math.pow(37.0, ThirtyOneStreak.toDouble() + 1).toInt() else 37
        var a32chance = if (ThirtyTwoStreak > 0) Math.pow(37.0, ThirtyTwoStreak.toDouble() + 1).toInt() else 37
        var a33chance = if (ThirtyThreeStreak > 0) Math.pow(37.0, ThirtyThreeStreak.toDouble() + 1).toInt() else 37
        var a34chance = if (ThirtyFourStreak > 0) Math.pow(37.0, ThirtyFourStreak.toDouble() + 1).toInt() else 37
        var a35chance = if (ThirtyFiveStreak > 0) Math.pow(37.0, ThirtyFiveStreak.toDouble() + 1).toInt() else 37
        var a36chance = if (ThirtySixStreak > 0) Math.pow(37.0, ThirtySixStreak.toDouble() + 1).toInt() else 37




        var evenchance = if (EvenStreak > 0) Math.pow(2.0, EvenStreak.toDouble() + 1).toInt() else 2
        var oddchance = if (oddStreak > 0) Math.pow(2.0, oddStreak.toDouble() + 1).toInt() else 2
        var redchance = if (RedStreak > 0) Math.pow(2.0, RedStreak.toDouble() + 1).toInt() else 2
        var blackchance = if (BlackStreak > 0) Math.pow(2.0, BlackStreak.toDouble() + 1).toInt() else 2
        var a1to12chance = if (a1To12Streak > 0) Math.pow(3.0, a1To12Streak.toDouble() + 1).toInt() else 3
        var a13to24chance = if (a13To24Streak > 0) Math.pow(3.0, a13To24Streak.toDouble() + 1).toInt() else 3
        var a25to36chance = if (a25To36Steak > 0) Math.pow(3.0, a25To36Steak.toDouble() + 1).toInt() else 3
        var toprowchance = if (TopRowStreak > 0) Math.pow(3.0, TopRowStreak.toDouble() + 1).toInt() else 3
        var middlerowchance = if (MiddleRowStreak > 0) Math.pow(3.0, MiddleRowStreak.toDouble() + 1).toInt() else 3
        var bottomrowchance = if (BottomRowStreak > 0) Math.pow(3.0, BottomRowStreak.toDouble() + 1).toInt() else 3
        var a1to18chance = if (a1To18Streak > 0) Math.pow(2.0, a1To18Streak.toDouble() + 1).toInt() else 2
        var a19to36chance = if (a19To36Streak > 0) Math.pow(2.0, a19To36Streak.toDouble() + 1).toInt() else 2



        val textView = findViewById<TextView>(R.id.DisplayTextView)
                textView.text = "Even Streak : " + EvenStreak + "\n The chance of it happening again is 1 in " + evenchance +"\n\n Odd Streak : " + oddStreak + "\n The chance of it happening again is 1 in " + (oddchance)+"\n\n Red Streak : " + RedStreak + "\n The chance of it happening again is 1 in " + (redchance)+"\n\n Black Streak : " + BlackStreak + "\n The chance of it happening again is 1 in " + (blackchance)+"\n\n 1-18 Streak : " + a1To18Streak + "\n The chance of it happening again is 1 in " + (a1to18chance)+"\n\n 19-36 Streak : " + a19To36Streak + "\n The chance of it happening again is 1 in " + (a19to36chance)+"\n\n 1 - 12 Streak : " + a1To12Streak + "\n The chance of it happening again is 1 in " + (a1to12chance)+"\n\n 13-24 Streak : " + a13To24Streak + "\n The chance of it happening again is 1 in " + (a13to24chance)+"\n\n 25-36 Streak : " + a25To36Steak + "\n The chance of it happening again is 1 in " + (a25to36chance) +
                        "\n\n Top Row Streak : " + TopRowStreak + "\n The chance of it happening again is 1 in " + (toprowchance)+"\n\n Middle Row Streak : " + MiddleRowStreak + "\n The chance of it happening again is 1 in " + (middlerowchance) +"\n\n Bottom Row Streak : " + BottomRowStreak + "\n The chance of it happening again is 1 in " + (bottomrowchance)+
                        "\n\n Zero Streak : " + ZeroStreak + "\n The chance of it happening again is 1 in " + (a0chance) +
                        "\n\n One Streak : " + OneStreak + "\n The chance of it happening again is 1 in " + (a1chance) +
                        "\n\n Two Streak : " + TwoStreak + "\n The chance of it happening again is 1 in " + (a2chance) +
                        "\n\n Three Streak : " + ThreeStreak + "\n The chance of it happening again is 1 in " + (a3chance) +
                        "\n\n Four Streak : " + FourStreak + "\n The chance of it happening again is 1 in " + (a4chance) +
                        "\n\n Five Streak : " + FiveStreak + "\n The chance of it happening again is 1 in " + (a5chance) +
                        "\n\n Six Streak : " + SixStreak + "\n The chance of it happening again is 1 in " + (a6chance) +
                        "\n\n Seven Streak : " + SevenStreak + "\n The chance of it happening again is 1 in " + (a7chance) +
                        "\n\n Eight Streak : " + EightStreak + "\n The chance of it happening again is 1 in " + (a8chance) +
                        "\n\n Nine Streak : " + NineStreak + "\n The chance of it happening again is 1 in " + (a9chance) +
                        "\n\n Ten Streak : " + TenStreak + "\n The chance of it happening again is 1 in " + (a10chance) +
                        "\n\n Eleven Streak : " + ElevenStreak + "\n The chance of it happening again is 1 in " + (a11chance) +
                        "\n\n Twelve Streak : " + TwelveStreak + "\n The chance of it happening again is 1 in " + (a12chance) +
                        "\n\n Thirteen Streak : " + ThirteenStreak + "\n The chance of it happening again is 1 in " + (a13chance) +
                        "\n\n Fourteen Streak : " + FourteenStreak + "\n The chance of it happening again is 1 in " + (a14chance) +
                        "\n\n Fifteen Streak : " + FifteenStreak + "\n The chance of it happening again is 1 in " + (a15chance) +
                        "\n\n Sixteen Streak : " + SixteenStreak + "\n The chance of it happening again is 1 in " + (a16chance) +
                        "\n\n Seventeen Streak : " + SeventeenStreak + "\n The chance of it happening again is 1 in " + (a17chance) +
                        "\n\n Eighteen Streak : " + EighteenStreak + "\n The chance of it happening again is 1 in " + (a18chance) +
                        "\n\n Nineteen Streak : " + NineteenStreak + "\n The chance of it happening again is 1 in " + (a19chance) +
                        "\n\n Twenty Streak : " + TwentyStreak + "\n The chance of it happening again is 1 in " + (a20chance) +
                        "\n\n Twenty-One Streak : " + TwentyOneStreak + "\n The chance of it happening again is 1 in " + (a21chance) +
                        "\n\n Twenty-Two Streak : " + TwentyTwoStreak + "\n The chance of it happening again is 1 in " + (a22chance) +
                        "\n\n Twenty-Three Streak : " + TwentyThreeStreak + "\n The chance of it happening again is 1 in " + (a23chance) +
                        "\n\n Twenty-Four Streak : " + TwentyFourStreak + "\n The chance of it happening again is 1 in " + (a24chance) +
                        "\n\n Twenty-Five Streak : " + TwentyFiveStreak + "\n The chance of it happening again is 1 in " + (a25chance) +
                        "\n\n Twenty-Six Streak : " + TwentySixStreak + "\n The chance of it happening again is 1 in " + (a26chance) +
                        "\n\n Twenty-Seven Streak : " + TwentySevenStreak + "\n The chance of it happening again is 1 in " + (a27chance) +
                        "\n\n Twenty-Eight Streak : " + TwentyEightStreak + "\n The chance of it happening again is 1 in " + (a28chance) +
                        "\n\n Twenty-Nine Streak : " + TwentyNineStreak + "\n The chance of it happening again is 1 in " + (a29chance) +
                        "\n\n Thirty Streak : " + ThirtyStreak + "\n The chance of it happening again is 1 in " + (a30chance) +
                        "\n\n Thirty-One Streak : " + ThirtyOneStreak + "\n The chance of it happening again is 1 in " + (a31chance) +
                        "\n\n Thirty-Two Streak : " + ThirtyTwoStreak + "\n The chance of it happening again is 1 in " + (a32chance) +
                        "\n\n Thirty-Three Streak : " + ThirtyThreeStreak + "\n The chance of it happening again is 1 in " + (a33chance) +
                        "\n\n Thirty-Four Streak : " + ThirtyFourStreak + "\n The chance of it happening again is 1 in " + (a34chance) +
                        "\n\n Thirty-Five Streak : " + ThirtyFiveStreak + "\n The chance of it happening again is 1 in " + (a35chance) +
                        "\n\n Thirty-Six Streak : " + ThirtySixStreak + "\n The chance of it happening again is 1 in " + (a36chance) + "\n\n\n\n"



    }
    }
