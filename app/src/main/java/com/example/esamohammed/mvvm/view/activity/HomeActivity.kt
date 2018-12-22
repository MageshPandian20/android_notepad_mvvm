package com.example.esamohammed.mvvm.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import com.example.esamohammed.mvvm.util.Constants.EventFlags.Companion.REFRESH_NOTESLIST
import com.example.esamohammed.mvvm.util.Constants.NavigationFlag.Companion.NAVIGATE_TO_ADDNOTES
import com.example.esamohammed.mvvm.viewModel.activity.HomeViewModel
import com.example.esamohammed.notepadmvvm.R
import com.example.esamohammed.notepadmvvm.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity<HomeViewModel, ActivityHomeBinding>() {

    override fun initializeView(): HomeViewModel {
        return ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun layoutRes(): Int {
        return R.layout.activity_home
    }

    override fun initializeListener() {
        viewBinding.listener = viewModel
        viewModel.listEventLiveData.observe(this, Observer {
            when (it?.second) {
                REFRESH_NOTESLIST -> viewBinding.adapter = it.first
            }
        })

        viewModel.eventLiveData.observe(this, Observer {
            when (it?.first) {
                NAVIGATE_TO_ADDNOTES -> navigateTo(AddingNotesActivity::class.java, null, true)
            }
        })
    }
}
