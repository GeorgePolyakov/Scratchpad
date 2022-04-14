package com.casinojt.trainmvvm.screens.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.casinojt.trainmvvm.utilits.REPOSITORY

class MainFramentViewModel(application:Application):AndroidViewModel(application){
    val allNotes  = REPOSITORY.allNotes

}