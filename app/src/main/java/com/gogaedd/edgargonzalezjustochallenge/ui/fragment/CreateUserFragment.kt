package com.gogaedd.edgargonzalezjustochallenge.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gogaedd.edgargonzalezjustochallenge.databinding.FragmentCreateUserBinding
import com.gogaedd.edgargonzalezjustochallenge.infraestructure.ConstantsApp
import com.gogaedd.edgargonzalezjustochallenge.model.Person
import com.gogaedd.edgargonzalezjustochallenge.utils.showToast
import com.gogaedd.edgargonzalezjustochallenge.viewmodel.MainViewModel


class CreateUserFragment : Fragment() {
    lateinit var viewModel: MainViewModel
    lateinit var binding : FragmentCreateUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        binding = FragmentCreateUserBinding.inflate(inflater, container,false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCreateFgmntcu.setOnClickListener{
            val nat = getIdRb(binding.rgNatFgmntcu.checkedRadioButtonId)
            val gender = getIdRb(binding.rgGenderFgmntcu.checkedRadioButtonId)

            if (!gender.isNullOrEmpty() && !nat.isNullOrEmpty()){
                viewModel.requestgetNewUser(nat,gender)
            }else{
                requireContext().showToast("Favor de seleccionar todos los campos")
            }

        }
        viewModel.lvdCurrentUser.observe(viewLifecycleOwner, observerStateCreateUser)
    }


    fun getIdRb(id:Int): String{
        return when(id){
            binding.rbAuFgmntcu.id->{ConstantsApp.Nationalities.AUSTRALIAN}
            binding.rbBrFgmntcu.id->{ConstantsApp.Nationalities.BRAZILIAN}
            binding.rbChFgmntcu.id->{ConstantsApp.Nationalities.CHINESE}
            binding.rbEsFgmntcu.id->{ConstantsApp.Nationalities.SPANISH}
            binding.rbIrFgmntcu.id->{ConstantsApp.Nationalities.IRISH}
            binding.rbFrFgmntcu.id->{ConstantsApp.Nationalities.FRENCH}
            binding.rbUsFgmntcu.id->{ConstantsApp.Nationalities.US}
            binding.rbMaleFgmntcu.id->{ConstantsApp.Gender.MALE}
            binding.rbFemaleFgmntcu.id->{ConstantsApp.Gender.FEMALE}
            else->{""}
        }
    }

    private val observerStateCreateUser = Observer<Person>{
        if (it!=null){
            val action = CreateUserFragmentDirections.actionCreateUserFragmentToPeopleFragment()
            findNavController().navigate(action)
        }else{
            requireContext().showToast("No se logro obtener ningun usuario")
        }
    }

}