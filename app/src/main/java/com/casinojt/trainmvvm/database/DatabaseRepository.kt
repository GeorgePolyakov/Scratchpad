package com.casinojt.trainmvvm.database

import androidx.lifecycle.LiveData
import com.casinojt.trainmvvm.model.AppNote

interface DatabaseRepository {
    val allNotes:LiveData<List<AppNote>>
    suspend fun insert(note:AppNote, onSuccess:()->Unit)
    suspend fun delete(note:AppNote, onSuccess:()->Unit)
}