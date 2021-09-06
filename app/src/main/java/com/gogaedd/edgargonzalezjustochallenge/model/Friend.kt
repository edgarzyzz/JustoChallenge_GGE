package com.gogaedd.edgargonzalezjustochallenge.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.gogaedd.edgargonzalezjustochallenge.persistence.db.converters_db.BirthdayConverter
import com.gogaedd.edgargonzalezjustochallenge.persistence.db.converters_db.LocationConverter
import com.gogaedd.edgargonzalezjustochallenge.persistence.db.converters_db.NameConverter

@Entity
data class Friend (
    @PrimaryKey
    val email: String = "",

    val emailMainUserFriend:String="",

    val gender: String = "",


    @TypeConverters(NameConverter::class)
    val name: Name = Name(),


    @TypeConverters(LocationConverter::class)
    val location: Location = Location(),


//    val login: String =String(),

    @TypeConverters(BirthdayConverter::class)
    val dob: Birthday = Birthday(),
    //    val registered: String =String(),
    val phone: String = "",
    val cell: String = "",
//    val id: String =String(),

    @TypeConverters(Picture::class)
    val picture: Picture = Picture(),
    val nat: String = "",

    var seed: String = ""
) {
    constructor(person: Person, emailCurrentUser:String) : this(
        person.email,
        emailCurrentUser,
        person.gender,
        person.name ,
        person.location ,
        person.dob ,
        person.phone ,
        person.cell ,
        person.picture ,
        person.nat ,
        person.seed



    )
}