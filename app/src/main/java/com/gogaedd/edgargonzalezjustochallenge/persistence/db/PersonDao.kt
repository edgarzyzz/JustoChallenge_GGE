package com.gogaedd.edgargonzalezjustochallenge.persistence.db

import androidx.room.*
import com.gogaedd.edgargonzalezjustochallenge.model.Person


@Dao
interface PersonDao {


    @Insert
    fun insertAll(vararg  people: Person)


    @Insert(onConflict = OnConflictStrategy.IGNORE )
    fun insert(person: Person)

    @Query("Select * From Person where email = :email")
    fun getUserByEmail(email:String): Person

    @Query("Select * From Person")
    fun getAll() : MutableList<Person >

    @Delete
    fun deleteUser(person:Person)




}