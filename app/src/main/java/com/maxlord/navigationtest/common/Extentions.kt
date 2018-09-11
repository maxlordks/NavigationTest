package com.maxlord.navigationtest.common

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

class EventObserver<T>(private val onEventUnhandledContent: (T) -> Unit) : Observer<Event<T>> {
    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandled()?.let (onEventUnhandledContent)
    }
}

fun <D> LiveData<Event<D>>.observeEvent(owner: LifecycleOwner, handler: (D)->Unit) {
    this.observe(owner, EventObserver(handler))
}

fun Fragment.toast(text:String) = Toast.makeText(requireContext(), text, Toast.LENGTH_LONG).show()