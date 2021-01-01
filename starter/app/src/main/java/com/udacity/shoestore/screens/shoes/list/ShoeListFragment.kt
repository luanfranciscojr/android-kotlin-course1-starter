package com.udacity.shoestore.screens.shoes.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.shoes.ShoeViewModel
import com.udacity.shoestore.screens.shoes.list.ShoeItemView

class ShoeListFragment : Fragment() {


    private val viewModel by activityViewModels<ShoeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentShoeListBinding.inflate(inflater)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false);
        viewModel.shoes.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                it.forEach { shoe ->
                    binding.container.addView(ShoeItemView(requireContext(), shoe))
                }
            }
        })
        binding.detailButton.setOnClickListener { goToDetail() }
        setHasOptionsMenu(true);
        return binding.root;
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_overflow, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_shoeListFragment_to_loginFragment) {
            findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment);
        }
        return super.onOptionsItemSelected(item);
    }

    private fun goToDetail() {
        findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment);
    }

}