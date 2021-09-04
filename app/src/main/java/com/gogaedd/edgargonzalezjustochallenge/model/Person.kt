package com.gogaedd.edgargonzalezjustochallenge.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Person(
    @PrimaryKey
    val id : Int = 0,
    val name: String =""

)
