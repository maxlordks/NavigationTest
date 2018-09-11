package com.maxlord.navigationtest.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavDirections
import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.maxlord.navigationtest.BuildConfig
import com.maxlord.navigationtest.common.Event
import com.maxlord.navigationtest.common.NavEvent

abstract class BaseViewModel<S : MvRxState>(initialState: S) : BaseMvRxViewModel<S>(initialState, debugMode = BuildConfig.DEBUG) {
    private val _navigator = MutableLiveData<NavEvent>()
    protected val _toast = MutableLiveData<Event<String>>()

    val navigator : LiveData<NavEvent>
        get() = _navigator

    val toast : LiveData<Event<String>>
        get() = _toast


    protected fun navigate(dir: NavDirections) = _navigator.postValue(NavEvent(dir))
}