package com.example.esamohammed.mvvm.adapter.viewHolder

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.View


abstract class BaseViewHolder<T, VB : ViewDataBinding> : RecyclerView.ViewHolder {

    var data: T? = null
        set(value) {
            field = value
            data?.let { populateData(it) }
        }

    protected lateinit var viewDataBinding: VB
    internal var TAG = javaClass.simpleName

    internal constructor(viewDataBinding: VB) : super(viewDataBinding.root) {
        this.viewDataBinding = viewDataBinding
    }

    internal constructor(itemView: View) : super(itemView)

    internal abstract fun populateData(data: T)

}
