package com.example.esamohammed.mvvm.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.view.View
import com.example.esamohammed.mvvm.util.Constants.NavigationFlag.Companion.NAVIGATE_TO_HOMEACTIVITY
import com.example.esamohammed.mvvm.viewModel.activity.AddingNotesViewModel
import com.example.esamohammed.notepadmvvm.R
import com.example.esamohammed.notepadmvvm.databinding.ActivityAddingNotesBinding

class AddingNotesActivity : BaseActivity<AddingNotesViewModel, ActivityAddingNotesBinding>(), View.OnClickListener {


    override fun initializeView(): AddingNotesViewModel {
        return ViewModelProviders.of(this).get(AddingNotesViewModel::class.java)
    }

    override fun layoutRes(): Int {
        return R.layout.activity_adding_notes
    }

    override fun initializeListener() {
        viewBinding.btnAddNotes.setOnClickListener(this)
        viewBinding.btnClearNotes.setOnClickListener(this)
        viewModel.listEventLiveData.observe(this, Observer { option ->
            when (option) {
                NAVIGATE_TO_HOMEACTIVITY -> finish()
            }
        })
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnAddNotes -> {
                viewModel.loadNotesEntity(
                    viewBinding.edtNotesName.text.toString().trim(),
                    viewBinding.edtNotesContent.text.toString().trim()
                )
            }
            R.id.btnClearNotes -> {
                viewBinding.edtNotesName.setText("")
                viewBinding.edtNotesContent.setText("")
            }
        }
    }
}
