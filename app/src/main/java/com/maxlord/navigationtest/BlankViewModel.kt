package com.maxlord.navigationtest

import com.airbnb.mvrx.MvRxState

class BlankViewModel(initialState: HelloWorldCounter) : BaseViewModel<HelloWorldCounter>(initialState) {


    init {
        logStateChanges()
    }

    fun inc() = setState {
        _toast.postValue(Event("Increasing"))
        this.copy(count = this.count + 1)
    }

    fun details() = withState {
        navigate(BottomNavFragmentDirections.actionBottomNavFragment2ToDetails2(it.count))
    }
}


data class HelloWorldCounter(val count: Int = 0) : MvRxState
