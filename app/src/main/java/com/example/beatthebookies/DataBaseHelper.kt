package com.example.beatthebookies

import android.app.DownloadManager.COLUMN_ID
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Color
import java.sql.Connection
import java.time.temporal.TemporalAmount

private val DataBaseName = "AppDataBase.db"
private val ver : Int = 1

class DataBaseHelper(context: Context) : SQLiteOpenHelper(context, DataBaseName,null, ver) {


    private val RUTable = "RegisteredUser"
    private val RUColumn_Id = "Id"
    private val RUColumn_Email = "Email"
    private val RUColumn_Password = "Password"
    private val RUColumn_Balance = "Balance"

    private val LITable = "LoggedInUser"
    private val LIID = "Id"
    private val LIEMAIL = "Email"
    private val LIPASSWORD = "Password"
    private val LIBALANCE = "Balance"

    private val CFTABLE = "CoinFlip"
    private val CFRESULT = "Result"
    private val CFID = "Id"

    private val ROULETTE_TABLE = "RouletteResults"
    private val ROULETTE_ID = "Id"
    private val ROULETTE_RESULT = "Result"
    private val ROULETTE_COLOUR = "Colour"

    private val BetAmount_Table ="BetAmount"
    private val BetAmount_Id = "Id"
    private val BetAmount_Amount = "Amount"
    private val BetAmount_TempAmount = "TempAmount"

    private val Last10_Table ="Last10"
    private val Last10_Id = "Id"
    private val Last10_Colour = "Colour"
    private val Last10_Number = "Number"

    private val Streak_table = "Streaks"
    private val Streak_Id = "Id"
    private val Streak_Name = "Name"
    private val Streak_Counter = "Counter"

