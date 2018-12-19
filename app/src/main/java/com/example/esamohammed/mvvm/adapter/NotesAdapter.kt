package com.example.esamohammed.mvvm.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.esamohammed.mvvm.adapter.viewHolder.NotesViewHolder
import com.example.esamohammed.mvvm.repository.dto.common.NotesEntity
import com.example.esamohammed.notepadmvvm.R
import com.example.esamohammed.notepadmvvm.databinding.InflateNotesListBinding

class NotesAdapter(data: ArrayList<NotesEntity>) : BaseRecyclerAdapter<NotesEntity, NotesViewHolder>(data) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            DataBindingUtil.bind<ViewDataBinding>(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.inflate_notes_list, parent, false)
            ) as InflateNotesListBinding
        )
    }
}