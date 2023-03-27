package com.example.beatthebookies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class RouletteGame2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roulette_game2)
        val mydatabase = DataBaseHelper(this)

        val buttonIds = intArrayOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6,
            R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10, R.id.btn11, R.id.btn12, R.id.btn13,
            R.id.btn14, R.id.btn15, R.id.btn16, R.id.btn17, R.id.btn18, R.id.btn19, R.id.btn20,
            R.id.btn21, R.id.btn22, R.id.btn23, R.id.btn24, R.id.btn25, R.id.btn26, R.id.btn27,
            R.id.btn28, R.id.btn29, R.id.btn30, R.id.btn31, R.id.btn32, R.id.btn33, R.id.btn34,
            R.id.btn35, R.id.btn36, R.id.btn1to12, R.id.btn13to24, R.id.btn25to36, R.id.btnTopRow,
            R.id.btnMiddleRow, R.id.btnBottomRow, R.id.btn1to18, R.id.btneven, R.id.btnred,
            R.id.btnblack, R.id.btnodd, R.id.btn19to36
        )
        val buttons = Array(buttonIds.size) { i -> findViewById<Button>(buttonIds[i]) }

        for (i in buttons.indices) {
            val betRange = when (i) {
                in 0..36 -> i.toString()
                37 -> "1-12"
                38 -> "13-24"
                39 -> "25-36"
                40 -> "Top Row"
                41 -> "Middle Row"
                42 -> "Bottom Row"
                43 -> "1-18"
                44 -> "Even"
                45 -> "Red"
                46 -> "Black"
                47 -> "Odd"
                48 -> "19-36"
                else -> "Not a button"
            }
            buttons[i].setOnClickListener {
                buttonclick(mydatabase, i, betRange)
            }
        }

    }

    private fun buttonclick(mydatabase: DataBaseHelper, buttonIndex: Int, betRange: String) {
        val betamount = findViewById<EditText>(R.id.betAmountInput).text.toString().toInt()
        val updatebetamount = mydatabase.updateBalanceBetAmount(buttonIndex, betamount)
        var balance = mydatabase.getBalance()
        if (betamount > balance) {
            Toast.makeText(this, "Bet Amount too large", Toast.LENGTH_SHORT).show()
        } else {
            var total = mydatabase.getTempBetAmount(buttonIndex)
            balance -= betamount
            total = total?.plus(betamount)
            var updatetotal = mydatabase.updateTempBetAmount(buttonIndex, total!!)
            val updatedbal = mydatabase.updateBalance(balance)
            val currentbalance = findViewById<TextView>(R.id.Balancetxt)
            currentbalance.setText("Balance : " + balance.toString())
            Toast.makeText(this, betRange, Toast.LENGTH_SHORT).show()
        }
    }

    fun resetAllAmounts(){
        val mydatabase = DataBaseHelper(this)
        mydatabase.updateBalanceBetAmount(1, 0)
        mydatabase.updateBalanceBetAmount(2, 0)
        mydatabase.updateBalanceBetAmount(3, 0)
        mydatabase.updateBalanceBetAmount(4, 0)
        mydatabase.updateBalanceBetAmount(5, 0)
        mydatabase.updateBalanceBetAmount(6, 0)
        mydatabase.updateBalanceBetAmount(7, 0)
        mydatabase.updateBalanceBetAmount(8, 0)
        mydatabase.updateBalanceBetAmount(9, 0)
        mydatabase.updateBalanceBetAmount(10, 0)
        mydatabase.updateBalanceBetAmount(11, 0)
        mydatabase.updateBalanceBetAmount(12, 0)
        mydatabase.updateBalanceBetAmount(13, 0)
        mydatabase.updateBalanceBetAmount(14, 0)
        mydatabase.updateBalanceBetAmount(15, 0)
        mydatabase.updateBalanceBetAmount(16, 0)
        mydatabase.updateBalanceBetAmount(17, 0)
        mydatabase.updateBalanceBetAmount(18, 0)
        mydatabase.updateBalanceBetAmount(19, 0)
        mydatabase.updateBalanceBetAmount(20, 0)
        mydatabase.updateBalanceBetAmount(21, 0)
        mydatabase.updateBalanceBetAmount(22, 0)
        mydatabase.updateBalanceBetAmount(23, 0)
        mydatabase.updateBalanceBetAmount(24, 0)
        mydatabase.updateBalanceBetAmount(25, 0)
        mydatabase.updateBalanceBetAmount(26, 0)
        mydatabase.updateBalanceBetAmount(27, 0)
        mydatabase.updateBalanceBetAmount(28, 0)
        mydatabase.updateBalanceBetAmount(29, 0)
        mydatabase.updateBalanceBetAmount(30, 0)
        mydatabase.updateBalanceBetAmount(31, 0)
        mydatabase.updateBalanceBetAmount(32, 0)
        mydatabase.updateBalanceBetAmount(33, 0)
        mydatabase.updateBalanceBetAmount(34, 0)
        mydatabase.updateBalanceBetAmount(35, 0)
        mydatabase.updateBalanceBetAmount(36, 0)
        mydatabase.updateBalanceBetAmount(37, 0)
        mydatabase.updateBalanceBetAmount(38, 0)
        mydatabase.updateBalanceBetAmount(39, 0)
        mydatabase.updateBalanceBetAmount(40, 0)
        mydatabase.updateBalanceBetAmount(41, 0)
        mydatabase.updateBalanceBetAmount(42, 0)
        mydatabase.updateBalanceBetAmount(43, 0)
        mydatabase.updateBalanceBetAmount(44, 0)
        mydatabase.updateBalanceBetAmount(45, 0)
        mydatabase.updateBalanceBetAmount(46, 0)
        mydatabase.updateBalanceBetAmount(47, 0)
        mydatabase.updateBalanceBetAmount(48, 0)
        mydatabase.updateBalanceBetAmount(49, 0)
        mydatabase.updateBalanceBetAmount(50, 0)

    }

    fun resetAllTamounts(){
        val mydatabase = DataBaseHelper(this)
        mydatabase.updateTempBetAmount(1, 0)
        mydatabase.updateTempBetAmount(2, 0)
        mydatabase.updateTempBetAmount(3, 0)
        mydatabase.updateTempBetAmount(4, 0)
        mydatabase.updateTempBetAmount(5, 0)
        mydatabase.updateTempBetAmount(6, 0)
        mydatabase.updateTempBetAmount(7, 0)
        mydatabase.updateTempBetAmount(8, 0)
        mydatabase.updateTempBetAmount(9, 0)
        mydatabase.updateTempBetAmount(10, 0)
        mydatabase.updateTempBetAmount(11, 0)
        mydatabase.updateTempBetAmount(12, 0)
        mydatabase.updateTempBetAmount(13, 0)
        mydatabase.updateTempBetAmount(14, 0)
        mydatabase.updateTempBetAmount(15, 0)
        mydatabase.updateTempBetAmount(16, 0)
        mydatabase.updateTempBetAmount(17, 0)
        mydatabase.updateTempBetAmount(18, 0)
        mydatabase.updateTempBetAmount(19, 0)
        mydatabase.updateTempBetAmount(20, 0)
        mydatabase.updateTempBetAmount(21, 0)
        mydatabase.updateTempBetAmount(22, 0)
        mydatabase.updateTempBetAmount(23, 0)
        mydatabase.updateTempBetAmount(24, 0)
        mydatabase.updateTempBetAmount(25, 0)
        mydatabase.updateTempBetAmount(26, 0)
        mydatabase.updateTempBetAmount(27, 0)
        mydatabase.updateTempBetAmount(28, 0)
        mydatabase.updateTempBetAmount(29, 0)
        mydatabase.updateTempBetAmount(30, 0)
        mydatabase.updateTempBetAmount(31, 0)
        mydatabase.updateTempBetAmount(32, 0)
        mydatabase.updateTempBetAmount(33, 0)
        mydatabase.updateTempBetAmount(34, 0)
        mydatabase.updateTempBetAmount(35, 0)
        mydatabase.updateTempBetAmount(36, 0)
        mydatabase.updateTempBetAmount(37, 0)
        mydatabase.updateTempBetAmount(38, 0)
        mydatabase.updateTempBetAmount(39, 0)
        mydatabase.updateTempBetAmount(40, 0)
        mydatabase.updateTempBetAmount(41, 0)
        mydatabase.updateTempBetAmount(42, 0)
        mydatabase.updateTempBetAmount(43, 0)
        mydatabase.updateTempBetAmount(44, 0)
        mydatabase.updateTempBetAmount(45, 0)
        mydatabase.updateTempBetAmount(46, 0)
        mydatabase.updateTempBetAmount(47, 0)
        mydatabase.updateTempBetAmount(48, 0)
        mydatabase.updateTempBetAmount(49, 0)
        mydatabase.updateTempBetAmount(50, 0)
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

    fun showBalance(view: View){
        val currentbalance = findViewById<TextView>(R.id.Balancetxt)

        val context = this
        var db = DataBaseHelper(context)
        val dbHelper = DataBaseHelper(this)
        val balance = dbHelper.getBalance()

        currentbalance.setText("Balance : " + balance.toString())
    }

    fun ReturnHome(view: View){
        val intent = Intent(this, HomeScreen::class.java)
        startActivity(intent)
    }
    fun RouletteHistory(view: View){
        val intent = Intent(this, RouletteStatisticsPage::class.java)
        startActivity(intent)
    }


        fun spin(view:View){
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
            var a1To12Steak = mydatabase.getStreaksById(38)
            var a13To24Steak = mydatabase.getStreaksById(39)
            var a25To36Steak = mydatabase.getStreaksById(40)
            val TopRowStreak = mydatabase.getStreaksById(41)
            var MiddleRowStreak = mydatabase.getStreaksById(42)
            var BottomRowStreak = mydatabase.getStreaksById(43)
            var a1To18Streak = mydatabase.getStreaksById(44)
            var EvenStreak = mydatabase.getStreaksById(45)
            var RedStreak = mydatabase.getStreaksById(46)
            var BlackStreak = mydatabase.getStreaksById(47)
            var oddStreak = mydatabase.getStreaksById(48)
            var a19To36Streak = mydatabase.getStreaksById(49)


            val animationSet = AnimationSet(true)

            val rotateAnimation = RotateAnimation(
                0f,
                720F,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )
            rotateAnimation.duration = 1500
            rotateAnimation.repeatCount = 0
            rotateAnimation.interpolator = LinearInterpolator()

            animationSet.addAnimation(rotateAnimation)

            val mImageView = findViewById<ImageView>(R.id.image_view_1)


            var degrees: Float = -9.729729F  // 360 degrees of a circle divided by the 37 sections


            when ((1..1).random()) {
                1 -> if (OneStreak != null && a1To12Steak != null && BottomRowStreak != null  && a1To18Streak != null && RedStreak != null && oddStreak != null) {
                    val endNum = RouletteResults(-1, "1", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 23
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()

                    var amount1 = mydatabase.getTempBetAmount(1) //1
                    var amount37 = mydatabase.getTempBetAmount(37) //1-12
                    var amount42 = mydatabase.getTempBetAmount(42) //bottom row
                    var amount43 = mydatabase.getTempBetAmount(43) //1-18
                    var amount45 = mydatabase.getTempBetAmount(45) //red
                    var amount47 = mydatabase.getTempBetAmount(47) //odd

                    OneStreak += 1
                    a1To12Steak += 1
                    BottomRowStreak += 1
                    a1To18Streak += 1
                    RedStreak += 1
                    oddStreak += 1

                    val update1 = mydatabase.updateCounter(1,OneStreak)
                    val update2 = mydatabase.updateCounter(38,a1To12Steak)
                    val update3 = mydatabase.updateCounter(43,BottomRowStreak)
                    val update4 = mydatabase.updateCounter(44,a1To18Streak)
                    val update5 = mydatabase.updateCounter(46,RedStreak)
                    val update6 = mydatabase.updateCounter(48,oddStreak)


                    if (amount1 != null && amount37 != null && amount42 != null && amount43 != null && amount45 != null && amount47 != null) {

                        balance += (amount1 * 36) // 1
                        balance += (amount37 * 3) //  1-12
                        balance += (amount42 * 3) //bottom row
                        balance += (amount43 * 2) // 1-18
                        balance += (amount45 * 2) // red
                        balance += (amount47 * 2) //odd

                        val resetstreaks = mydatabase.resetStreaks(1,38,43,44,46,48)
                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "1", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }

                }
                2 ->  if (TwoStreak != null && a1To12Steak != null && MiddleRowStreak != null  && a1To18Streak != null && BlackStreak != null && EvenStreak != null) {
                    val endNum = RouletteResults(-1, "2", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 6
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()

                    var amount2 = mydatabase.getTempBetAmount(2) //2
                    var amount37 = mydatabase.getTempBetAmount(37) //1-12
                    var amount41 = mydatabase.getTempBetAmount(41) //middle row
                    var amount43 = mydatabase.getTempBetAmount(43) //1-18
                    var amount46 = mydatabase.getTempBetAmount(46) //black
                    var amount44 = mydatabase.getTempBetAmount(44) //even

                    if (amount2 != null && amount37 != null && amount41 != null && amount43 != null && amount46 != null && amount44 != null) {

                        balance += (amount2 * 36) // 1
                        balance += (amount37 * 3) //  1-12
                        balance += (amount41 * 3) //middle row
                        balance += (amount43 * 2) // 1-18
                        balance += (amount46 * 2) // black
                        balance += (amount44 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "2", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                3 ->  if (ThreeStreak != null && a1To12Steak != null && TopRowStreak != null  && a1To18Streak != null && RedStreak != null && oddStreak != null) {
                    val endNum = RouletteResults(-1, "3", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 35
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()

                    var amount3 = mydatabase.getTempBetAmount(3) //1
                    var amount37 = mydatabase.getTempBetAmount(37) //1-12
                    var amount40 = mydatabase.getTempBetAmount(40) //bottom row
                    var amount43 = mydatabase.getTempBetAmount(43) //1-18
                    var amount45 = mydatabase.getTempBetAmount(45) //red
                    var amount47 = mydatabase.getTempBetAmount(47) //odd

                    if (amount3 != null && amount37 != null && amount40 != null && amount43 != null && amount45 != null && amount47 != null) {

                        balance += (amount3 * 36) // 3
                        balance += (amount37 * 3) //  1-12
                        balance += (amount40 * 3) //top row
                        balance += (amount43 * 2) // 1-18
                        balance += (amount45 * 2) // red
                        balance += (amount47 * 2) //odd

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "3", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                4 -> if (FourStreak != null && a1To12Steak != null && BottomRowStreak != null  && a1To18Streak != null && BlackStreak != null && EvenStreak != null) {
                    val endNum = RouletteResults(-1, "4", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 4
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()

                    var amount4 = mydatabase.getTempBetAmount(4) //4
                    var amount37 = mydatabase.getTempBetAmount(37) //1-12
                    var amount42 = mydatabase.getTempBetAmount(42) //bottom row
                    var amount43 = mydatabase.getTempBetAmount(43) //1-18
                    var amount46 = mydatabase.getTempBetAmount(46) //black
                    var amount44 = mydatabase.getTempBetAmount(44) //even

                    if (amount4 != null && amount37 != null && amount42 != null && amount43 != null && amount46 != null && amount44 != null) {

                        balance += (amount4 * 36) // 1
                        balance += (amount37 * 3) //  1-12
                        balance += (amount42 * 3) //bottom row
                        balance += (amount43 * 2) // 1-18
                        balance += (amount46 * 2) // black
                        balance += (amount44 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "10", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                5 -> if (FiveStreak != null && a1To12Steak != null && MiddleRowStreak != null  && a1To18Streak != null && RedStreak != null && oddStreak != null) {
                    val endNum = RouletteResults(-1, "5", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 19
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()

                    var amount5 = mydatabase.getTempBetAmount(5) //1
                    var amount37 = mydatabase.getTempBetAmount(37) //1-12
                    var amount42 = mydatabase.getTempBetAmount(41) //middle row
                    var amount43 = mydatabase.getTempBetAmount(43) //1-18
                    var amount45 = mydatabase.getTempBetAmount(45) //red
                    var amount47 = mydatabase.getTempBetAmount(47) //odd

                    if (amount5 != null && amount37 != null && amount42 != null && amount43 != null && amount45 != null && amount47 != null) {

                        balance += (amount5 * 36) // 1
                        balance += (amount37 * 3) //  1-12
                        balance += (amount42 * 3) //middle row
                        balance += (amount43 * 2) // 1-18
                        balance += (amount45 * 2) // red
                        balance += (amount47 * 2) //odd

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "5", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                6 -> if (SixStreak != null && a1To12Steak != null && TopRowStreak != null  && a1To18Streak != null && BlackStreak != null && EvenStreak != null){
                    val endNum = RouletteResults(-1, "6", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 10
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()

                    var amount6 = mydatabase.getTempBetAmount(6) //6
                    var amount37 = mydatabase.getTempBetAmount(37) //1-12
                    var amount40 = mydatabase.getTempBetAmount(40) //top row
                    var amount43 = mydatabase.getTempBetAmount(43) //1-18
                    var amount46 = mydatabase.getTempBetAmount(46) //black
                    var amount44 = mydatabase.getTempBetAmount(44) //even

                    if (amount6 != null && amount37 != null && amount40 != null && amount43 != null && amount46 != null && amount44 != null) {

                        balance += (amount6 * 36) // 1
                        balance += (amount37 * 3) //  1-12
                        balance += (amount40 * 3) //top row
                        balance += (amount43 * 2) // 1-18
                        balance += (amount46 * 2) // black
                        balance += (amount44 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "6", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                7 -> if (SevenStreak != null && a1To12Steak != null && BottomRowStreak != null  && a1To18Streak != null && RedStreak != null && oddStreak != null) {
                    val endNum = RouletteResults(-1, "7", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 31
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()

                    var amount7 = mydatabase.getTempBetAmount(7) //1
                    var amount37 = mydatabase.getTempBetAmount(37) //1-12
                    var amount42 = mydatabase.getTempBetAmount(42) //bottom row
                    var amount43 = mydatabase.getTempBetAmount(43) //1-18
                    var amount45 = mydatabase.getTempBetAmount(45) //red
                    var amount47 = mydatabase.getTempBetAmount(47) //odd

                    if (amount7 != null && amount37 != null && amount42 != null && amount43 != null && amount45 != null && amount47 != null) {

                        balance += (amount7 * 36) // 1
                        balance += (amount37 * 3) //  1-12
                        balance += (amount42 * 3) //bottom row
                        balance += (amount43 * 2) // 1-18
                        balance += (amount45 * 2) // red
                        balance += (amount47 * 2) //odd

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "7", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                8 -> if (EightStreak != null && a1To12Steak != null && MiddleRowStreak != null  && a1To18Streak != null && BlackStreak != null && EvenStreak != null){
                    val endNum = RouletteResults(-1, "8", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 16
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var amount8 = mydatabase.getTempBetAmount(8) //2
                    var amount37 = mydatabase.getTempBetAmount(37) //1-12
                    var amount41 = mydatabase.getTempBetAmount(41) //bottom row
                    var amount43 = mydatabase.getTempBetAmount(43) //1-18
                    var amount46 = mydatabase.getTempBetAmount(46) //black
                    var amount44 = mydatabase.getTempBetAmount(44) //even

                    if (amount8 != null && amount37 != null && amount41 != null && amount43 != null && amount46 != null && amount44 != null) {

                        balance += (amount8 * 36) // 8
                        balance += (amount37 * 3) //  1-12
                        balance += (amount41 * 3) //middle row
                        balance += (amount43 * 2) // 1-18
                        balance += (amount46 * 2) // black
                        balance += (amount44 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "8", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                9 -> if (NineStreak != null && a1To12Steak != null && TopRowStreak != null  && a1To18Streak != null && RedStreak != null && oddStreak != null) {
                    val endNum = RouletteResults(-1, "9", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 27
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()

                    var amount9 = mydatabase.getTempBetAmount(9) //9
                    var amount37 = mydatabase.getTempBetAmount(37) //1-12
                    var amount40 = mydatabase.getTempBetAmount(40) //top row
                    var amount43 = mydatabase.getTempBetAmount(43) //1-18
                    var amount45 = mydatabase.getTempBetAmount(45) //red
                    var amount47 = mydatabase.getTempBetAmount(47) //odd

                    if (amount9 != null && amount37 != null && amount40 != null && amount43 != null && amount45 != null && amount47 != null) {

                        balance += (amount9 * 36) // 9
                        balance += (amount37 * 3) //  1-12
                        balance += (amount40 * 3) //top row
                        balance += (amount43 * 2) // 1-18
                        balance += (amount45 * 2) // red
                        balance += (amount47 * 2) //odd

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "3", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                10 -> if (TenStreak != null && a1To12Steak != null && BottomRowStreak != null  && a1To18Streak != null && BlackStreak != null && EvenStreak != null){
                    val endNum = RouletteResults(-1, "10", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 18
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()

                    var amount10 = mydatabase.getTempBetAmount(10) //2
                    var amount37 = mydatabase.getTempBetAmount(37) //1-12
                    var amount42 = mydatabase.getTempBetAmount(42) //bottom row
                    var amount43 = mydatabase.getTempBetAmount(43) //1-18
                    var amount46 = mydatabase.getTempBetAmount(46) //black
                    var amount44 = mydatabase.getTempBetAmount(44) //even

                    if (amount10 != null && amount37 != null && amount42 != null && amount43 != null && amount46 != null && amount44 != null) {

                        balance += (amount10 * 36) // 1
                        balance += (amount37 * 3) //  1-12
                        balance += (amount42 * 3) //bottom row
                        balance += (amount43 * 2) // 1-18
                        balance += (amount46 * 2) // black
                        balance += (amount44 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "10", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                11 -> if (ElevenStreak != null && a1To12Steak != null && MiddleRowStreak != null  && a1To18Streak != null && BlackStreak != null && oddStreak != null){
                    val endNum = RouletteResults(-1, "11", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 14
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()

                    var amount11 = mydatabase.getTempBetAmount(11) //2
                    var amount37 = mydatabase.getTempBetAmount(37) //1-12
                    var amount41 = mydatabase.getTempBetAmount(41) //bottom row
                    var amount43 = mydatabase.getTempBetAmount(43) //1-18
                    var amount46 = mydatabase.getTempBetAmount(46) //black
                    var amount47 = mydatabase.getTempBetAmount(47) //odd

                    if (amount11 != null && amount37 != null && amount41 != null && amount43 != null && amount46 != null && amount47 != null) {

                        balance += (amount11 * 36) // 8
                        balance += (amount37 * 3) //  1-12
                        balance += (amount41 * 3) //middle row
                        balance += (amount43 * 2) // 1-18
                        balance += (amount46 * 2) // black
                        balance += (amount47 * 2) //odd

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "11", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                12 -> if (TwelveStreak != null && a1To12Steak != null && TopRowStreak != null  && a1To18Streak != null && RedStreak != null && EvenStreak != null){
                    val endNum = RouletteResults(-1, "12", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 33
                    mImageView.rotation = degrees
                    var balance = mydatabase.getBalance()

                    var amount12 = mydatabase.getTempBetAmount(12) //9
                    var amount37 = mydatabase.getTempBetAmount(37) //1-12
                    var amount40 = mydatabase.getTempBetAmount(40) //top row
                    var amount43 = mydatabase.getTempBetAmount(43) //1-18
                    var amount45 = mydatabase.getTempBetAmount(45) //red
                    var amount44 = mydatabase.getTempBetAmount(44) //odd

                    if (amount12 != null && amount37 != null && amount40 != null && amount43 != null && amount45 != null && amount44 != null) {

                        balance += (amount12 * 36) // 9
                        balance += (amount37 * 3) //  1-12
                        balance += (amount40 * 3) //top row
                        balance += (amount43 * 2) // 1-18
                        balance += (amount45 * 2) // red
                        balance += (amount44 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "12", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                13 -> if (ThirteenStreak != null && a13To24Steak != null && BottomRowStreak != null  && a1To18Streak != null && BlackStreak != null && oddStreak != null){
                    val endNum = RouletteResults(-1, "13", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 12
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var amount13 = mydatabase.getTempBetAmount(13) //13
                    var amount38 = mydatabase.getTempBetAmount(38) //13-24
                    var amount42 = mydatabase.getTempBetAmount(42) //bottom row
                    var amount43 = mydatabase.getTempBetAmount(43) //1-18
                    var amount46 = mydatabase.getTempBetAmount(46) //black
                    var amount47 = mydatabase.getTempBetAmount(47) //odd

                    if (amount13 != null && amount38 != null && amount42 != null && amount43 != null && amount46 != null && amount47 != null) {

                        balance += (amount13 * 36) //13
                        balance += (amount38 * 3) //13-24
                        balance += (amount42 * 3) //bottom row
                        balance += (amount43 * 2) // 1-18
                        balance += (amount46 * 2) // black
                        balance += (amount47 * 2) //odd

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "13", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                14 -> if (FourteenStreak != null && a13To24Steak != null && MiddleRowStreak != null  && a1To18Streak != null && RedStreak != null && EvenStreak != null){
                    val endNum = RouletteResults(-1, "14", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 25
                    mImageView.rotation = degrees


                    var balance = mydatabase.getBalance()
                    var amount14 = mydatabase.getTempBetAmount(14) //14
                    var amount38 = mydatabase.getTempBetAmount(38) //13-24
                    var amount41 = mydatabase.getTempBetAmount(41) //middle row
                    var amount43 = mydatabase.getTempBetAmount(43) //1-18
                    var amount45 = mydatabase.getTempBetAmount(45) //red
                    var amount44 = mydatabase.getTempBetAmount(44) //odd

                    if (amount14 != null && amount38 != null && amount41 != null && amount43 != null && amount45 != null && amount44 != null) {

                        balance += (amount14 * 36) //14
                        balance += (amount38 * 3) //13-24
                        balance += (amount41 * 3) //middle row
                        balance += (amount43 * 2) // 1-18
                        balance += (amount45 * 2) // red
                        balance += (amount44 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "14", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                15 -> if (FifteenStreak != null && a13To24Steak != null && TopRowStreak != null  && a1To18Streak != null && BlackStreak != null && oddStreak != null){
                    val endNum = RouletteResults(-1, "15", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 2
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()

                    var amount15 = mydatabase.getTempBetAmount(15) //15
                    var amount38 = mydatabase.getTempBetAmount(38) //25-36
                    var amount40 = mydatabase.getTempBetAmount(40) //top row
                    var amount43 = mydatabase.getTempBetAmount(43) //1-18
                    var amount46 = mydatabase.getTempBetAmount(46) //black
                    var amount47 = mydatabase.getTempBetAmount(47) //odd

                    if (amount15 != null && amount38 != null && amount40 != null && amount43 != null && amount46 != null && amount47 != null) {

                        balance += (amount15 * 36) //15
                        balance += (amount38 * 3) //13-24
                        balance += (amount40 * 3) //top row
                        balance += (amount43 * 2) // 19-36
                        balance += (amount46 * 2) // black
                        balance += (amount47 * 2) //odd

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "15", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                16 -> if (SixteenStreak != null && a13To24Steak != null && BottomRowStreak != null  && a1To18Streak != null && RedStreak != null && EvenStreak != null){
                    val endNum = RouletteResults(-1, "16", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 21
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var amount16 = mydatabase.getTempBetAmount(16) //16
                    var amount38 = mydatabase.getTempBetAmount(38) //13-24
                    var amount42 = mydatabase.getTempBetAmount(42) //bottom row
                    var amount43 = mydatabase.getTempBetAmount(43) //1-18
                    var amount45 = mydatabase.getTempBetAmount(45) //red
                    var amount44 = mydatabase.getTempBetAmount(44) //even

                    if (amount16 != null && amount38 != null && amount42 != null && amount43 != null && amount45 != null && amount44 != null) {

                        balance += (amount16 * 36) //14
                        balance += (amount38 * 3) //13-24
                        balance += (amount42 * 3) //bottom row
                        balance += (amount43 * 2) // 1-18
                        balance += (amount45 * 2) // red
                        balance += (amount44 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "16", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                17 -> if (SeventeenStreak != null && a13To24Steak != null && MiddleRowStreak != null  && a1To18Streak != null && BlackStreak != null && oddStreak != null){
                    val endNum = RouletteResults(-1, "17", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 8
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()

                    var amount17 = mydatabase.getTempBetAmount(17) //17
                    var amount38 = mydatabase.getTempBetAmount(38) //13-24
                    var amount41 = mydatabase.getTempBetAmount(41) //middle row
                    var amount43 = mydatabase.getTempBetAmount(43) //1-18
                    var amount46 = mydatabase.getTempBetAmount(46) //black
                    var amount47 = mydatabase.getTempBetAmount(47) //odd

                    if (amount17 != null && amount38 != null && amount41 != null && amount43 != null && amount46 != null && amount47 != null) {

                        balance += (amount17 * 36) // 17
                        balance += (amount38 * 3) //  1-12
                        balance += (amount41 * 3) //middle row
                        balance += (amount43 * 2) // 1-18
                        balance += (amount46 * 2) // black
                        balance += (amount47 * 2) //odd

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "17", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                18 ->if (EighteenStreak != null && a13To24Steak != null && TopRowStreak != null  && a1To18Streak != null && RedStreak != null && EvenStreak != null) {
                    val endNum = RouletteResults(-1, "18", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 29
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var amount18 = mydatabase.getTempBetAmount(18) //18
                    var amount38 = mydatabase.getTempBetAmount(38) //13-24
                    var amount40 = mydatabase.getTempBetAmount(40) //top row
                    var amount43 = mydatabase.getTempBetAmount(43) //1-18
                    var amount45 = mydatabase.getTempBetAmount(45) //red
                    var amount44 = mydatabase.getTempBetAmount(44) //even

                    if (amount18 != null && amount38 != null && amount40 != null && amount43 != null && amount45 != null && amount44 != null) {

                        balance += (amount18 * 36) //14
                        balance += (amount38 * 3) //13-24
                        balance += (amount40 * 3) //top row
                        balance += (amount43 * 2) // 1-18
                        balance += (amount45 * 2) // red
                        balance += (amount44 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "18", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                19 ->if (NineteenStreak != null && a13To24Steak != null && BottomRowStreak != null  && a19To36Streak != null && RedStreak != null && oddStreak != null) {
                    val endNum = RouletteResults(-1, "19", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 3
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var amount19 = mydatabase.getTempBetAmount(19) //19
                    var amount38 = mydatabase.getTempBetAmount(38) //13-24
                    var amount42 = mydatabase.getTempBetAmount(42) //bottom row
                    var amount48 = mydatabase.getTempBetAmount(48) //18-36
                    var amount45 = mydatabase.getTempBetAmount(45) //red
                    var amount47 = mydatabase.getTempBetAmount(47) //odd

                    if (amount19 != null && amount38 != null && amount42 != null && amount48 != null && amount45 != null && amount47 != null) {

                        balance += (amount19 * 36) //19
                        balance += (amount38 * 3) //13-24
                        balance += (amount42 * 3) //bottom row
                        balance += (amount48 * 2) // 18-36
                        balance += (amount45 * 2) // red
                        balance += (amount47 * 2) //odd

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "19", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                20 ->if (TwentyStreak != null && a13To24Steak != null && MiddleRowStreak != null  && a19To36Streak != null && BlackStreak != null && EvenStreak != null) {
                    val endNum = RouletteResults(-1, "20", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 24
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var amount20 = mydatabase.getTempBetAmount(20) //20
                    var amount38 = mydatabase.getTempBetAmount(38) //13-24
                    var amount41 = mydatabase.getTempBetAmount(41) //middle row
                    var amount48 = mydatabase.getTempBetAmount(48) //19-36
                    var amount46 = mydatabase.getTempBetAmount(46) //black
                    var amount44 = mydatabase.getTempBetAmount(44) //even

                    if (amount20 != null && amount38 != null && amount41 != null && amount48 != null && amount46 != null && amount44 != null) {

                        balance += (amount20 * 36) // 20
                        balance += (amount38 * 3) //  13-24
                        balance += (amount41 * 3) //middle row
                        balance += (amount48 * 2) // 19-36
                        balance += (amount46 * 2) // black
                        balance += (amount44 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "20", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                21 -> if (TwentyOneStreak != null && a13To24Steak != null && TopRowStreak != null  && a19To36Streak != null && RedStreak != null && oddStreak != null){
                    val endNum = RouletteResults(-1, "21", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 5
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var amount21 = mydatabase.getTempBetAmount(21) //21
                    var amount38 = mydatabase.getTempBetAmount(38) //13-24
                    var amount40 = mydatabase.getTempBetAmount(40) //top row
                    var amount48 = mydatabase.getTempBetAmount(48) //19-36
                    var amount45 = mydatabase.getTempBetAmount(45) //red
                    var amount47 = mydatabase.getTempBetAmount(47) //odd

                    if (amount21 != null && amount38 != null && amount40 != null && amount48 != null && amount45 != null && amount47 != null) {

                        balance += (amount21 * 36) //21
                        balance += (amount38 * 3) //13-24
                        balance += (amount40 * 3) //top row
                        balance += (amount48 * 2) // 19-36
                        balance += (amount45 * 2) // red
                        balance += (amount47 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "21", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                22 -> if (TwentyTwoStreak != null && a13To24Steak != null && BottomRowStreak != null  && a19To36Streak != null && BlackStreak != null && EvenStreak != null){
                    val endNum = RouletteResults(-1, "22", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 28
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var amount22 = mydatabase.getTempBetAmount(22) //22
                    var amount38 = mydatabase.getTempBetAmount(38) //13-24
                    var amount42 = mydatabase.getTempBetAmount(42) //bottom row
                    var amount48 = mydatabase.getTempBetAmount(48) //19-36
                    var amount46 = mydatabase.getTempBetAmount(46) //black
                    var amount44 = mydatabase.getTempBetAmount(44) //even

                    if (amount22 != null && amount38 != null && amount42 != null && amount48 != null && amount46 != null && amount44 != null) {

                        balance += (amount22 * 36) // 22
                        balance += (amount38 * 3) //  13-24
                        balance += (amount42 * 3) //middle row
                        balance += (amount48 * 2) // 19-36
                        balance += (amount46 * 2) // black
                        balance += (amount44 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "22", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                23 -> if (TwentyThreeStreak != null && a13To24Steak != null && MiddleRowStreak != null  && a19To36Streak != null && RedStreak != null && oddStreak != null){
                    val endNum = RouletteResults(-1, "23", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 17
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var amount23 = mydatabase.getTempBetAmount(23) //23
                    var amount38 = mydatabase.getTempBetAmount(38) //13-24
                    var amount41 = mydatabase.getTempBetAmount(41) //middle row
                    var amount48 = mydatabase.getTempBetAmount(48) //19-36
                    var amount45 = mydatabase.getTempBetAmount(45) //red
                    var amount47 = mydatabase.getTempBetAmount(47) //odd

                    if (amount23 != null && amount38 != null && amount41 != null && amount48 != null && amount45 != null && amount47 != null) {

                        balance += (amount23 * 36) //21
                        balance += (amount38 * 3) //13-24
                        balance += (amount41 * 3) //middle row
                        balance += (amount48 * 2) //19-36
                        balance += (amount45 * 2) //red
                        balance += (amount47 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "23", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                24 ->if (TwentyFourStreak != null && a13To24Steak != null && TopRowStreak != null  && a19To36Streak != null && BlackStreak != null && EvenStreak != null) {
                    val endNum = RouletteResults(-1, "24", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 20
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var amount24 = mydatabase.getTempBetAmount(24) //24
                    var amount38 = mydatabase.getTempBetAmount(38) //13-24
                    var amount40 = mydatabase.getTempBetAmount(40) //top row
                    var amount48 = mydatabase.getTempBetAmount(48) //19-36
                    var amount46 = mydatabase.getTempBetAmount(46) //black
                    var amount44 = mydatabase.getTempBetAmount(44) //even

                    if (amount24 != null && amount38 != null && amount40 != null && amount48 != null && amount46 != null && amount44 != null) {

                        balance += (amount24 * 36) // 24
                        balance += (amount38 * 3) //  13-24
                        balance += (amount40 * 3) //top row
                        balance += (amount48 * 2) // 19-36
                        balance += (amount46 * 2) // black
                        balance += (amount44 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "24", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                25 -> if (TwentyFiveStreak != null && a25To36Steak != null && BottomRowStreak != null  && a19To36Streak != null && RedStreak != null && oddStreak != null){
                    val endNum = RouletteResults(-1, "25", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 7
                    mImageView.rotation = degrees
                    var balance = mydatabase.getBalance()

                    var amount25 = mydatabase.getTempBetAmount(25) //25
                    var amount39 = mydatabase.getTempBetAmount(39) //25-36
                    var amount42 = mydatabase.getTempBetAmount(42) //bottom row
                    var amount48 = mydatabase.getTempBetAmount(48) //19-36
                    var amount45 = mydatabase.getTempBetAmount(45) //red
                    var amount47 = mydatabase.getTempBetAmount(47) //odd

                    if (amount25 != null && amount39 != null && amount42 != null && amount48 != null && amount45 != null && amount47 != null) {

                        balance += (amount25 * 36) //25
                        balance += (amount39 * 3) //25-36
                        balance += (amount42 * 3) //bottom row
                        balance += (amount48 * 2) // 19-36
                        balance += (amount45 * 2) // red
                        balance += (amount47 * 2) //odd

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "25", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                26 -> if (TwentySixStreak != null && a25To36Steak != null && MiddleRowStreak != null  && a19To36Streak != null && BlackStreak != null && EvenStreak != null){
                    val endNum = RouletteResults(-1, "26", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 36
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var amount26 = mydatabase.getTempBetAmount(26) //26
                    var amount39 = mydatabase.getTempBetAmount(39) //13-24
                    var amount41 = mydatabase.getTempBetAmount(41) //middle row
                    var amount48 = mydatabase.getTempBetAmount(48) //19-36
                    var amount46 = mydatabase.getTempBetAmount(46) //black
                    var amount44 = mydatabase.getTempBetAmount(44) //even

                    if (amount26 != null && amount39 != null && amount41 != null && amount48 != null && amount46 != null && amount44 != null) {

                        balance += (amount26 * 36) // 26
                        balance += (amount39 * 3) //  25-36
                        balance += (amount41 * 3) //middle row
                        balance += (amount48 * 2) // 19-36
                        balance += (amount46 * 2) // black
                        balance += (amount44 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "26", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                27 -> if (TwentySevenStreak != null && a25To36Steak != null && TopRowStreak != null  && a19To36Streak != null && RedStreak != null && oddStreak != null){
                    val endNum = RouletteResults(-1, "27", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 11
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()

                    var amount27 = mydatabase.getTempBetAmount(27) //27
                    var amount39 = mydatabase.getTempBetAmount(39) //25-36
                    var amount40 = mydatabase.getTempBetAmount(40) //top row
                    var amount48 = mydatabase.getTempBetAmount(48) //19-36
                    var amount45 = mydatabase.getTempBetAmount(45) //red
                    var amount47 = mydatabase.getTempBetAmount(47) //odd

                    if (amount27 != null && amount39 != null && amount40 != null && amount48 != null && amount45 != null && amount47 != null) {

                        balance += (amount27 * 36) //27
                        balance += (amount39 * 3) //25-36
                        balance += (amount40 * 3) //top row
                        balance += (amount48 * 2) // 19-36
                        balance += (amount45 * 2) // red
                        balance += (amount47 * 2) //odd

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "27", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                28 -> if (TwentyEightStreak != null && a25To36Steak != null && BottomRowStreak != null  && a19To36Streak != null && BlackStreak != null && EvenStreak != null){
                    val endNum = RouletteResults(-1, "28", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 32
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var amount28 = mydatabase.getTempBetAmount(28) //28
                    var amount39 = mydatabase.getTempBetAmount(39) //25-36
                    var amount42 = mydatabase.getTempBetAmount(42) //bottom row
                    var amount48 = mydatabase.getTempBetAmount(48) //19-36
                    var amount46 = mydatabase.getTempBetAmount(46) //black
                    var amount44 = mydatabase.getTempBetAmount(44) //even

                    if (amount28 != null && amount39 != null && amount42 != null && amount48 != null && amount46 != null && amount44 != null) {

                        balance += (amount28 * 36) // 28
                        balance += (amount39 * 3) //  25-36
                        balance += (amount42 * 3) //bottom row
                        balance += (amount48 * 2) // 19-36
                        balance += (amount46 * 2) // black
                        balance += (amount44 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "28", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                29 -> if (TwentyNineStreak != null && a25To36Steak != null && MiddleRowStreak != null  && a19To36Streak != null && BlackStreak != null && oddStreak != null){
                    val endNum = RouletteResults(-1, "29", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 30
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var amount29 = mydatabase.getTempBetAmount(29) //29
                    var amount39 = mydatabase.getTempBetAmount(39) //25-36
                    var amount41 = mydatabase.getTempBetAmount(41) //middle row
                    var amount48 = mydatabase.getTempBetAmount(48) //19-36
                    var amount46 = mydatabase.getTempBetAmount(46) //black
                    var amount47 = mydatabase.getTempBetAmount(47) //odd

                    if (amount29 != null && amount39 != null && amount41 != null && amount48 != null && amount46 != null && amount47 != null) {

                        balance += (amount29 * 36) //29
                        balance += (amount39 * 3) //25-36
                        balance += (amount41 * 3) //bottom row
                        balance += (amount48 * 2) // 19-36
                        balance += (amount46 * 2) // black
                        balance += (amount47 * 2) //odd

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "33", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                30 -> if (ThirtyStreak != null && a25To36Steak != null && TopRowStreak != null  && a19To36Streak != null && RedStreak != null && EvenStreak != null){
                    val endNum = RouletteResults(-1, "30", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 15
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()

                    var amount30 = mydatabase.getTempBetAmount(30) //30
                    var amount39 = mydatabase.getTempBetAmount(39) //25-36
                    var amount40 = mydatabase.getTempBetAmount(40) //top row
                    var amount48 = mydatabase.getTempBetAmount(48) //19-36
                    var amount45 = mydatabase.getTempBetAmount(45) //red
                    var amount44 = mydatabase.getTempBetAmount(44) //even

                    if (amount30 != null && amount39 != null && amount40 != null && amount48 != null && amount45 != null && amount44 != null) {

                        balance += (amount30 * 36) //30
                        balance += (amount39 * 3) //25-36
                        balance += (amount40 * 3) //top row
                        balance += (amount48 * 2) // 19-36
                        balance += (amount45 * 2) // red
                        balance += (amount44 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "30", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                31 -> if (ThirtyOneStreak != null && a25To36Steak != null && BottomRowStreak != null  && a19To36Streak != null && BlackStreak != null && oddStreak != null){
                    val endNum = RouletteResults(-1, "31", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 26
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var amount31 = mydatabase.getTempBetAmount(31) //31
                    var amount39 = mydatabase.getTempBetAmount(39) //25-36
                    var amount42 = mydatabase.getTempBetAmount(42) //bottom row
                    var amount48 = mydatabase.getTempBetAmount(48) //19-36
                    var amount46 = mydatabase.getTempBetAmount(46) //black
                    var amount47 = mydatabase.getTempBetAmount(47) //odd

                    if (amount31 != null && amount39 != null && amount42 != null && amount48 != null && amount46 != null && amount47 != null) {

                        balance += (amount31 * 36) //33
                        balance += (amount39 * 3) //25-36
                        balance += (amount42 * 3) //bottom row
                        balance += (amount48 * 2) // 19-36
                        balance += (amount46 * 2) // black
                        balance += (amount47 * 2) //odd

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "31", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }


                }
                32 -> if (ThirtyTwoStreak != null && a25To36Steak != null && MiddleRowStreak != null  && a19To36Streak != null && RedStreak != null && EvenStreak != null){
                    val endNum = RouletteResults(-1, "32", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 1
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var amount32 = mydatabase.getTempBetAmount(32) //36
                    var amount39 = mydatabase.getTempBetAmount(39) //25-36
                    var amount41 = mydatabase.getTempBetAmount(41) //middle row
                    var amount48 = mydatabase.getTempBetAmount(48) //19-36
                    var amount45 = mydatabase.getTempBetAmount(45) //red
                    var amount44 = mydatabase.getTempBetAmount(44) //even

                    if (amount32 != null && amount39 != null && amount41 != null && amount48 != null && amount45 != null && amount44 != null) {

                        balance += (amount32 * 36) //36
                        balance += (amount39 * 3) //25-36
                        balance += (amount41 * 3) //middle row
                        balance += (amount48 * 2) // 19-36
                        balance += (amount45 * 2) // red
                        balance += (amount44 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "32", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                33 -> if (ThirtyThreeStreak != null && a25To36Steak != null && TopRowStreak != null  && a19To36Streak != null && BlackStreak != null && oddStreak != null){
                    val endNum = RouletteResults(-1, "33", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 22
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var amount33 = mydatabase.getTempBetAmount(33) //9
                    var amount39 = mydatabase.getTempBetAmount(39) //25-36
                    var amount42 = mydatabase.getTempBetAmount(42) //bottom row
                    var amount48 = mydatabase.getTempBetAmount(48) //1-36
                    var amount46 = mydatabase.getTempBetAmount(46) //black
                    var amount47 = mydatabase.getTempBetAmount(47) //odd

                    if (amount33 != null && amount39 != null && amount42 != null && amount48 != null && amount46 != null && amount47 != null) {

                        balance += (amount33 * 36) //33
                        balance += (amount39 * 3) //25-36
                        balance += (amount42 * 3) //bottom row
                        balance += (amount48 * 2) // 19-36
                        balance += (amount46 * 2) // black
                        balance += (amount47 * 2) //odd

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "33", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                34 -> if (ThirtyFourStreak != null && a25To36Steak != null && BottomRowStreak != null  && a19To36Streak != null && RedStreak != null && EvenStreak != null){
                    val endNum = RouletteResults(-1, "34", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 9
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var amount34 = mydatabase.getTempBetAmount(34) //34
                    var amount39 = mydatabase.getTempBetAmount(39) //25-36
                    var amount42 = mydatabase.getTempBetAmount(42) //bottom row
                    var amount48 = mydatabase.getTempBetAmount(48) //19-36
                    var amount45 = mydatabase.getTempBetAmount(45) //red
                    var amount44 = mydatabase.getTempBetAmount(44) //even

                    if (amount34 != null && amount39 != null && amount42 != null && amount48 != null && amount45 != null && amount44 != null) {

                        balance += (amount34 * 36) //36
                        balance += (amount39 * 3) //25-36
                        balance += (amount42 * 3) //bottom row
                        balance += (amount48 * 2) // 19-36
                        balance += (amount45 * 2) // red
                        balance += (amount44 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "34", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                35 -> if (ThirtyFiveStreak != null && a25To36Steak != null && MiddleRowStreak != null  && a19To36Streak != null && BlackStreak != null && oddStreak != null){
                    val endNum = RouletteResults(-1, "35", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 34
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()

                    var amount35 = mydatabase.getTempBetAmount(35) //35
                    var amount39 = mydatabase.getTempBetAmount(39) //25-36
                    var amount41 = mydatabase.getTempBetAmount(41) //middle row
                    var amount48 = mydatabase.getTempBetAmount(48) //1-36
                    var amount46 = mydatabase.getTempBetAmount(46) //black
                    var amount47 = mydatabase.getTempBetAmount(47) //odd

                    if (amount35 != null && amount39 != null && amount41 != null && amount48 != null && amount46 != null && amount47 != null) {

                        balance += (amount35 * 36) //33
                        balance += (amount39 * 3) //25-36
                        balance += (amount41 * 3) //middle row
                        balance += (amount48 * 2) // 19-36
                        balance += (amount46 * 2) // black
                        balance += (amount47 * 2) //odd

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "35", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                36 -> if (ThirtySixStreak != null && a25To36Steak != null && TopRowStreak != null  && a19To36Streak != null && RedStreak != null && EvenStreak != null){
                    val endNum = RouletteResults(-1, "36", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 13
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var amount36 = mydatabase.getTempBetAmount(36) //36
                    var amount39 = mydatabase.getTempBetAmount(39) //25-36
                    var amount40 = mydatabase.getTempBetAmount(40) //top row
                    var amount48 = mydatabase.getTempBetAmount(48) //19-36
                    var amount45 = mydatabase.getTempBetAmount(45) //red
                    var amount44 = mydatabase.getTempBetAmount(44) //even

                    if (amount36 != null && amount39 != null && amount40 != null && amount48 != null && amount45 != null && amount44 != null) {

                        balance += (amount36 * 36) //36
                        balance += (amount39 * 3) //25-36
                        balance += (amount40 * 3) //top row
                        balance += (amount48 * 2) // 19-36
                        balance += (amount45 * 2) // red
                        balance += (amount44 * 2) //even

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "36", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }
                }
                37 -> if (ZeroStreak != null){
                    val endNum = RouletteResults(-1, "0", "Green")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 37
                    mImageView.rotation = degrees

                    var balance = mydatabase.getBalance()
                    var sum = mydatabase.getBetAmountSum()
                    var amount0 = mydatabase.getBetAmount(37)

                    if (amount0 != null) {
                            balance += (amount0 * 36)
                            balance -= (sum - amount0)
                            val update = mydatabase.updateBalance(balance)
                            val transfer = mydatabase.transferbalancewhereId()

                            val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                            currentbalance.setText("Balance : " + balance.toString())
                            Toast.makeText(this, "0", Toast.LENGTH_SHORT).show()
                            resetAllAmounts()
                    }
                }
            }
        }
}

