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

    }

    fun buttonclick(view: View){

        val mydatabase = DataBaseHelper(this)
        val betamount = findViewById<EditText>(R.id.betAmountInput).text.toString().toInt()

        var amount0: Int = 0;  var amount1: Int = 0;  var amount2: Int = 0;  var amount3: Int = 0;
        var amount4: Int = 0;  var amount5: Int = 0;  var amount6: Int = 0;  var amount7: Int = 0;
        var amount8: Int = 0;  var amount9: Int = 0;  var amount10: Int = 0;  var amount11: Int = 0;
        var amount12: Int = 0;  var amount13: Int = 0;  var amount14: Int = 0;  var amount15: Int = 0;
        var amount16: Int = 0;  var amount17: Int = 0;  var amount18: Int = 0;  var amount19: Int = 0;
        var amount20: Int = 0;  var amount21: Int = 0;  var amount22: Int = 0;  var amount23: Int = 0;
        var amount24: Int = 0;  var amount25: Int = 0;  var amount26: Int = 0;  var amount27: Int = 0;
        var amount28: Int = 0;  var amount29: Int = 0;  var amount30: Int = 0;  var amount31: Int = 0;
        var amount32: Int = 0;  var amount33: Int = 0;  var amount34: Int = 0;  var amount35: Int = 0;
        var amount36: Int = 0


        val buttonIds = intArrayOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6,
            R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10, R.id.btn11, R.id.btn12, R.id.btn13,
            R.id.btn14, R.id.btn15, R.id.btn16, R.id.btn17, R.id.btn18, R.id.btn19, R.id.btn20,
            R.id.btn21, R.id.btn22, R.id.btn23, R.id.btn24, R.id.btn25, R.id.btn26, R.id.btn27,
            R.id.btn28, R.id.btn29, R.id.btn30, R.id.btn31, R.id.btn32, R.id.btn33, R.id.btn34,
            R.id.btn35, R.id.btn36
        )
        val buttons = Array(buttonIds.size) { i -> findViewById<Button>(buttonIds[i]) }


        buttons[0].setOnClickListener {//green 0
            var balance = mydatabase.getBalance()
            amount0 += betamount
            var total = 0
            if (betamount > balance) {
                Toast.makeText(this, "Bet Amount too large", Toast.LENGTH_SHORT).show()
            } else {
                balance -= betamount
                total += amount0
                mydatabase.updateBalanceBetAmount(37, total)

                val updatedbal = mydatabase.updateBalance(balance)
                val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                currentbalance.setText("Balance : " + balance.toString())
                Toast.makeText(this, "Bet on 0 Confirmed", Toast.LENGTH_SHORT).show()
            }
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


            val betamount = findViewById<EditText>(R.id.betAmountInput).text.toString().toInt()


            when ((36..37).random()) {
                1 -> {
                    val endNum = RouletteResults(-1, "1", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 23
                    mImageView.rotation = degrees


                }
                2 -> {
                    val endNum = RouletteResults(-1, "2", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 6
                    mImageView.rotation = degrees
                }
                3 -> {
                    val endNum = RouletteResults(-1, "3", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 35
                    mImageView.rotation = degrees
                }
                4 -> {
                    val endNum = RouletteResults(-1, "4", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 4
                    mImageView.rotation = degrees
                }
                5 -> {
                    val endNum = RouletteResults(-1, "5", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 19
                    mImageView.rotation = degrees
                }
                6 -> {
                    val endNum = RouletteResults(-1, "6", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 10
                    mImageView.rotation = degrees
                }
                7 -> {
                    val endNum = RouletteResults(-1, "7", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 31
                    mImageView.rotation = degrees
                }
                8 -> {
                    val endNum = RouletteResults(-1, "8", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 16
                    mImageView.rotation = degrees
                }
                9 -> {
                    val endNum = RouletteResults(-1, "9", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 27
                    mImageView.rotation = degrees
                }
                10 -> {
                    val endNum = RouletteResults(-1, "10", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 18
                    mImageView.rotation = degrees
                }
                11 -> {
                    val endNum = RouletteResults(-1, "11", "Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 14
                    mImageView.rotation = degrees
                }
                12 -> {
                    val endNum = RouletteResults(-1, "12", "Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 33
                    mImageView.rotation = degrees
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

                    //balance += (amount0 * 36)
                   // balance =- amount1 + amount2 + amount3 + amount4 + amount5 + amount6 + amount7 + amount8 + amount9 + amount10 + amount11 + amount12 + amount13 + amount14 + amount15 + amount16 + amount17 + amount18 + amount19 + amount20 + amount21 + amount22 + amount23 + amount24 + amount25 + amount26 + amount27 + amount28 + amount29 + amount30 + amount31 + amount32 + amount33 + amount34 + amount35 + amount36

                    val update = mydatabase.updateBalance(balance)
                    val transfer = mydatabase.transferbalancewhereId()

                    val currentbalance = findViewById<TextView>(R.id.Balancetxt)
                    resetAllAmounts()
                    currentbalance.setText("Balance : " + balance.toString())
                    Toast.makeText(this, "0", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

