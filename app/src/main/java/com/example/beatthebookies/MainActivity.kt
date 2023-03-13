package com.example.beatthebookies

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

        fun CreateAccountBtn(view : View){
            val intent = Intent(this, CreateAccount::class.java)
            startActivity(intent)
    }

    fun continueasguestbtn(view: View){
        val intent = Intent(this, GuestHome::class.java)
        startActivity(intent)
    }

    fun loginButton(view: View) {

        val messagE = findViewById<TextView>(R.id.textViewMessage)
        val emaiL = findViewById<EditText>(R.id.editTextEmail).text.toString()
        val passworD = findViewById<EditText>(R.id.editTextPassword).text.toString()





        if(emaiL.isEmpty() || passworD.isEmpty())
            Toast.makeText(this,"Please insert Username and Password",Toast.LENGTH_LONG).show()
        else {
            val myDataBase = DataBaseHelper(this)
            val result = myDataBase.getRegisteredUser(RegisteredUser(-1, emaiL, passworD,-1))
            if( result == -1)
                messagE.text = "User Not Found, Please try again"
            else if( result == -2)
                messagE.text = "Error Cannot Open DataBase"
            else {
                messagE.text = "You logged in successfully"
                val intent = Intent(this, HomeScreen::class.java)
                startActivity(intent)
            }
        }
    }
}