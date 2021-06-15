package com.app.mobillium.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.app.mobillium.core.base.BaseViewModel
import com.app.mobillium.core.di.AppRepository
import com.app.mobillium.presentation.model.ResultModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject
constructor(private val repository: AppRepository) : BaseViewModel() {

    val resultModel = MutableLiveData<ResultModel>()


    init {
        getAllDiscover()
    }

    private fun getAllDiscover() =
        viewModelScope.launch {
            getIsLoading().postValue(true)
            repository.getAllDiscover()
                .let { response ->
                    if (response.isSuccessful) {
                        resultModel.postValue(response.body())
                    }
                    getIsLoading().value = false
                }
        }
}