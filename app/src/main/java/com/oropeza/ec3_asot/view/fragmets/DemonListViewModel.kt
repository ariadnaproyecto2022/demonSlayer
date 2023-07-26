package com.oropeza.ec3_asot.view.fragmets

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oropeza.ec3_asot.data.repository.DemonRepository
import com.oropeza.ec3_asot.data.response.ApiResponse
import com.oropeza.ec3_asot.model.DemonSlayer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DemonListViewModel: ViewModel() {
    val repository = DemonRepository()
    val demonList: MutableLiveData<List<DemonSlayer>> = MutableLiveData<List<DemonSlayer>>()

    fun getDemonFromService() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getDemons()
            when (response) {
                is ApiResponse.Error -> {
                    // colocar error
                }
                is ApiResponse.Success -> {
                    demonList.postValue(response.data.demons)
                }
            }
        }
    }
}