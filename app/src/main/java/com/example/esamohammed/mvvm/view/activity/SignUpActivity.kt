package com.example.esamohammed.mvvm.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.view.View
import com.example.esamohammed.mvvm.util.Constants.UIEventFlags.Companion.SHOW_TOAST
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
            when (it?.first) {
                SHOW_TOAST->showMessage(it.second)
            }
        })

        viewModel.signUpResponseData.observe(this, Observer {
           if(it?.success!!)
            finish()
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
        }
    }
}
