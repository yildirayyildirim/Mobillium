package com.app.mobillium.presentation.view.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.mobillium.R
import com.app.mobillium.core.base.BaseFragment
import com.app.mobillium.databinding.ViewFragmentHomeBinding
import com.app.mobillium.presentation.view.adapter.MainAdapter
import com.app.mobillium.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<ViewFragmentHomeBinding, HomeViewModel>() {
    private lateinit var mainAdapter: MainAdapter
    override fun getContentView(): Int = R.layout.view_fragment_home

    override fun subScribe(view: View) {
        super.subScribe(view)
        init()
        baseViewModel.resultModel.observe(viewLifecycleOwner, {
            it?.let {
                mainAdapter.updateList(it)
            }
        })
    }

    override fun getViewModel(): Class<HomeViewModel> = HomeViewModel::class.java

    private fun init() {
         mainAdapter = MainAdapter(requireContext())
        dataBinding.mainRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = mainAdapter
        }
    }
}