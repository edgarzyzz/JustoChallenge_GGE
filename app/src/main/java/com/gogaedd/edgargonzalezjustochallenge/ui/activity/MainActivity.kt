package com.gogaedd.edgargonzalezjustochallenge.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.gogaedd.edgargonzalezjustochallenge.R
import com.gogaedd.edgargonzalezjustochallenge.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewmodel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewmodel =ViewModelProvider(this).get(MainViewModel::class.java)




    }


}