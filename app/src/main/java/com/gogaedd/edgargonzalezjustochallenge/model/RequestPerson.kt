package com.gogaedd.edgargonzalezjustochallenge.model

import com.google.gson.annotations.SerializedName

data class RequestPerson(

    @SerializedName("results")
    var listPeople: MutableList<Person> =  mutableListOf(),
    @SerializedName("info")
    var infoRequest: InfoRequestPerson = InfoRequestPerson()

)
