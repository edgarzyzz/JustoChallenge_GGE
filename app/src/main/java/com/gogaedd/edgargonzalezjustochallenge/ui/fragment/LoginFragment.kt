package com.gogaedd.edgargonzalezjustochallenge.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gogaedd.edgargonzalezjustochallenge.adapters.UserAdapter
import com.gogaedd.edgargonzalezjustochallenge.databinding.FragmentLoginBinding
import com.gogaedd.edgargonzalezjustochallenge.listener.UserRegsitreredListener
import com.gogaedd.edgargonzalezjustochallenge.model.Person
import com.gogaedd.edgargonzalezjustochallenge.viewmodel.MainViewModel


class LoginFragment : Fragment(),UserRegsitreredListener {

    lateinit var viewModel : MainViewModel
    lateinit var binding: FragmentLoginBinding
    lateinit var adapterUsers: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner=this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCreateUsertFgmntl.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToCreateUserFragment()
            findNavController().navigate(action)
        }

        binding.rvUsersRegistreredtFgmntl.apply {
            adapterUsers = UserAdapter()
            adapter = adapterUsers

            layoutManager = LinearLayoutManager(requireContext())
        }
        adapterUsers.setListener(LoginFragment@this)


    }


    override fun onUserSelected(user: Person) {
        val action = LoginFragmentDirections.actionLoginFragmentToPeopleFragment()
        findNavController().navigate(action)
    }

}