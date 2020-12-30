package com.udacity.shoestore.screens.shoes.list

import android.content.Context
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe

class ShoeItemView(context: Context, shoe: Shoe) : ConstraintLayout(context) {  init {
    ShoeItemBinding.inflate(LayoutInflater.from(context), this, true).apply {
        shoeName.text = context.getString(R.string.shoe_name, shoe.name)
        shoeSize.text = context.getString(R.string.shoe_size, shoe.size);
        shoeCompany.text = context.getString(R.string.company_label, shoe.company);
        shoeDescription.text = context.getString(R.string.description, shoe.description);
    }
}

}

