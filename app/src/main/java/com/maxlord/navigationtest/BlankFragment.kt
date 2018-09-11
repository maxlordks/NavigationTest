package com.maxlord.navigationtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.airbnb.mvrx.fragmentViewModel
import com.maxlord.navigationtest.databinding.BlankFragmentBinding


class BlankFragment : BaseFragment<HelloWorldCounter, BlankViewModel, BlankFragmentBinding>() {

    override val viewModel: BlankViewModel by fragmentViewModel()


    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): BlankFragmentBinding = BlankFragmentBinding.inflate(inflater, container, false)

}
