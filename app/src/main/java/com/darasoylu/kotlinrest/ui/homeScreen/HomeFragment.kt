package com.darasoylu.kotlinrest.ui.homeScreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.darasoylu.kotlinrest.R
import com.darasoylu.kotlinrest.ui.BaseViewModel
import com.darasoylu.kotlinrest.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), OnItemClickListener {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: BaseViewModel by viewModels()
    private val userAdapter by lazy { HomeFragmentAdapter(this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.cartoonRecyclerView) {
            adapter = userAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }

        viewModel.getUsers()
        viewModel.users.observe(viewLifecycleOwner) { response ->
            response.body()?.let {
                Log.i("logGetUsers", response.body().toString())
                userAdapter.setData(it)
            }
        }

    }

    override fun onItemClick(id: String) {
        val bundle= Bundle()
        bundle.putString("getUserId", id)
        findNavController().navigate(R.id.action_homeFragment_to_updateFragment, bundle)
    }

}