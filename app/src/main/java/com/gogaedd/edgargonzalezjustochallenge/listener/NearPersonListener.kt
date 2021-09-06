package com.gogaedd.edgargonzalezjustochallenge.listener

import android.app.Person

interface NearPersonListener {

    fun onShowDetailNearPerson(nearPerson: Person)
    fun onAddNearperson(nearPerson: Person)
}