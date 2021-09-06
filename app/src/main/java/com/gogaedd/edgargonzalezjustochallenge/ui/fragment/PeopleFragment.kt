package com.gogaedd.edgargonzalezjustochallenge.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gogaedd.edgargonzalezjustochallenge.R
import com.gogaedd.edgargonzalezjustochallenge.databinding.FragmentPeopleBinding
import com.gogaedd.edgargonzalezjustochallenge.databinding.FragmentPersonDetailBinding
import com.gogaedd.edgargonzalezjustochallenge.viewmodel.MainViewModel

class PeopleFragment : Fragment() {

    lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentPeopleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPeopleBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvFriemdsFgmntp.apply {
            layoutManager = LinearLayoutManager(requireContext())

        }

        binding.rvNearPeopleFgmntp.apply {
            layoutManager = LinearLayoutManager(requireContext())
        }


    }

}