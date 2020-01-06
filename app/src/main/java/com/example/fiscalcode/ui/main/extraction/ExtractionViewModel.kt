package com.example.fiscalcode.ui.main.extraction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class ExtractionViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Estrazione dei dati da un CF"
    }

    fun setIndex(index: Int) {
        _index.value = index
    }
}