package com.gogaedd.edgargonzalezjustochallenge.persistence.db.converters_db

import androidx.room.TypeConverter
import com.gogaedd.edgargonzalezjustochallenge.model.Birthday
import com.google.gson.Gson

class BirthdayConverter {
    val gson : Gson by lazy { Gson() }


    @TypeConverter
    fun birthdayObjectToJson(birthday: Birthday):String{
        return try {
            gson.toJson(birthday, Birthday::class.java)
        } catch (e: Exception) {
            ""
        }

    }

    @TypeConverter
    fun jsonToBirthdayObject(json:String):Birthday{
        return try {
            gson.fromJson(json, Birthday::class.java)
        } catch (e: Exception) {
            Birthday()
        }


    }
}