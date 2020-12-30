package com.udacity.shoestore.screens.shoes.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.screens.shoes.ShoeViewModel


class ShoeDetailFragment : Fragment() {

    private val viewModel by activityViewModels<ShoeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentShoeDetailBinding.inflate(inflater)
        binding.viewModel = viewModel
        viewModel.backEvent.observe(viewLifecycleOwner, Observer { isSaved ->
            if (isSaved) {
                goToList();
            }
        });
        return binding.root
    }


    fun goToList() {
        findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment);
    }

}