package com.casinojt.trainmvvm.database

import androidx.lifecycle.LiveData
import com.casinojt.trainmvvm.model.AppNote

interface DatabaseRepository {
    val allNotes:LiveData<List<AppNote>>
    suspend fun insert(note:AppNote)
    suspend fun delete(note:AppNote)

    fun connectToDataBase(onSuccess:()->Unit, onFail:(String)->Unit){}
    fun signOut(){} //unnecessary to realization
}