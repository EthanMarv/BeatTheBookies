package com.example.beatthebookies

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        val myDataBase = DataBaseHelper(this)

        val updateemail = myDataBase.updateEmailAndPassword("Guest","Guest")
        val updatebalance = myDataBase.updateBalance(0)
        val updateId = myDataBase.updateId(999)


        val intent = Intent(this, HomeScreen::class.java)
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

            val id = myDataBase.getUserIdByEmailAndPassword(emaiL,passworD)
            val balance = myDataBase.getLoggedInUserBalance(emaiL,passworD)

            val updateemail = myDataBase.updateEmailAndPassword(emaiL,passworD)
            val updatebalance = balance?.let { myDataBase.updateBalance(it) }
            val updateId = id?.let { myDataBase.updateId(it) }



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