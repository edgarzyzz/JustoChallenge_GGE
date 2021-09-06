package com.gogaedd.edgargonzalezjustochallenge.persistence.net

import com.gogaedd.edgargonzalezjustochallenge.infraestructure.ConstantsApp
import com.gogaedd.edgargonzalezjustochallenge.model.RequestPerson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetPerson() : NetHelper() {

    companion object {
        const val TAG = "NetPersonLog"
    }


    fun sendRequestSearchNewUser(nationality: String, gender: String) {

        val personCall = apiService.getPerson(nationality, gender)
        personCall.enqueue(object : Callback<RequestPerson> {
            override fun onResponse(
                call: Call<RequestPerson>,
                response: Response<RequestPerson>
            ) {
                if (response.isSuccessful) {
                    val requestPerson = response.body()
                    requestPerson?.let {

                        if (!it.listPeople.isNullOrEmpty()) {
                            it.listPeople[0]?.let { person ->
                                it.infoRequest.seed
                                mListener?.onResultOk(person, ConstantsApp.Net.GET_NEW_USER)

                            }

                            return
                        }

                    }

                }

                mListener?.onResultError("empty Data", ConstantsApp.Net.GET_NEW_USER)
            }

            override fun onFailure(call: Call<RequestPerson>, t: Throwable) {
                mListener?.onResultError(
                    t.message?.let {
                        it
                    } ?: run { "Error web service" }, ConstantsApp.Net.GET_NEW_USER
                )
            }
        })
    }

    fun sendRequestRandomPeople(
        nationality: String? = null,
        gender: String? = null,
    ) {

        val call: Call<RequestPerson> = getCallRandomPeople(nationality, gender)
        call.enqueue(object : Callback<RequestPerson> {
            override fun onResponse(call: Call<RequestPerson>, response: Response<RequestPerson>) {
                if (response.isSuccessful) {

                    response.body()?.let { responsePerson ->
                        if (!responsePerson.listPeople.isNullOrEmpty()) {
                            mListener?.onResultOk(
                                responsePerson.listPeople,
                                ConstantsApp.Net.GET_RANDOM_PEOPLE
                            )
                            return
                        }

                    }

                }

                mListener?.onResultError("Ws failed", ConstantsApp.Net.GET_RANDOM_PEOPLE)
            }

            override fun onFailure(call: Call<RequestPerson>, t: Throwable) {
                mListener?.onResultError("Ws failed", ConstantsApp.Net.GET_RANDOM_PEOPLE)
            }
        })

    }

    private fun getCallRandomPeople(nationality: String?, gender: String?): Call<RequestPerson> {
        return if (nationality == null) {
            if (gender == null) {

                apiService.getPeopleRandom()                                            //AllPeople
            } else {
                apiService.getPeopleRandomByGender(gender)                              //Only Gender
            }

        } else {
            if (gender == null) {
                apiService.getPeopleRandomByNationality(nationality)                    //Only Nat
            } else {
                apiService.getPeopleRandomByGenderAndNationality(
                    nationality,
                    gender
                )    //Nat and Gender
            }
        }
    }
}