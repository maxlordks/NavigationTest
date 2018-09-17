package com.maxlord.navigationtest.presentation

import android.content.res.Resources
import androidx.fragment.app.FragmentActivity
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.maxlord.navigationtest.R
import com.maxlord.navigationtest.base.BaseViewModel
import com.maxlord.navigationtest.common.Event
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class BlankViewModel(initialState: HelloWorldCounter) : BaseViewModel<HelloWorldCounter>(initialState) {

    val resources: Resources by instance()

    init {
        logStateChanges()
    }

    companion object : MvRxViewModelFactory<HelloWorldCounter> {

        @JvmStatic
        override fun create(activity: FragmentActivity, state: HelloWorldCounter): BlankViewModel {
            //val dataStore: DataStore by activity.inject() // access some DI framework.
            return BlankViewModel(state).apply { kodein = (activity.applicationContext as KodeinAware).kodein }
        }

    }

    fun inc() = setState {
        _toast.postValue(Event(resources.getString(R.string.value_increased)))
        this.copy(count = this.count + 1)
    }

    fun details() = withState {
        navigate(BottomNavFragmentDirections.actionBottomNavFragment2ToDetails2(it.count))
    }
}


data class HelloWorldCounter(val count: Int = 0) : MvRxState
