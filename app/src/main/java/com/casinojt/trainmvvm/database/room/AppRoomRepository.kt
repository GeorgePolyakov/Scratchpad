package com.casinojt.trainmvvm.database.room

import androidx.lifecycle.LiveData
import com.casinojt.trainmvvm.database.DatabaseRepository
import com.casinojt.trainmvvm.model.AppNote

class AppRoomRepository(private val appRoomDao: RoomDao):DatabaseRepository {
    override val allNotes: LiveData<List<AppNote>>
        get() = appRoomDao.getAllNotes()

    override suspend fun insert(note: AppNote) {
        appRoomDao.insert(note)
    }

    override suspend fun delete(note: AppNote, onSuccess: () -> Unit) {
        appRoomDao.delete(note)
    }

}