package com.gogaedd.edgargonzalezjustochallenge.utils

import android.content.Context
import android.widget.Toast

fun Context.showToast(message:String){
    Toast.makeText(this, message,Toast.LENGTH_LONG).show()


}