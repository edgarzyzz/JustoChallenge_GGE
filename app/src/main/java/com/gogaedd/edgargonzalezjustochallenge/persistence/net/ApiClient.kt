package com.gogaedd.edgargonzalezjustochallenge.persistence.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        private var retrofitInstance: Retrofit? = null
        fun getRetrofit(): Retrofit {
            if (retrofitInstance == null) {
                retrofitInstance = Retrofit.Builder()
                    .baseUrl("https://person.co/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofitInstance!!
        }
    }


}