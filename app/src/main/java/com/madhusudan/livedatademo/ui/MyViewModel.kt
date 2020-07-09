package com.madhusudan.livedatademo.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.madhusudan.livedatademo.repos.RemoteRepository
import com.madhusudan.livedatademo.network.data.Example

class MyViewModel : ViewModel() {

    fun callAPI() : MutableLiveData<Example>
    {
        return RemoteRepository().callAPI()
    }
}