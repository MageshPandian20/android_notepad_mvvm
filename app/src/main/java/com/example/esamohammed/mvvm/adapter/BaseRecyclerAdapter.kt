package com.example.esamohammed.mvvm.adapter

import android.support.v7.widget.RecyclerView
import com.example.esamohammed.mvvm.adapter.viewHolder.BaseViewHolder
import java.util.*


abstract class BaseRecyclerAdapter<T, V : BaseViewHolder<T, *>>(var data: MutableList<T>?) : RecyclerView.Adapter<V>() {


    protected var TAG = javaClass.simpleName

    override fun onBindViewHolder(holder: V, position: Int) {
        holder.data = getItem(position)
    }

    override fun getItemCount(): Int {
        return data!!.size
    }

    @Throws(IndexOutOfBoundsException::class)
    fun getItem(position: Int): T {
        return data!![position]
    }

    fun addItem(`object`: T) {
        data!!.add(`object`)
        notifyItemInserted(data!!.indexOf(`object`))
    }

    @Throws(IndexOutOfBoundsException::class)
    fun removeItem(position: Int) {
        data!!.removeAt(position)
        notifyItemRemoved(position)
    }

    fun resetItems(data: MutableList<T>?) {
        if (data != null) {
            this.data = data
            notifyDataSetChanged()
        }
    }

    fun addItems(data: List<T>?) {
        if (data != null) {
            val startRange = if (this.data!!.size - 1 > 0) data.size - 1 else 0
            this.data!!.addAll(data)
            notifyItemRangeChanged(startRange, data.size)
        }
    }

    fun setFilter(data: MutableList<T>) {
        this.data = ArrayList()
        this.data!!.addAll(data)
        resetItems(data)
    }

}

