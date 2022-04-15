package com.casinojt.trainmvvm.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.RoomDatabase
import com.casinojt.trainmvvm.database.firebase.AppFireBaseRepository
import com.casinojt.trainmvvm.database.room.AppRoomRepository
import com.casinojt.trainmvvm.database.room.ApplicationRoomDataBase
import com.casinojt.trainmvvm.utilits.REPOSITORY
import com.casinojt.trainmvvm.utilits.TYPE_FIREBASE
import com.casinojt.trainmvvm.utilits.TYPE_ROOM
import com.casinojt.trainmvvm.utilits.showToast

class StartFragmentViewModel (application: Application):AndroidViewModel(application){
    private val mContext = application

    fun initDataBase(type:String,onSuccess:()->Unit){
        when (type){
            TYPE_ROOM -> {
                val dao = ApplicationRoomDataBase.getInstance(mContext).getApplicationRoomDao()
                REPOSITORY = AppRoomRepository(dao)
                onSuccess()
            }
            TYPE_FIREBASE -> {
                REPOSITORY = AppFireBaseRepository()
                REPOSITORY.connectToDataBase({onSuccess()},{ showToast(it)})
            }
        }
    }
}