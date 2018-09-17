package com.maxlord.navigationtest.presentation

import com.airbnb.mvrx.MvRxState
import com.maxlord.navigationtest.base.BaseViewModel
import com.maxlord.navigationtest.presentation.HelloWorldCounter

class EnterDetailsViewModel(initialState: EnterDetailsState) : BaseViewModel<EnterDetailsState>(initialState) {
    // TODO: Implement the ViewModel
}

data class EnterDetailsState(val text: String? = null) : MvRxState
