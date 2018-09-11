package com.maxlord.navigationtest

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class BlankFragment2 : Fragment() {

    companion object {
        fun newInstance() = BlankFragment2()
    }

    private lateinit var viewModel: BlankFragment2ViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.blank_fragment2_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BlankFragment2ViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
