package com.example.beatthebookies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CreateAccount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
    }
    fun CreateNewUser(view: View){

        val email = findViewById<EditText>(R.id.editTextEmail).text.toString()
        val password = findViewById<EditText>(R.id.editTextPassword).text.toString()
        val message = findViewById<TextView>(R.id.Messagetxt)
        val balance = 1000

        val newUser = RegisteredUser(-1,email,password, balance)

        val mydatabase = DataBaseHelper(this)
        val result = mydatabase.addRegisteredUser(newUser)


        when(result) {
            1 ->  {
                message.text = "Your details has been add to the database successfully"
                findViewById<Button>(R.id.CreateAccountBtn).isEnabled = false
            }
            -1 -> message.text = "Error on creating new account"
            -2 -> message.text = "Error can not open database"
            -3 -> message.text = "User name is already in use"
        }
    }
}


