package com.maxlord.navigationtest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.maxlord.navigationtest.databinding.BlankFragmentBinding


class BlankFragment : BaseMvRxFragment() {


    override fun invalidate() {
        Log.w("BLANK", "Invalidate")
        withState(viewModel) {
            Log.w("BLANK", "Invalidate with state")
            binding.vms = it
        }
    }

    private val viewModel: BlankViewModel by fragmentViewModel()
    private lateinit var binding: BlankFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = BlankFragmentBinding.inflate(inflater, container, false)
//        NavigationUI.setupActionBarWithNavController(requireActivity() as AppCompatActivity, findNavController())

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.vm = viewModel
        viewModel.navigateToDetails.observe(this, Observer { event ->
            event.getContentIfNotHandled()?.let {
//                findNavController().navigate(BlankFragmentDirections.actionBlankFragmentToDetails(it))
                requireActivity().findNavController(R.id.mainNavFragment).navigate(BottomNavFragmentDirections.actionBottomNavFragment2ToDetails2(it))
            }
        })
        viewModel.toast.observe(this, Observer { event ->
            event.getContentIfNotHandled()?.let {
                //                findNavController().navigate(BlankFragmentDirections.actionBlankFragmentToDetails(it))
                Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
            }
        })
    }
}
