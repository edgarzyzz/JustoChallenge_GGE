package com.gogaedd.edgargonzalezjustochallenge.persistence.db.converters_db

import androidx.room.TypeConverter
import com.gogaedd.edgargonzalezjustochallenge.model.Name
import com.google.gson.Gson

class NameConverter {
    val gson :Gson by lazy { Gson() }

    @TypeConverter
    fun jsonToNameObject(json:String):Name{
        return try {
            gson.fromJson(json, Name::class.java)
        } catch (e: Exception) {
            Name()
        }

    }

    @TypeConverter
    fun nameObjectToJson(name:Name):String{
        return gson.toJson(name)
    }
}