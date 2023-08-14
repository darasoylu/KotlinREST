package com.darasoylu.kotlinrest.ui.createScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.darasoylu.kotlinrest.model.User
import com.darasoylu.kotlinrest.ui.BaseViewModel
import com.darasoylu.kotlinrest.R
import com.darasoylu.kotlinrest.databinding.FragmentCreateBinding

class CreateFragment : Fragment() {

    private lateinit var binding: FragmentCreateBinding
    private val viewModel: BaseViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.createUserBt.setOnClickListener {
            val createUserFname = binding.createUserFirstNameET.text.toString()
            val createUserLname = binding.createUserLastNameET.text.toString()
            val createUserAge = binding.createUserAgeET.text.toString().toInt()
            val createUserImage = binding.createUserImageET.text.toString()
            //"https://xsgames.co/randomusers/avatar.php?g=male"
            val postUser = User(null, createUserFname, createUserLname, createUserAge, createUserImage)
            viewModel.postUser(postUser)
            findNavController().navigate(R.id.action_createFragment_to_homeFragment)
        }

    }

}