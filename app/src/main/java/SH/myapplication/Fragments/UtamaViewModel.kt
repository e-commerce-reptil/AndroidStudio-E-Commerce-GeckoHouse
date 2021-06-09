package SH.myapplication.Fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UtamaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Utama Fragment"
    }
    val text: LiveData<String> = _text
}