package com.gogaedd.edgargonzalezjustochallenge.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gogaedd.edgargonzalezjustochallenge.model.Friend
import com.gogaedd.edgargonzalezjustochallenge.model.Person
import com.gogaedd.edgargonzalezjustochallenge.persistence.db.converters_db.*


@Database(entities = arrayOf(Person::class,Friend::class), version = 1)
@TypeConverters(BirthdayConverter::class, LocationConverter::class,NameConverter::class,PictureConverter::class)
abstract class AppDatabase() : RoomDatabase() {
    abstract fun personDao(): PersonDao
    abstract fun friendDao(): FriendDao


    companion object {
        private var INSTANCE: AppDatabase? = null


        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java,"appDb.db")
                    .build()
            }
            return INSTANCE!!

        }
    }
}