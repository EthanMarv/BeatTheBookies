package com.example.beatthebookies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.EditText
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


        fun spin(view:View){

            val animationSet = AnimationSet(true)

            val rotateAnimation = RotateAnimation(
                0f,
                720F,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f
            )
            rotateAnimation.duration = 750
            rotateAnimation.repeatCount = 0
            rotateAnimation.interpolator = LinearInterpolator()

            animationSet.addAnimation(rotateAnimation)

            val mImageView = findViewById<ImageView>(R.id.image_view_1)


            var degrees: Float = -9.729729F  // 360 degrees of a circle divided by the 37 sections


            when ((6..6).random()) {
                1 -> {
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

                    if (amount1 != null && amount37 != null && amount42 != null && amount43 != null && amount45 != null && amount47 != null) {

                        balance += (amount1 * 36) // 1
                        balance += (amount37 * 3) //  1-12
                        balance += (amount42 * 3) //bottom row
                        balance += (amount43 * 2) // 1-18
                        balance += (amount45 * 2) // red
                        balance += (amount47 * 2) //odd

                        val update = mydatabase.updateBalance(balance)
                        val transfer = mydatabase.transferbalancewhereId()
                        val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                        currentbalance.setText("Balance : " + balance.toString())
                        Toast.makeText(this, "1", Toast.LENGTH_SHORT).show()
                        resetAllAmounts()
                        resetAllTamounts()
                    }

                }
                2 -> {
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
                3 -> {
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
                4 -> {
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
                5 -> {
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
                6 -> {
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
                7 -> {
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
                8 -> {
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
                9 -> {
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
                10 -> {
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
                11 -> {
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
                12 -> {
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
                13 -> {
                    val endNum = RouletteResults(-1, "13", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 12
                    mImageView.rotation = degrees
                }
                14 -> {
                    val endNum = RouletteResults(-1, "14", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 25
                    mImageView.rotation = degrees
                }
                15 -> {
                    val endNum = RouletteResults(-1, "15", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 2
                    mImageView.rotation = degrees
                }
                16 -> {
                    val endNum = RouletteResults(-1, "16", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 21
                    mImageView.rotation = degrees
                }
                17 -> {
                    val endNum = RouletteResults(-1, "17", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 8
                    mImageView.rotation = degrees
                }
                18 -> {
                    val endNum = RouletteResults(-1, "18", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 29
                    mImageView.rotation = degrees
                }
                19 -> {
                    val endNum = RouletteResults(-1, "19", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 3
                    mImageView.rotation = degrees
                }
                20 -> {
                    val endNum = RouletteResults(-1, "20", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 24
                    mImageView.rotation = degrees
                }
                21 -> {
                    val endNum = RouletteResults(-1, "21", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 5
                    mImageView.rotation = degrees
                }
                22 -> {
                    val endNum = RouletteResults(-1, "22", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 28
                    mImageView.rotation = degrees
                }
                23 -> {
                    val endNum = RouletteResults(-1, "23", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 17
                    mImageView.rotation = degrees
                }
                24 -> {
                    val endNum = RouletteResults(-1, "24", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 20
                    mImageView.rotation = degrees
                }
                25 -> {
                    val endNum = RouletteResults(-1, "25", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 7
                    mImageView.rotation = degrees
                }
                26 -> {
                    val endNum = RouletteResults(-1, "26", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 36
                    mImageView.rotation = degrees
                }
                27 -> {
                    val endNum = RouletteResults(-1, "27", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 11
                    mImageView.rotation = degrees
                }
                28 -> {
                    val endNum = RouletteResults(-1, "28", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 32
                    mImageView.rotation = degrees
                }
                29 -> {
                    val endNum = RouletteResults(-1, "29", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 30
                    mImageView.rotation = degrees
                }
                30 -> {
                    val endNum = RouletteResults(-1, "30", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 15
                    mImageView.rotation = degrees
                }
                31 -> {
                    val endNum = RouletteResults(-1, "31", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 26
                    mImageView.rotation = degrees
                }
                32 -> {
                    val endNum = RouletteResults(-1, "32", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 1
                    mImageView.rotation = degrees
                }
                33 -> {
                    val endNum = RouletteResults(-1, "33", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 22
                    mImageView.rotation = degrees
                }
                34 -> {
                    val endNum = RouletteResults(-1, "34", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 9
                    mImageView.rotation = degrees
                }
                35 -> {
                    val endNum = RouletteResults(-1, "35", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 34
                    mImageView.rotation = degrees
                }
                36 -> {
                    val endNum = RouletteResults(-1, "36", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 13
                    mImageView.rotation = degrees
                }
                37 -> {
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

