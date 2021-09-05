package com.gogaedd.edgargonzalezjustochallenge.persistence.db.converters_db

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.gogaedd.edgargonzalezjustochallenge.model.Location
import com.google.gson.Gson

class LocationConverter {
    val gson : Gson by lazy {
        Gson()
    }

    @TypeConverter
    fun locationObjectToJson(location: Location):String{
        return try {
            gson.toJson(location, Location::class.java)
        } catch (e: Exception) {
            ""
        }

    }


    @TypeConverter
    fun jsonToLocationObject(json:String): Location{
        return try {
            gson.fromJson(json, Location::class.java)
        } catch (e: Exception) {
            Location()
        }
    }
}