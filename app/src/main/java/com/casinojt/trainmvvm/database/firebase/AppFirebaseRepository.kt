package com.casinojt.trainmvvm.database.firebase

import androidx.lifecycle.LiveData
import androidx.navigation.navOptions
import com.casinojt.trainmvvm.database.DatabaseRepository
import com.casinojt.trainmvvm.model.AppNote
import com.casinojt.trainmvvm.utilits.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class AppFirebaseRepository : DatabaseRepository {
    private val firebaseAuthInstance = FirebaseAuth.getInstance()
    override val allNotes: LiveData<List<AppNote>> = AllNotesLiveData()

    init {
        FIREBASE_AUTH_INSTANCE = FirebaseAuth.getInstance()
    }

    override suspend fun insert(note: AppNote) {
        val idNote = DATABASE_REFERENCES.push().key.toString()
        val mapNote = hashMapOf<String,Any>()
        mapNote[ID_FIREBASE] = idNote
        mapNote[NAME] = note.name
        mapNote[TEXT] = note.text

        DATABASE_REFERENCES.child(idNote)
            .updateChildren(mapNote) // updates notes
            .addOnFailureListener{ showToast(it.message.toString())}

    }

    override suspend fun delete(note: AppNote) {
            DATABASE_REFERENCES.child(note.idFirebase).removeValue()
                .addOnSuccessListener {  }
                .addOnFailureListener{showToast(it.message.toString())}

    }

    override fun connectToDataBase(onSuccess: () -> Unit, onFail: (String) -> Unit) {
        super.connectToDataBase(onSuccess, onFail)
        firebaseAuthInstance.signInWithEmailAndPassword(EMAIL, PASSSWORD)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener {
                firebaseAuthInstance.createUserWithEmailAndPassword(
                    EMAIL,
                    PASSSWORD
                ) // create new user in firebase
                    .addOnSuccessListener { onSuccess() }
                    .addOnFailureListener { onFail(it.message.toString()) }
            }
        CURRENT_ID = FIREBASE_AUTH_INSTANCE.currentUser?.uid.toString()
        DATABASE_REFERENCES = FirebaseDatabase.getInstance().reference
            .child(CURRENT_ID)
    }

    override fun signOut() {
        super.signOut()
        firebaseAuthInstance.signOut()
    }
}