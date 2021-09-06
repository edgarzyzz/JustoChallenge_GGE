package com.gogaedd.edgargonzalezjustochallenge.listener

import com.gogaedd.edgargonzalezjustochallenge.model.Person


interface NearPersonListener {

    fun onShowDetailNearPerson(nearPerson: Person)
    fun onAddNearperson(nearPerson: Person)
}