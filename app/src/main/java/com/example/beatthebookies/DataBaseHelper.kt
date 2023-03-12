package com.example.beatthebookies

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

private val DataBaseName = "AppDataBase.db"
private val ver : Int = 1

class DataBaseHelper(context: Context) : SQLiteOpenHelper(context, DataBaseName,null, ver) {


    private val RUTable = "RegisteredUser"
    private val RUColumn_Id = "Id"
    private val RUColumn_Email = "Email"
    private val RUColumn_Password = "Password"
    private val RUColumn_Balance = "Balance"

    private val CFTABLE = "CoinFlip"
    private val CFRESULT = "Result"
    private val CFID = "Id"

    override fun onCreate(db: SQLiteDatabase?) {
        try {

            val sqlCreateStatementRegisteredUser: String =
                "CREATE TABLE " + RUTable + " ( " + RUColumn_Id +
                        " INTEGER PRIMARY KEY AUTOINCREMENT, " + RUColumn_Email + " TEXT NOT NULL, " +
                        RUColumn_Password + " TEXT NOT NULL, )"

            db?.execSQL(sqlCreateStatementRegisteredUser)

        } catch (e: SQLiteException) {}
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun getCFResults() : ArrayList<CoinFlipHistory> {

        val ResultsList = ArrayList<CoinFlipHistory>()
        val db: SQLiteDatabase = this.readableDatabase
        val sqlStatement = "SELECT * FROM $CFTABLE"

        val cursor : Cursor = db.rawQuery(sqlStatement,null)

            if(cursor.moveToFirst())
            do{
                val id : Int = cursor.getInt(0)
                val result : String = cursor.getString(1)

                val hstry = CoinFlipHistory(id,result)
                ResultsList.add(hstry)
            }while (cursor.moveToNext())

            cursor.close()
        db.close()

        return ResultsList
    }

    fun updateBalance(registeredUser: RegisteredUser):Int {

        val db: SQLiteDatabase = this.writableDatabase
        val cv: ContentValues = ContentValues()

        cv.put(RUColumn_Balance, registeredUser.Balance)

        val success = db.insert(RUTable, null, cv)

        db.close()
        if (success.toInt() == -1) return success.toInt()
        else return 1
    }


    fun addRegisteredUser(registeredUser: RegisteredUser): Int{

        val isloginNameAlreadyExists = checkEmail(registeredUser) // check if the username is already exist in the database
        if(isloginNameAlreadyExists < 0)
            return isloginNameAlreadyExists

        val db: SQLiteDatabase = this.writableDatabase
        val cv: ContentValues = ContentValues()

        cv.put(RUColumn_Email, registeredUser.email)
        cv.put(RUColumn_Password, registeredUser.PassWord)
        cv.put(RUColumn_Balance, registeredUser.Balance)

        val success = db.insert(RUTable, null, cv)

        db.close()
        if (success.toInt() == -1) return success.toInt()
        else return 1
    }

    fun addCoinFlipResult(coinFlipHistory: CoinFlipHistory) : Int{

        val db: SQLiteDatabase = this.writableDatabase
        val cv: ContentValues = ContentValues()

        cv.put(CFRESULT, coinFlipHistory.Result)

        val success = db.insert(CFTABLE, null, cv)

        db.close()
        if(success.toInt() == -1) return success.toInt()
        else return 1
    }

        private fun checkEmail(registeredUser: RegisteredUser): Int {

        val db: SQLiteDatabase
        try {
            db = this.readableDatabase
        }
        catch(e: SQLiteException) {
            return -2
        }

        val email = registeredUser.email

        val sqlStatement = "SELECT * FROM $RUTable WHERE $RUColumn_Email = ?"
        val param = arrayOf(email)
        val cursor: Cursor =  db.rawQuery(sqlStatement,param)

        if(cursor.moveToFirst()){
            // The user is found
            val n = cursor.getInt(0)
            cursor.close()
            db.close()
            return -3 // error the user name is already exist
        }

        cursor.close()
        db.close()
        return 0 //User not found
    }

    fun getRegisteredUser(registeredUser: RegisteredUser) : Int {

        val db: SQLiteDatabase
        try {
            db = this.readableDatabase
        }
        catch(e: SQLiteException) {
            return -2
        }

        val email = registeredUser.email.lowercase()
        val password = registeredUser.PassWord


        //val sqlStatement = "SELECT * FROM $TableName WHERE $Column_UserName = $userName AND $Column_Password = $userPassword"

        val sqlStatement = "SELECT * FROM $RUTable WHERE $RUColumn_Email = ? AND $RUColumn_Password = ?"

        val param = arrayOf(email,password)
        val cursor: Cursor =  db.rawQuery(sqlStatement,param)
        if(cursor.moveToFirst()){
            // The user is found
            val n = cursor.getInt(0)
            cursor.close()
            db.close()
            return n
        }

        cursor.close()
        db.close()
        return -1 //User not found
    }
}
