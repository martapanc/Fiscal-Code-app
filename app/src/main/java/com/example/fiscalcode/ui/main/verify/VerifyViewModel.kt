package com.example.fiscalcode.ui.main.verify

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class VerifyViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Verifica di un CF esistente"
    }

    fun setIndex(index: Int) {
        _index.value = index
    }
}