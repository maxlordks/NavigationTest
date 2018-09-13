package com.maxlord.navigationtest.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.maxlord.navigationtest.base.BaseFragment
import com.maxlord.navigationtest.common.fragmentViewModel
import com.maxlord.navigationtest.databinding.CommonErrorFragmentBinding

class CommonErrorFragment : BaseFragment<CommonErrorState, CommonErrorViewModel, CommonErrorFragmentBinding>() {
    override val viewModel: CommonErrorViewModel by fragmentViewModel()
    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = CommonErrorFragmentBinding.inflate(inflater, container, false)


}
