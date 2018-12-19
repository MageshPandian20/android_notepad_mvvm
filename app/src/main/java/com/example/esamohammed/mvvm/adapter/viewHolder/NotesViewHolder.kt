package com.example.esamohammed.mvvm.adapter.viewHolder

import com.example.esamohammed.mvvm.repository.dto.common.NotesEntity
import com.example.esamohammed.notepadmvvm.databinding.InflateNotesListBinding


class NotesViewHolder(viewDataBinding: InflateNotesListBinding) :
    BaseViewHolder<NotesEntity, InflateNotesListBinding>(viewDataBinding) {
    override fun populateData(data: NotesEntity) {
        viewDataBinding.data = data
    }
}