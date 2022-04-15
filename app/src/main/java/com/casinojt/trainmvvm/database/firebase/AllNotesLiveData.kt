package com.casinojt.trainmvvm.database.firebase

import androidx.lifecycle.LiveData
import com.casinojt.trainmvvm.model.AppNote
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

class AllNotesLiveData : LiveData<List<AppNote>>() {
    private val firebaseAuthInstance =  FirebaseAuth.getInstance()
    private val dataBaseReferences = FirebaseDatabase.getInstance().reference
        .child(firebaseAuthInstance.currentUser?.uid.toString())
    private val listener = object : ValueEventListener{
        override fun onCancelled(error: DatabaseError) {

        }

        override fun onDataChange(snapshot: DataSnapshot) {
            value =  snapshot.children.map{
                it.getValue(AppNote::class.java)?: AppNote()
            }
        }
    }

    override fun onActive() {  // call when our LiveData has one observer
        super.onActive()
        dataBaseReferences.addValueEventListener(listener)
    }

    override fun onInactive() {
        super.onInactive()
        dataBaseReferences.addValueEventListener(listener)
    }
}