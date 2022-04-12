package com.casinojt.trainmvvm.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.casinojt.trainmvvm.model.AppNote


@Database(entities = [AppNote::class],version = 1)
abstract class ApplicationRoomDataBase : RoomDatabase() {
    abstract fun getApplicationRoomDao():RoomDao

    companion object{
        @Volatile
        private var database:ApplicationRoomDataBase?=null

        @Synchronized
        fun getInstance(context: Context):ApplicationRoomDataBase{
            return if(database==null){
                database = Room.databaseBuilder(
                    context,
                    ApplicationRoomDataBase::class.java,
                    "database"
                ).build()
                database as ApplicationRoomDataBase
            } else database as ApplicationRoomDataBase
        }
    }
}