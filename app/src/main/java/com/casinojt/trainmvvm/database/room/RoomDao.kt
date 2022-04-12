package com.casinojt.trainmvvm.database.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.casinojt.trainmvvm.model.AppNote

@Dao
interface RoomDao {
    @Query("SELECT * from notes_tables")
    fun getAllNotes():LiveData<List<AppNote>> // вернем в виде LiveData

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note:AppNote)

    @Delete
    suspend fun delete(note:AppNote)


}