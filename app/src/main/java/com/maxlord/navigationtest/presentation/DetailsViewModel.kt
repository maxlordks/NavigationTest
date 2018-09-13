package com.maxlord.navigationtest.presentation

import android.os.Bundle
import com.airbnb.mvrx.MvRxState
import com.maxlord.navigationtest.base.BaseViewModel

class DetailsViewModel (initialState: DetailsState) : BaseViewModel<DetailsState>(initialState) {
    init {
        logStateChanges()
    }
}

data class DetailsState(val count: Int = 0) : MvRxState {
    constructor(args: DetailsArgs):this(args.counter)
    constructor(args: Bundle):this(DetailsArgs.fromBundle(args))
}

