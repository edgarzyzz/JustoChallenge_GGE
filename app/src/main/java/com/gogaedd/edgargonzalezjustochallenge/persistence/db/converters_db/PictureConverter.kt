package com.gogaedd.edgargonzalezjustochallenge.persistence.db.converters_db

import androidx.room.TypeConverter
import com.gogaedd.edgargonzalezjustochallenge.model.Picture
import com.google.gson.Gson

class PictureConverter {

    val gson : Gson by lazy { Gson() }

    @TypeConverter
    fun jsonToPictureObject(json:String):Picture{
        return try {
            gson.fromJson(json, Picture::class.java)
        } catch (e: Exception) {
            Picture()
        }
    }


    @TypeConverter
    fun pictureObjectToJson(picture: Picture): String{
        return try {
            gson.toJson(picture,Picture::class.java)
        } catch (e: Exception) {
            ""
        }
    }



}