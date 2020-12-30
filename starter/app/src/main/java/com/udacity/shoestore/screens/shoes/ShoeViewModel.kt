package com.udacity.shoestore.screens.shoes

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.BR
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel(), Observable {


    private val propertyChangeRegistry = PropertyChangeRegistry()

    private val _shoes = MutableLiveData<ArrayList<Shoe>>(ArrayList())

    private val _backEvent = MutableLiveData<Boolean>()
    val backEvent: LiveData<Boolean>
        get() = _backEvent

    val shoes: LiveData<ArrayList<Shoe>>
        get() = _shoes

    val name = MutableLiveData<String>()

    var size =  MutableLiveData(0.0)

    var company =  MutableLiveData<String>()

    var description = MutableLiveData<String>()

    private fun _addShoe(shoe: Shoe) {
        _shoes.value?.add(shoe);
    }

    fun save() {
        _addShoe(Shoe(name.value, size.value, company.value, description.value))
        _backEvent.value = true;
    }

    fun cancel() {
        _backEvent.value = true;
    }

    fun intSaveEvent() {
       _backEvent.value = false;
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }
}