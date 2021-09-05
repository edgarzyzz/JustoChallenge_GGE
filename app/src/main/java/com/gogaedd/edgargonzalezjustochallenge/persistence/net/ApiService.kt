package com.gogaedd.edgargonzalezjustochallenge.persistence.net

import com.gogaedd.edgargonzalezjustochallenge.model.InfoRequestPerson
import com.gogaedd.edgargonzalezjustochallenge.model.Person
import com.gogaedd.edgargonzalezjustochallenge.model.RequestPerson
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

//create user
    @GET("/api/")
    fun getPerson(
        @Query("nat") nationality: String,
        @Query("gender") gender: String
    ): Call<RequestPerson>

//
//    fun getFriendsBySeed(
//        @Query("seed") seed: String,
//        @Query("results") results: String = "50"
//    ): Call<RequestPerson>




//    random 50 people
    @GET("/api/")
    fun getPeopleRandom(
        @Query("results") results: String = "50"
    ): Call<RequestPerson>

    @GET("/api/")
    fun getPeopleRandomByGender(
        @Query("gender") gender: String,
        @Query("results") results: String = "50"
    ): Call<RequestPerson>



    @GET("/api/")
    fun getPeopleRandomByNationality(
        @Query("nat") nationality: String,
        @Query("results") results: String = "50"
    ): Call<RequestPerson>

    @GET("/api/")
    fun getPeopleRandomByGenderAndNationality(
        @Query("nat") nationality: String,
        @Query("gender") gender: String,
        @Query("results") results: String = "50"
    ): Call<RequestPerson>



}