package com.maxlord.navigationtest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maxlord.navigationtest.databinding.EnterDetailsFragmentBinding
import kotlinx.android.synthetic.main.enter_details_fragment.*


class EnterDetailsFragment : BaseFragment<HelloWorldCounter, EnterDetailsViewModel, EnterDetailsFragmentBinding>() {
    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = EnterDetailsFragmentBinding.inflate(inflater, container, false)
    override val viewModel: EnterDetailsViewModel by fragmentViewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        done.setOnClickListener {
            requireActivityNavigator().popBackStack()
        }
    }
}
