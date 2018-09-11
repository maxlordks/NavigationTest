package com.maxlord.navigationtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maxlord.navigationtest.databinding.BlankFragment2FragmentBinding
import kotlinx.android.synthetic.main.blank_fragment2_fragment.*


class BlankFragment2 : BaseFragment<HelloWorldCounter, BlankFragment2ViewModel, BlankFragment2FragmentBinding>() {
    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = BlankFragment2FragmentBinding.inflate(inflater, container, false)

    override val viewModel: BlankFragment2ViewModel by fragmentViewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enterName.setOnClickListener {
            requireActivityNavigator().navigate(R.id.enterDetailsFragment)
        }
    }
}
