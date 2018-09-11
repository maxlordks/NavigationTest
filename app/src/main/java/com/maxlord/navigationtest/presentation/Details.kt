package com.maxlord.navigationtest.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.maxlord.navigationtest.base.BaseFragment
import com.maxlord.navigationtest.databinding.DetailsFragmentBinding
import com.maxlord.navigationtest.common.fragmentViewModel


class Details : BaseFragment<DetailsState, DetailsViewModel, DetailsFragmentBinding>() {
    override val viewModel: DetailsViewModel by fragmentViewModel()
    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = DetailsFragmentBinding.inflate(inflater, container, false)


}


