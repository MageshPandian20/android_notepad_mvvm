package com.example.esamohammed.mvvm.view.activity

import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.esamohammed.mvvm.util.Constants.UIEventFlags.Companion.DISMISS_PROGRESS_BAR
import com.example.esamohammed.mvvm.util.Constants.UIEventFlags.Companion.SHOW_NO_INTERNET
import com.example.esamohammed.mvvm.util.Constants.UIEventFlags.Companion.SHOW_PROGRESS_BAR
import com.example.esamohammed.mvvm.view.widget.CustomProgressBar
import com.example.esamohammed.mvvm.viewModel.BaseViewModel
import com.example.esamohammed.notepadmvvm.R

abstract class BaseActivity<VM : BaseViewModel, VB : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var viewBinding: VB

    abstract fun initializeView(): VM

    abstract fun layoutRes(): Int

    private var mCustomProgressbar: CustomProgressBar? = null

    abstract fun initializeListener()

    open fun onViewModelCreated() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initContext(applicationContext)


        viewModel.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, layoutRes())
        viewBinding.setLifecycleOwner(this)

        initializeListener()


        viewModel.basicEventLiveData.observe(this, Observer {
            when (it) {
                SHOW_PROGRESS_BAR -> {
                    getProgressBar()!!.show()
                }
                DISMISS_PROGRESS_BAR -> {
                    runOnUiThread {
                        try {
                            if (getProgressBar() != null && getProgressBar()!!.isShowing())
                                getProgressBar()!!.dismissProgress()
                        } catch (e: Exception) {
                        }
                    }
                }
                SHOW_NO_INTERNET -> {
                }
            }
        })

    }


    private fun getProgressBar(): CustomProgressBar? {
        if (mCustomProgressbar == null) {
            mCustomProgressbar = CustomProgressBar(this)
        }
        return mCustomProgressbar
    }


    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }


    protected val viewModel: VM by lazy {

        initializeView()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        viewModel.startActivityForResult(requestCode, resultCode, data)
    }


    fun <navigateTo> navigateTo(className: Class<navigateTo>, bundle: Bundle?, needDefaultAnim: Boolean) {
        val intent = Intent(this, className)
        if (bundle != null)
            intent.putExtras(bundle)
        startActivity(intent)
        if (needDefaultAnim)
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
    }


    fun <G> navigateToWithResult(
        className: Class<G>,
        bundle: Bundle?,
        needDefaultAnim: Boolean,
        activityRequestCode: Int
    ) {
        val intent = Intent(this, className)
        if (bundle != null)
            intent.putExtras(bundle)
        startActivityForResult(intent, activityRequestCode)
        if (needDefaultAnim)
            overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
    }


    fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}
