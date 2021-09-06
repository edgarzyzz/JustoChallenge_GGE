package com.gogaedd.edgargonzalezjustochallenge.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.gogaedd.edgargonzalezjustochallenge.R
import com.gogaedd.edgargonzalezjustochallenge.databinding.FragmentPeopleBinding
import com.gogaedd.edgargonzalezjustochallenge.databinding.FragmentPersonDetailBinding
import com.gogaedd.edgargonzalezjustochallenge.model.Friend
import com.gogaedd.edgargonzalezjustochallenge.model.Person
import com.gogaedd.edgargonzalezjustochallenge.viewmodel.MainViewModel
import com.google.gson.Gson


class PersonDetailFragment : Fragment() {
    private val args : PersonDetailFragmentArgs by navArgs()
    lateinit var binding: FragmentPersonDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonDetailBinding.inflate(inflater,container,false)

        binding.lifecycleOwner = this



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val json = args.personToShow
        val person = Gson().fromJson(json, Person::class.java)
        binding.person =person



    }


}