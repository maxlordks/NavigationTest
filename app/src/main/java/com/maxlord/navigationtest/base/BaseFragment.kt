package com.maxlord.navigationtest.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.databinding.ViewDataBinding
import androidx.navigation.findNavController
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.withState
import com.maxlord.navigationtest.BR
import com.maxlord.navigationtest.R
import com.maxlord.navigationtest.common.observeEvent
import com.maxlord.navigationtest.common.toast

abstract class BaseFragment<S : MvRxState, VM : BaseViewModel<S>, B : ViewDataBinding> : BaseMvRxFragment() {
    protected abstract val viewModel: VM //by fragmentViewModel()
    protected lateinit var binding: B

    override fun invalidate() {
        Log.v(this::class.simpleName, "Invalidate")
        withState(viewModel) {
            Log.i(this::class.simpleName, "Invalidate with state")
            binding.setVariable(BR.vms, it)
        }
    }

    abstract fun createBinding(inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?): B

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = createBinding(inflater, container, savedInstanceState).apply {
            setLifecycleOwner(this@BaseFragment)
        }
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.setVariable(BR.vm, viewModel)
//        viewModel.navigateToDetails.observe(this, Observer { event ->
//            event.getContentIfNotHandled()?.let {
//                //                findNavController().navigate(BlankFragmentDirections.actionBlankFragmentToDetails(it))
//                requireActivity().findNavController(R.id.mainNavFragment).navigate(BottomNavFragmentDirections.actionBottomNavFragment2ToDetails2(it))
//            }
//        })
        with(viewModel) {
            toast.observeEvent(this@BaseFragment) {
                toast(it)
            }
            navigator.observeEvent(this@BaseFragment) {
                requireActivityNavigator().navigate(it)
            }
        }
    }

    fun requireActivityNavigator(@IdRes viewId: Int = R.id.mainNavFragment) = requireActivity().findNavController(viewId)
}