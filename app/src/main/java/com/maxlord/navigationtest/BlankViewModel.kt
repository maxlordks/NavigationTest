package com.maxlord.navigationtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState

abstract class BaseViewModel<S : MvRxState>(initialState: S) : BaseMvRxViewModel<S>(initialState, debugMode = BuildConfig.DEBUG)

class BlankViewModel(initialState: HelloWorldCounter) : BaseViewModel<HelloWorldCounter>(initialState) {

    private val _navigateToDetails = MutableLiveData<Event<Int>>()
    private val _toast = MutableLiveData<Event<String>>()

    val navigateToDetails : LiveData<Event<Int>>
        get() = _navigateToDetails

    val toast : LiveData<Event<String>>
        get() = _toast

    init {
        logStateChanges()
    }

    fun inc() = setState {
        _toast.postValue(Event("Increasing"))
        this.copy(count = this.count + 1)
    }

    fun details() = withState {
        _navigateToDetails.postValue( Event(it.count))
    }
}

data class NavEvent<out T>(val content: T)

data class HelloWorldCounter(val count: Int = 0) : MvRxState
