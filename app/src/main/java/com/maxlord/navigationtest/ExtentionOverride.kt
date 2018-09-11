package com.maxlord.navigationtest

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.*
import kotlin.reflect.KClass

@SuppressLint("RestrictedApi")
inline fun <T, reified VM : BaseMvRxViewModel<S>, reified S : MvRxState> T.fragmentViewModel(
        viewModelClass: KClass<VM> = VM::class,
        crossinline keyFactory: () -> String = { viewModelClass.java.name }
) where T : Fragment, T : MvRxView = lifecycleAwareLazy(this) {
    val stateFactory: () -> S = ::_fragmentViewModelInitialStateProviderModified
    MvRxViewModelProvider.get(viewModelClass.java, this, keyFactory(), stateFactory)
            .apply { subscribe(requireActivity(), subscriber = { postInvalidate() }) }
}

inline fun <reified S : MvRxState, T : Fragment> T._fragmentViewModelInitialStateProviderModified(): S {
    val args: Any? = arguments?.get(MvRx.KEY_ARG)
    return if (arguments != null && args == null) {
        _initialStateProvider(S::class.java, arguments)
    } else _initialStateProvider(S::class.java, args)
}