    override fun onCreate(db: SQLiteDatabase?) {
        try {

            val sqlCreateStatementRegisteredUser: String =
                "CREATE TABLE " + RUTable + " ( " + RUColumn_Id +
                        " INTEGER PRIMARY KEY AUTOINCREMENT, " + RUColumn_Email + " TEXT NOT NULL, " +
                        RUColumn_Password + " TEXT NOT NULL, )"

            db?.execSQL(sqlCreateStatementRegisteredUser)

        } catch (e: SQLiteException) {
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }



    fun getBalance(): Int {
        var balance = 0
        val db = readableDatabase
        val sqlStatement = "SELECT $LIBALANCE FROM $LITable"
        val cursor = db.rawQuery(sqlStatement, null)
        if (cursor.moveToFirst()) {
            balance = cursor.getInt(0)
        }
        cursor.close()
        db.close()
        return balance
    }


    fun updateEmailAndPassword(email : String, password : String) {

        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put("Email", email)
        cv.put("Password",password)

        db.update("LoggedInUser", cv, null, null)
    }

    fun updateBalanceBetAmount(id: Int, amount: Int) {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put("Amount", amount)
        val selection = "Id = ?"
        val selectionArgs = arrayOf(id.toString())
        db.update("BetAmount", cv, selection, selectionArgs)
    }



    fun getBetAmountSum(): Int {
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT SUM(Amount) FROM BetAmount", null)
        var sum = 0
        if (cursor.moveToFirst()) {
            sum = cursor.getInt(0)
        }
        cursor.close()
        return sum
    }

    fun getBetAmount(id: Int): Int? {
        val db = readableDatabase
        val query = "SELECT Amount FROM BetAmount WHERE Id = ?"
        val cursor = db.rawQuery(query, arrayOf(id.toString()))

        var amount: Int? = null
        if (cursor.moveToFirst()) {
            val amountIndex = cursor.getColumnIndex("Amount")
            if (amountIndex >= 0) {
                amount = cursor.getInt(amountIndex)
            }
        }

        cursor.close()
        db.close()
        return amount
    }

    fun updateTempBetAmount(id: Int, amount: Int) {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put("TempAmount", amount)
        val selection = "Id = ?"
        val selectionArgs = arrayOf(id.toString())
        db.update("BetAmount", cv, selection, selectionArgs)
    }

    fun getTempBetAmount(id: Int): Int? {
        val db = readableDatabase
        val query = "SELECT TempAmount FROM BetAmount WHERE Id = ?"
        val cursor = db.rawQuery(query, arrayOf(id.toString()))

        var amount: Int? = 0
        if (cursor.moveToFirst()) {
            val amountIndex = cursor.getColumnIndex("TempAmount")
            if (amountIndex >= 0) {
                amount = cursor.getInt(amountIndex)
            }
        }

        cursor.close()
        db.close()
        return amount
    }

    fun updateBalance(balance : Int) {

        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put("Balance", balance)

        db.update("LoggedInUser", cv, null, null)
    }

    fun updateId(Id : Int) {

        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put("Id", Id)

        db.update("LoggedInUser", cv, null, null)
    }

    fun getLoggedInId(): Int {
        var Id = 0
        val db = readableDatabase
        val sqlStatement = "SELECT $LIID FROM $LITable"
        val cursor = db.rawQuery(sqlStatement, null)
        if (cursor.moveToFirst()) {
            Id = cursor.getInt(0)
        }
        cursor.close()
        db.close()
        return Id
    }

    fun getUserIdByEmailAndPassword(email: String, password: String): Int? {

        val queryString = "SELECT $RUColumn_Id FROM $RUTable WHERE $RUColumn_Email = ? AND $RUColumn_Password = ?"
        val db = readableDatabase
        val cursor = db.rawQuery(queryString, arrayOf(email, password))

        val userId: Int? = if (cursor.moveToFirst()) {
            cursor.getInt(0)
        } else {
            null
        }
        cursor.close()
        db.close()
        return userId
    }

    fun getLoggedInUserBalance(email: String, password: String): Int? {

        val queryString = "SELECT $RUColumn_Balance FROM $RUTable WHERE $RUColumn_Email = ? AND $RUColumn_Password = ?"
        val db = readableDatabase
        val cursor = db.rawQuery(queryString, arrayOf(email, password))

        val Balance: Int? = if (cursor.moveToFirst()) {
            cursor.getInt(0)
        } else {
            null
        }
        cursor.close()
        db.close()
        return Balance
    }

    fun transferbalancewhereId() {

        val db = writableDatabase

        val cursor = db.rawQuery("SELECT Id, Balance FROM LoggedInUser", null)

        while (cursor.moveToNext()) {
            val id = cursor.getInt(0)
            val balance = cursor.getInt(1)

            db.execSQL("UPDATE RegisteredUser SET Balance = ? WHERE Id = ?", arrayOf(balance, id))
        }

        cursor.close()
        db.close()
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

    fun addRouletteResult(rouletteResults: RouletteResults) : Int{

        val db: SQLiteDatabase = this.writableDatabase
        val cv: ContentValues = ContentValues()

        cv.put(ROULETTE_RESULT, rouletteResults.Result)
        cv.put(ROULETTE_COLOUR, rouletteResults.Colour)

        val success = db.insert(ROULETTE_TABLE, null, cv)

        db.close()
        if(success.toInt() == -1) return success.toInt()
        else return 1
    }


    private fun checkEmail(registeredUser: RegisteredUser): Int{

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

    fun getCFResults(): ArrayList<CoinFlipHistory> {

        val ResultsList = ArrayList<CoinFlipHistory>()
        val db: SQLiteDatabase = this.readableDatabase
        val sqlStatement = "SELECT * FROM $CFTABLE"

        val cursor: Cursor = db.rawQuery(sqlStatement, null)

        if (cursor.moveToFirst())
            do {
                val id: Int = cursor.getInt(0)
                val result: String = cursor.getString(1)

                val hstry = CoinFlipHistory(id, result)
                ResultsList.add(hstry)
            } while (cursor.moveToNext())

        cursor.close()
        db.close()

        return ResultsList
    }

    fun getRouletteResults(): ArrayList<RouletteResults> {

        val ResultsList = ArrayList<RouletteResults>()
        val db: SQLiteDatabase = this.readableDatabase
        val sqlStatement = "SELECT * FROM $ROULETTE_TABLE"

        val cursor: Cursor = db.rawQuery(sqlStatement, null)

        if (cursor.moveToFirst())
            do {
                val Id: Int = cursor.getInt(0)
                val result: String = cursor.getString(1)
                val colour: String = cursor.getString(2)

                val hstry = RouletteResults(Id, result, colour)
                ResultsList.add(hstry)
            } while (cursor.moveToNext())

        cursor.close()
        db.close()

        return ResultsList
    }



    fun updateColourNumberWhereId(Color: String, Number: Int, Id: Int) {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put("Color",Color)
        cv.put("Number",Number)

        val selection = "Id = ?"
        val selectionArgs = arrayOf(Id.toString())
        db.update("Last10", cv, null, null)
    }

    fun getColorById(id: Int): String? {
        val db = this.readableDatabase
        val cursor: Cursor? = db.query(
            Last10_Table, arrayOf(Last10_Colour),
            "$COLUMN_ID=?", arrayOf(id.toString()),
            null, null, null
        )

        var color: String? = null

        cursor?.use {
            if (cursor.moveToFirst()) {
                color = cursor.getString(1)
            }
        }
        return color
    }

    fun getNumberById(id: Int): Int? {
        val db = this.readableDatabase
        val cursor: Cursor? = db.query(
            Last10_Table, arrayOf(Last10_Number),
            "$COLUMN_ID=?", arrayOf(id.toString()),
            null, null, null
        )

        var number: Int? = null

        cursor?.use {
            if (cursor.moveToFirst()) {
                number = cursor.getInt(2)
            }
        }
        return number
    }

    fun getStreak(id: Int): Int? {
        val db = this.readableDatabase
        val cursor: Cursor? = db.query(
            Streak_table, arrayOf(Streak_Counter),
            "$COLUMN_ID=?", arrayOf(id.toString()),
            null, null, null
        )

        var number: Int? = null

        cursor?.use {
            if (cursor.moveToFirst()) {
                number = cursor.getInt(2)
            }
        }
        return number
    }

    fun getStreaksById(id: Int): Int {
        val query = "SELECT Counter FROM Streaks WHERE Id = ?"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query, arrayOf(id.toString()))
        val streak = if (cursor.moveToFirst()) cursor.getInt(0) else 0
        cursor.close()
        db.close()
        return streak
    }


    fun updateCounter(id: Int, Counter: Int) {
        val db = this.writableDatabase
        val cv = ContentValues()

        cv.put("Counter", Counter)
        val selection = "Id = ?"
        val selectionArgs = arrayOf(id.toString())
        db.update("Streaks", cv, selection, selectionArgs)
    }

    fun resetStreaks(vararg keepIds: Int) {
        val keepIdsStr = keepIds.joinToString { it.toString() }
        val query = "UPDATE Streaks SET Counter = 0 WHERE Id NOT IN ($keepIdsStr)"
        val db = this.writableDatabase
        db.execSQL(query)
        db.close()
    }




}
