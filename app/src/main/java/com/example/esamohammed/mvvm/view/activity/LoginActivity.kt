package com.example.esamohammed.mvvm.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.view.View
import com.example.esamohammed.mvvm.util.Constants.NavigationFlag.Companion.NAVIGATE_TO_HOMEACTIVITY
import com.example.esamohammed.mvvm.util.Constants.NavigationFlag.Companion.NAVIGATE_TO_SIGNUPACTIVITY
import com.example.esamohammed.mvvm.util.Constants.UIEventFlags.Companion.SHOW_TOAST
import com.example.esamohammed.mvvm.viewModel.activity.LoginViewModel
import com.example.esamohammed.notepadmvvm.R
import com.example.esamohammed.notepadmvvm.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<LoginViewModel, ActivityLoginBinding>(), View.OnClickListener {

    override fun initializeView(): LoginViewModel {
        return ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    override fun layoutRes(): Int {
        return R.layout.activity_login
    }

    override fun initializeListener() {
        viewBinding.btnSignIn.setOnClickListener(this)
        viewBinding.listener = viewModel
        viewModel.eventLiveData.observe(this, Observer {
            when (it) {
                SHOW_TOAST -> showMessage("Message")
                NAVIGATE_TO_HOMEACTIVITY -> {
                    navigateTo(HomeActivity::class.java, null, true)
                    finish()
                }
                NAVIGATE_TO_SIGNUPACTIVITY -> navigateTo(SignUpActivity::class.java, null, true)
            }
        })

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSignIn -> {
                viewModel.setData(
                    viewBinding.txtUserId.text.toString().trim(),
                    viewBinding.txtPassword.text.toString().trim()
                )
            }
        }
    }


}
