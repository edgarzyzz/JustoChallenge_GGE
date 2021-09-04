package com.gogaedd.edgargonzalezjustochallenge.persistence.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gogaedd.edgargonzalezjustochallenge.model.Person


@Dao
interface PersonDao {


    @Query("Select * From Person")
    fun getAll() : MutableList<Person >


    @Insert
    fun insertAll(vararg  pokemons: Person)

    @Insert(onConflict = OnConflictStrategy.IGNORE )
    fun insert(pokemons: Person)




}