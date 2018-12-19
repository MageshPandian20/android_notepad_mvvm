package com.example.esamohammed.mvvm.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.view.View
import com.example.esamohammed.mvvm.util.Constants.NavigationFlag.Companion.NAVIGATE_TO_LOGINACTIVITY
import com.example.esamohammed.mvvm.viewModel.activity.SignUpViewModel
import com.example.esamohammed.notepadmvvm.R
import com.example.esamohammed.notepadmvvm.databinding.ActivitySignUpBinding

class SignUpActivity : BaseActivity<SignUpViewModel, ActivitySignUpBinding>(), View.OnClickListener {


    override fun initializeView(): SignUpViewModel {
        return ViewModelProviders.of(this).get(SignUpViewModel::class.java)
    }

    override fun layoutRes(): Int {
        return R.layout.activity_sign_up
    }

    override fun initializeListener() {
        viewBinding.btnSignUp.setOnClickListener(this)

        viewModel.eventLiveData.observe(this, Observer {
            when (it) {
                NAVIGATE_TO_LOGINACTIVITY -> finish()
            }
        })
    }

    override fun onClick(v: View?) {

            when (v?.id) {
                R.id.btnSignUp -> viewModel.signup(
                    viewBinding.edtName.text.toString().trim(),
                    viewBinding.edtmailId.text.toString().trim(),
                    viewBinding.edtPhoneNumber.text.toString().trim(),
                    viewBinding.edtPassword.text.toString().trim(),
                    viewBinding.edtReenterPassword.text.toString().trim()
                )
                else -> {
                }

        }


    }
}
