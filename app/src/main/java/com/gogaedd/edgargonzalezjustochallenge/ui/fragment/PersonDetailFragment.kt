package com.gogaedd.edgargonzalezjustochallenge.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.gogaedd.edgargonzalezjustochallenge.R
import com.gogaedd.edgargonzalezjustochallenge.databinding.FragmentPeopleBinding
import com.gogaedd.edgargonzalezjustochallenge.databinding.FragmentPersonDetailBinding
import com.gogaedd.edgargonzalezjustochallenge.viewmodel.MainViewModel


class PersonDetailFragment : Fragment() {
    lateinit var viewmodel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPersonDetailBinding.inflate(inflater,container,false)
        viewmodel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        binding.viewModel = viewmodel
        binding.lifecycleOwner = this



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





    }


}