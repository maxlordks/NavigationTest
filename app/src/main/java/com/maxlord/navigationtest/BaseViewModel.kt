package com.maxlord.navigationtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavDirections
import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState

abstract class BaseViewModel<S : MvRxState>(initialState: S) : BaseMvRxViewModel<S>(initialState, debugMode = BuildConfig.DEBUG) {
    private val _navigator = MutableLiveData<NavEvent>()
    protected val _toast = MutableLiveData<Event<String>>()

    val navigator : LiveData<NavEvent>
        get() = _navigator

    val toast : LiveData<Event<String>>
        get() = _toast


    protected fun navigate(dir: NavDirections) = _navigator.postValue(NavEvent(dir))
}