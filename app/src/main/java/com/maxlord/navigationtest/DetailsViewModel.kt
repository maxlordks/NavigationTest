package com.maxlord.navigationtest

import android.os.Bundle
import androidx.lifecycle.ViewModel;
import com.airbnb.mvrx.MvRxState

class DetailsViewModel (initialState: DetailsState) : BaseViewModel<DetailsState>(initialState) {
    init {
        logStateChanges()
    }
}

data class DetailsState(val count: Int = 0) : MvRxState {
    constructor(args: DetailsArgs):this(args.counter)
    constructor(args: Bundle):this(DetailsArgs.fromBundle(args))
}

