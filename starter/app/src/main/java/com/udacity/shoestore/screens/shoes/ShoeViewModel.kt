package com.udacity.shoestore.screens.shoes

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.BR
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoes = MutableLiveData<ArrayList<Shoe>>(ArrayList())
    private val _backEvent = MutableLiveData<Boolean>()

    val backEvent: LiveData<Boolean>
        get() = _backEvent

    val shoes: LiveData<ArrayList<Shoe>>
        get() = _shoes

    val shoe = Shoe("",0.0,"","")

    private fun _addShoe(shoe: Shoe) {
        _shoes.value?.add(shoe);
    }

    fun save() {
        _addShoe(shoe)
        _backEvent.value = true;
    }

    fun cancel() {
        _backEvent.value = true;
    }

    fun onBackComplete() {
       _backEvent.value = false;
    }

}