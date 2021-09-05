package com.gogaedd.edgargonzalezjustochallenge.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gogaedd.edgargonzalezjustochallenge.R
import com.gogaedd.edgargonzalezjustochallenge.model.Person
import com.gogaedd.edgargonzalezjustochallenge.viewmodel.MainViewModel


class SplashFragment : Fragment() {
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        viewModel.lvdUsers.observe(viewLifecycleOwner, observerUsers)
        viewModel.getAllUsersInDevice()


    }

    val observerUsers = Observer<MutableList<Person>>() {

        val action =
            SplashFragmentDirections.actionSplashFragmentToLoginFragment()

        findNavController().navigate(action)
    }


}