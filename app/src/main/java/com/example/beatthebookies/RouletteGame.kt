package com.example.beatthebookies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class RouletteGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roulette_game)

        val mImageView = findViewById<ImageView>(R.id.image_view_1)
        val mButton = findViewById<Button>(R.id.button_1)

        val animationSet = AnimationSet(true)

        val rotateAnimation = RotateAnimation(0f, 720F, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        rotateAnimation.duration = 750 //
        rotateAnimation.repeatCount = 0 // Repeat indefinitely
        rotateAnimation.interpolator = LinearInterpolator()

        animationSet.addAnimation(rotateAnimation)

        // When button is clicked
        mButton.setOnClickListener {

            var degrees : Float = -9.729729F  // 360 degrees of a circle divided by the 37 sections

            val textViewDate = findViewById<TextView>(R.id.editTextDate)
            val currentDate = Date()

            val dateFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
            val dateString = dateFormat.format(currentDate)

            val result = (1..37).random()

            when(result) {
                1 -> {
                    val endNum = RouletteResults(-1,"1","Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 23
                    mImageView.rotation = degrees

                }
                2 -> {
                    val endNum = RouletteResults(-1,"2","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 6
                    mImageView.rotation = degrees
                }
                3 -> {
                    val endNum = RouletteResults(-1,"3","Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 35
                    mImageView.rotation = degrees
                }
                4 -> {
                    val endNum = RouletteResults(-1,"4","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 4
                    mImageView.rotation = degrees
                }
                5 -> {
                    val endNum = RouletteResults(-1,"5","Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 19
                    mImageView.rotation = degrees
                }
                6 -> {
                    val endNum = RouletteResults(-1,"6","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 10
                    mImageView.rotation = degrees
                }
                7 -> {
                    val endNum = RouletteResults(-1,"7","Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 31
                    mImageView.rotation = degrees
                }
                8 -> {
                    val endNum = RouletteResults(-1,"8","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 16
                    mImageView.rotation = degrees
                }
                9 -> {
                    val endNum = RouletteResults(-1,"9","Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 27
                    mImageView.rotation = degrees
                }
                10 -> {
                    val endNum = RouletteResults(-1,"10","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 18
                    mImageView.rotation = degrees
                }
                11 -> {
                    val endNum = RouletteResults(-1,"11","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 14
                    mImageView.rotation = degrees
                }
                12 -> {
                    val endNum = RouletteResults(-1,"12","Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 33
                    mImageView.rotation = degrees
                }
                13 -> {
                    val endNum = RouletteResults(-1,"13","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 12
                    mImageView.rotation = degrees
                }
                14 -> {
                    val endNum = RouletteResults(-1,"14","Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 25
                    mImageView.rotation = degrees
                }
                15 -> {
                    val endNum = RouletteResults(-1,"15","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 2
                    mImageView.rotation = degrees
                }
                16 -> {
                    val endNum = RouletteResults(-1,"16","Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 21
                    mImageView.rotation = degrees
                }
                17 -> {
                    val endNum = RouletteResults(-1,"17","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 8
                    mImageView.rotation = degrees
                }
                18 -> {
                    val endNum = RouletteResults(-1,"18","Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 29
                    mImageView.rotation = degrees
                }
                19 -> {
                    val endNum = RouletteResults(-1,"19","Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 3
                    mImageView.rotation = degrees
                }
                20 -> {
                    val endNum = RouletteResults(-1,"20","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 24
                    mImageView.rotation = degrees
                }
                21 -> {
                    val endNum = RouletteResults(-1,"21","Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 5
                    mImageView.rotation = degrees
                }
                22 -> {
                    val endNum = RouletteResults(-1,"22","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 28
                    mImageView.rotation = degrees
                }
                23 -> {
                    val endNum = RouletteResults(-1,"23","Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 17
                    mImageView.rotation = degrees
                }
                24 -> {
                    val endNum = RouletteResults(-1,"24","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 20
                    mImageView.rotation = degrees
                }
                25 -> {
                    val endNum = RouletteResults(-1,"25","Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 7
                    mImageView.rotation = degrees
                }
                26 -> {
                    val endNum = RouletteResults(-1,"26","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 36
                    mImageView.rotation = degrees
                }
                27 -> {
                    val endNum = RouletteResults(-1,"27","Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 11
                    mImageView.rotation = degrees
                }
                28 -> {
                    val endNum = RouletteResults(-1,"28","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 32
                    mImageView.rotation = degrees
                }
                29 -> {
                    val endNum = RouletteResults(-1,"29","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 30
                    mImageView.rotation = degrees
                }
                30 -> {
                    val endNum = RouletteResults(-1,"30","Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 15
                    mImageView.rotation = degrees
                }
                31 -> {
                    val endNum = RouletteResults(-1,"31","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 26
                    mImageView.rotation = degrees
                }
                32 -> {
                    val endNum = RouletteResults(-1,"32","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 1
                    mImageView.rotation = degrees
                }
                33 -> {
                    val endNum = RouletteResults(-1,"33","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 22
                    mImageView.rotation = degrees
                }
                34 -> {
                    val endNum = RouletteResults(-1,"34","Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 9
                    mImageView.rotation = degrees
                }
                35 -> {
                    val endNum = RouletteResults(-1,"35","Black")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 34
                    mImageView.rotation = degrees
                }
                36 -> {
                    val endNum = RouletteResults(-1,"36","Red")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)

                    mImageView.startAnimation(animationSet)
                    degrees *= 13
                    mImageView.rotation = degrees
                }
                37 -> {
                    val endNum = RouletteResults(-1,"0","Green")
                    val mydatabase = DataBaseHelper(this)
                    val databaseInput = mydatabase.addRouletteResult(endNum)


                    mImageView.startAnimation(animationSet)
                    degrees *= 37
                    mImageView.rotation = degrees
                }



                }
            }
        }
    }