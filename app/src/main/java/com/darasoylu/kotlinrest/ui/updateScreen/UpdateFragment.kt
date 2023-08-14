package com.darasoylu.kotlinrest.ui.updateScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.darasoylu.kotlinrest.R
import com.darasoylu.kotlinrest.databinding.FragmentUpdateBinding
import com.darasoylu.kotlinrest.model.User
import com.darasoylu.kotlinrest.ui.BaseViewModel

class UpdateFragment : Fragment() {

    private lateinit var binding: FragmentUpdateBinding
    private val viewModel: BaseViewModel by viewModels()
    private var getUserId = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        getUserId = arguments?.getString("getUserId")!!

        binding = FragmentUpdateBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getUser(getUserId)
        viewModel.user.observe(viewLifecycleOwner) { response ->
            response.body()?.let {
                setUser(it)
            }
        }

        binding.updateUserBt.setOnClickListener {
            updateUser()
        }

        binding.deleteUserBt.setOnClickListener {
            viewModel.deleteUser(getUserId)
            findNavController().navigate(R.id.action_updateFragment_to_homeFragment)
        }

    }

    private fun setUser(user: User) {
        binding.updateUserFirstNameET.setText(user.firstName)
        binding.updateUserLastNameET.setText(user.lastName)
        binding.updateUserAgeET.setText(user.age.toString())
        binding.updateUserImageET.setText(user.image)
    }

    private fun updateUser() {
        val updateUser = User(
            getUserId,
            binding.updateUserFirstNameET.text.toString(),
            binding.updateUserLastNameET.text.toString(),
            binding.updateUserAgeET.text.toString().toInt(),
            binding.updateUserImageET.text.toString()
        )
        viewModel.updateUser(getUserId, updateUser)
        findNavController().navigate(R.id.action_updateFragment_to_homeFragment)
    }
}