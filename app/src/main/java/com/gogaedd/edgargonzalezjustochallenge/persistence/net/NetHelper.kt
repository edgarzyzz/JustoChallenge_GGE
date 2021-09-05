package com.gogaedd.edgargonzalezjustochallenge.persistence.net

import com.gogaedd.edgargonzalezjustochallenge.listener.NetHelperListener

open class NetHelper() {
    protected var apiService : ApiService
    var mListener: NetHelperListener?=null
    init {
        val retrofit = ApiClient.getRetrofit()
        apiService = retrofit.create(ApiService::class.java)
    }


    public fun setListener(listener:NetHelperListener){
        mListener = listener
    }
}