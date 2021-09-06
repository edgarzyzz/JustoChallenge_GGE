package com.gogaedd.edgargonzalezjustochallenge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.gogaedd.edgargonzalezjustochallenge.model.Friend
import com.gogaedd.edgargonzalezjustochallenge.repository.MainRepository
import com.gogaedd.edgargonzalezjustochallenge.model.Person

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val repository: MainRepository by lazy { MainRepository(application) }


    val lvdUsers = repository.getLvdUsers()
    val lvdFriends =repository.getLvdFriends()
    val lvdRandomPeople =repository.getLvdRandomPoeple()
    val lvdCurrentUser =repository.getLvdCurrentUser()

//    WS
//    WS
//    WS
//    WS
//    WS
//    WS
    /**
     * obtiene un usuario de WS y lo guardara como usuario
     */
    fun requestgetNewUser(nationality: String, gender: String){
        repository.requestGetNewUser(nationality,gender)
    }


    /**
     * obtiene 50 usuarios para poderlos agregar
     */
    fun requestSearchPeople(nationality: String?, gender: String?){
        repository.requestRandomPeople(nationality,gender)
    }




//    db
//    db
//    db
//    db
//    db
//    db
//    db
//    db
//    db
//    db
    fun getUserByEmail(email:String){
        repository.getUserByEmail(email)
    }


//  db
    fun getAllUsersInDevice(){
        repository.getAllUsersRegistrered()
    }



    fun deleteUser(person: Person){
        repository.deleteUser(person)
    }

    fun storeFriend(nearPerson: Person) {
        repository.createFriend(nearPerson)
    }

    fun loadFriends() {
        repository.loadFriendsCurrentUser()
    }

    fun selectCurrentUser(user: Person) {
        repository.selectCurrentUser(user)
    }

    fun deleteFriend(friendToDelete: Friend) {
        repository.deleteFriend(friendToDelete)
    }


    /*
    ConstantsApp.Nationalities.AUSTRALIAN,
            ConstantsApp.Gender.MALE
     */

}
