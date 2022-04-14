package com.casinojt.trainmvvm.screens.add_new_notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.casinojt.trainmvvm.model.AppNote
import com.casinojt.trainmvvm.utilits.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddNewNoteFragmentViewModel(application: Application) : AndroidViewModel(application) {
    fun insert(note: AppNote, onSucces: () -> Unit) =
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                REPOSITORY.insert(note)
            }
            withContext(Dispatchers.Main){
                onSucces()
            }
        }
}