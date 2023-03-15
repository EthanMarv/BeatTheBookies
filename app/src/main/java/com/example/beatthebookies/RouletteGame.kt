package com.example.beatthebookies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.*
import kotlin.random.Random

class RouletteGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roulette_game)

        val mImageView = findViewById<ImageView>(R.id.image_view_1)
        val mButton = findViewById<Button>(R.id.button_1)

        val animationSet = AnimationSet(true)

        val rotateAnimation = RotateAnimation(0f, 1080F, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        rotateAnimation.duration = 2000 // 2 seconds
        rotateAnimation.repeatCount = 0 // Repeat indefinitely
        rotateAnimation.interpolator = LinearInterpolator()

        animationSet.addAnimation(rotateAnimation)

        // When button is clicked
        mButton.setOnClickListener {

            var degrees : Float = -9.729729F  // 360 degrees of a circle divided by the 37 sections



            val result = (1..13).random()

            when(result) {
                1 -> { //32 red
                    mImageView.startAnimation(animationSet)
                    degrees *= 1
                    mImageView.rotation = degrees
                }
                2 -> { //15 black
                    mImageView.startAnimation(animationSet)
                    degrees *= 2
                    mImageView.rotation = degrees
                }
                3 -> { //19 red
                    mImageView.startAnimation(animationSet)
                    degrees *= 3
                    mImageView.rotation = degrees
                }
                4 -> { //4 black
                    mImageView.startAnimation(animationSet)
                    degrees *= 4
                    mImageView.rotation = degrees
                }
                5 -> { //21 red
                    mImageView.startAnimation(animationSet)
                    degrees *= 5
                    mImageView.rotation = degrees
                }
                6 -> { //2 black
                    mImageView.startAnimation(animationSet)
                    degrees *= 6
                    mImageView.rotation = degrees
                }
                7 -> { //25 red
                    mImageView.startAnimation(animationSet)
                    degrees *= 7
                    mImageView.rotation = degrees
                }
                8 -> { //17 black
                    mImageView.startAnimation(animationSet)
                    degrees *= 8
                    mImageView.rotation = degrees
                }
                9 -> { //34 red
                    mImageView.startAnimation(animationSet)
                    degrees *= 9
                    mImageView.rotation = degrees
                }
                10 -> { //6 black
                    mImageView.startAnimation(animationSet)
                    degrees *= 10
                    mImageView.rotation = degrees
                }
                11 -> { //27 red
                    mImageView.startAnimation(animationSet)
                    degrees *= 11
                    mImageView.rotation = degrees
                }
                12 -> { //13 black
                    mImageView.startAnimation(animationSet)
                    degrees *= 12
                    mImageView.rotation = degrees
                }
                13 -> { //36 red
                    mImageView.startAnimation(animationSet)
                    degrees *= 13
                    mImageView.rotation = degrees
                }
                14 -> { //11 black
                    degrees *= 14
                    mImageView.rotation = degrees
                }
                15 -> { //30 red
                    degrees *= 15
                    mImageView.rotation = degrees
                }
                16 -> { //8 black
                    degrees *= 16
                    mImageView.rotation = degrees
                }
                17 -> { //32 red
                    degrees *= 17
                    mImageView.rotation = degrees
                }
                18 -> { //10 black
                    degrees *= 18
                    mImageView.rotation = degrees
                }
                19 -> { //5 red
                    degrees *= 19
                    mImageView.rotation = degrees
                }
                20 -> { //24 black
                    degrees *= 20
                    mImageView.rotation = degrees
                }
                21 -> { //16 red
                    degrees *= 21
                    mImageView.rotation = degrees
                }
                22 -> { //33 black
                    degrees *= 22
                    mImageView.rotation = degrees
                }
                23 -> { //1 red
                    degrees *= 23
                    mImageView.rotation = degrees
                }
                24 -> { //20 black
                    degrees *= 24
                    mImageView.rotation = degrees
                }
                25 -> { //14 red
                    degrees *= 25
                    mImageView.rotation = degrees
                }
                26 -> { //31 black
                    degrees *= 26
                    mImageView.rotation = degrees
                }
                27 -> { //9 red
                    degrees *= 27
                    mImageView.rotation = degrees
                }
                28 -> { //22 black
                    degrees *= 28
                    mImageView.rotation = degrees
                }
                29 -> { //18 red
                    degrees *= 29
                    mImageView.rotation = degrees
                }
                30 -> { //29 black
                    degrees *= 30
                    mImageView.rotation = degrees
                }
                31 -> { //7 red
                    degrees *= 31
                    mImageView.rotation = degrees
                }
                32 -> { //28 black
                    degrees *= 32
                    mImageView.rotation = degrees
                }
                33 -> { //12 red
                    degrees *= 33
                    mImageView.rotation = degrees
                }
                34 -> { //35 black
                    degrees *= 34
                    mImageView.rotation = degrees
                }
                35 -> { //3 red
                    degrees *= 35
                    mImageView.rotation = degrees
                }
                36 -> { //26 black
                    degrees *= 36
                    mImageView.rotation = degrees
                }
                37 -> { //0 Green
                    degrees *= 37
                    mImageView.rotation = degrees
                }



                }
            }
        }
    }