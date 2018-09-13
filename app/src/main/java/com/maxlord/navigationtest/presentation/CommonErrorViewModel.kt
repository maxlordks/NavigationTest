package com.maxlord.navigationtest.presentation

import android.os.Bundle
import com.airbnb.mvrx.MvRxState
import com.maxlord.navigationtest.base.BaseViewModel

class CommonErrorViewModel(initialState: CommonErrorState) : BaseViewModel<CommonErrorState>(initialState) {
    init {
        logStateChanges()
    }
}

data class CommonErrorState(val message: String? = "Unknown error") : MvRxState {
    constructor(args: CommonErrorFragmentArgs) : this(args.message)
    constructor(args: Bundle) : this(CommonErrorFragmentArgs.fromBundle(args))
}
