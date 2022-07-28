package com.example.workout_app

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SqlLiteOpenHelper(context: Context, factory: SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context, DATABASE_NAME,factory, DATABASE_VERSION){

    companion object{
        private val DATABASE_VERSION=1
        private val DATABASE_NAME="workoutapp.db"
        private val TABLE_HISTORY="HISTORY"
        private val COLUMN_ID="_id"
        private val COLUMN_COMPLETED_DATE="completed_date"
    }

    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_EXERCISE_TABLE=("CREATE TABLE " + TABLE_HISTORY+"("+
                COLUMN_ID+" INTEGER PRIMARY KEY,"+
                COLUMN_COMPLETED_DATE+" TEXT)")
        db?.execSQL(CREATE_EXERCISE_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS"+ TABLE_HISTORY)
        onCreate(db)


    }

    fun addDate(date:String){

        val values=ContentValues()
        values.put(COLUMN_COMPLETED_DATE,date)
        val db=this.writableDatabase
        db.insert(TABLE_HISTORY,null,values)
        db.close()
    }

    fun getAllDates():ArrayList<String>{

        val list=ArrayList<String>()
        val db=this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_HISTORY",null)
        while(cursor.moveToNext()){
            val dateValue= cursor.getString(
                cursor.getColumnIndexOrThrow(COLUMN_COMPLETED_DATE))

            list.add(dateValue)

        }
        cursor.close()
        return list

    }


}