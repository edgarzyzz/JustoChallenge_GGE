package com.gogaedd.edgargonzalezjustochallenge.persistence.net

import com.gogaedd.edgargonzalezjustochallenge.model.Person
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("a")
    fun getPerson(@Query("limit") limit:String): Call<Person>
//    suspend fun getPokemonContainer(@Query("limit") limit:String): Response<PokemonContainer>
}