package com.gogaedd.edgargonzalezjustochallenge.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.gogaedd.edgargonzalezjustochallenge.infraestructure.ConstantsApp
import com.gogaedd.edgargonzalezjustochallenge.listener.NetHelperListener
import com.gogaedd.edgargonzalezjustochallenge.model.Person
import com.gogaedd.edgargonzalezjustochallenge.persistence.db.AppDatabase
import com.gogaedd.edgargonzalezjustochallenge.persistence.net.NetPerson
import com.gogaedd.edgargonzalezjustochallenge.utils.showToast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class MainRepository(val application: Application) : NetHelperListener {
    companion object {
        const val TAG = "MainRepository"
    }

    private val netPerson: NetPerson = NetPerson()
    private val db = AppDatabase.getDatabase(application)

    private val personDao = db.personDao()
    private val friendDao = db.friendDao()


    init {
        netPerson.setListener(this)
    }


    private val lvdUsers = MutableLiveData<MutableList<Person>>(mutableListOf())
    private val lvdFriends = MutableLiveData<MutableList<Person>>(mutableListOf())
    private val lvdRandomPeople = MutableLiveData<MutableList<Person>>(mutableListOf())
    private val lvdCurrentUser = MutableLiveData<Person>()


    //DB
    fun getLvdUsers(): MutableLiveData<MutableList<Person>> {
        return lvdUsers
    }

    //DB
    fun getLvdFriends(): MutableLiveData<MutableList<Person>> {
        return lvdFriends
    }

    //WS
    fun getLvdRandomPoeple(): MutableLiveData<MutableList<Person>> {
        return lvdRandomPeople
    }

    //WS
    fun getLvdCurrentUser(): MutableLiveData<Person> {
        return lvdCurrentUser
    }


    //DB methods
    fun getUserByEmail(email: String) {
        runBlocking(Dispatchers.IO) {
            val userByEmail = personDao.getUserByEmail(email)
            lvdCurrentUser.postValue(userByEmail)
        }
    }

    fun getAllUsersRegistrered() {
        runBlocking(Dispatchers.IO) {
            val users = personDao.getAll()
            lvdUsers.postValue(personDao.getAll())
        }
    }

    fun deleteUser(person: Person) {
        runBlocking(Dispatchers.IO) {

            personDao.deleteUser(person)
        }
    }
    fun storeNewUser(person: Person){
        runBlocking(Dispatchers.IO) {
            personDao.insert(person)
        }
    }



//Ws methos
    /**
     * llamada a ws y recibe solo un usuario
     */
    fun requestGetNewUser(nationality: String, gender: String) {
        netPerson.sendRequestSearchNewUser(
            nationality, gender
        )

    }

    fun requestRandomPeople(nationality: String?, gender: String?) {
        netPerson.sendRequestRandomPeople(nationality, gender)
    }


    override fun onResultOk(any: Any, code: Int) {
        Log.d(TAG, "onResultOk: ")
        if (code == ConstantsApp.NetPerson.GET_NEW_USER) {
            if (any is Person) {
                lvdCurrentUser.value = any
                storeNewUser(any)
            }else{
                onResultError("error al parsear new user",code)
            }
        } else if (any is List<*>) {
            val mutableList = any as MutableList<Person>

        }
    }

    override fun onResultError(meesageError: String, code: Int) {
        if (code == ConstantsApp.NetPerson.GET_NEW_USER) {
            application.showToast(meesageError)
        }
    }


}