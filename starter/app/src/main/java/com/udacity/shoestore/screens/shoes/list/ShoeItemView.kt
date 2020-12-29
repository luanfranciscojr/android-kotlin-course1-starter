package com.udacity.shoestore.screens.shoes.list

import android.content.Context
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe

class ShoeItemView(context: Context, shoe: Shoe) : ConstraintLayout(context) {  init {
    val binding = ShoeItemBinding.inflate(LayoutInflater.from(context), this, true)
    binding.shoeName.text = context.getString(R.string.shoe_name, shoe.name)
    binding.shoeSize.text = context.getString(R.string.shoe_size, shoe.size);
    binding.shoeCompany.text = context.getString(R.string.company_label, shoe.company);
    binding.shoeDescription.text = context.getString(R.string.description, shoe.description);
}

}

