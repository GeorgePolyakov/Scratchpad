package com.casinojt.trainmvvm.database.firebase

import androidx.lifecycle.LiveData
import com.casinojt.trainmvvm.database.DatabaseRepository
import com.casinojt.trainmvvm.model.AppNote
import com.casinojt.trainmvvm.utilits.EMAIL
import com.casinojt.trainmvvm.utilits.PASSSWORD
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class AppFireBaseRepository : DatabaseRepository {
    private val firebaseAuthInstance = FirebaseAuth.getInstance()
    override val allNotes: LiveData<List<AppNote>>
        get() = TODO("Not yet implemented")

    override suspend fun insert(note: AppNote) {

    }

    override suspend fun delete(note: AppNote) {

    }

    override fun connectToDataBase(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        super.connectToDataBase(onSuccess, onFail)
        firebaseAuthInstance.signInWithEmailAndPassword(EMAIL, PASSSWORD)
            .addOnSuccessListener { onSuccess }
            .addOnFailureListener{
                it.message.toString()
            }
    }

    override fun signOut() {
        super.signOut()
    }
}