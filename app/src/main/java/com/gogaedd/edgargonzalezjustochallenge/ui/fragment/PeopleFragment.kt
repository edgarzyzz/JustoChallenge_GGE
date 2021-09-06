package com.gogaedd.edgargonzalezjustochallenge.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gogaedd.edgargonzalezjustochallenge.adapters.FriendAdapter
import com.gogaedd.edgargonzalezjustochallenge.adapters.NearPersonAdapter
import com.gogaedd.edgargonzalezjustochallenge.databinding.FragmentPeopleBinding
import com.gogaedd.edgargonzalezjustochallenge.listener.FriendListener
import com.gogaedd.edgargonzalezjustochallenge.listener.NearPersonListener
import com.gogaedd.edgargonzalezjustochallenge.model.Friend
import com.gogaedd.edgargonzalezjustochallenge.model.Person
import com.gogaedd.edgargonzalezjustochallenge.viewmodel.MainViewModel
import com.google.gson.Gson

class PeopleFragment : Fragment(), NearPersonListener,FriendListener {

    lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentPeopleBinding
    lateinit var adapterNearPeople: NearPersonAdapter
    lateinit var adapterFriends: FriendAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPeopleBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapterNearPeople = NearPersonAdapter()
        adapterNearPeople.setListener(this)


        adapterFriends = FriendAdapter()
        adapterFriends.setListener(this)


        binding.rvFriemdsFgmntp.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterFriends


        }

        binding.rvNearPeopleFgmntp.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterNearPeople
        }

        viewModel.loadFriends()
        viewModel.requestSearchPeople(null ,null)
    }

    override fun onShowDetailNearPerson(nearPerson: Person) {
        val action = PeopleFragmentDirections.actionPeopleFragmentToPersonDetailFragment(Gson().toJson(nearPerson))
        findNavController().navigate(action)
    }

    override fun onAddNearperson(nearPerson: Person) {
        viewModel.storeFriend(nearPerson)
    }

    override fun onDeleteFriend(friendToDelete: Friend) {
        viewModel.deleteFriend(friendToDelete)
    }

    override fun onShowDetailFriend(friend: Friend) {
        val person = Person(friend)
        val json = Gson().toJson(person)
        val action = PeopleFragmentDirections.actionPeopleFragmentToPersonDetailFragment(json)
        findNavController().navigate(action)
    }

}