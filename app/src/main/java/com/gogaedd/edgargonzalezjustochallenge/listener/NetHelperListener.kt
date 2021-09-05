package com.gogaedd.edgargonzalezjustochallenge.listener

interface NetHelperListener {
    fun onResultOk(any:Any, code: Int)
    fun onResultError(meesageError:String, code: Int)
}