package com.maxlord.navigationtest.presentation

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maxlord.navigationtest.R


class BlankFragment4 : Fragment() {

    companion object {
        fun newInstance() = BlankFragment4()
    }

    private lateinit var viewModel: BlankFragment4ViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.blank_fragment4_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BlankFragment4ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
