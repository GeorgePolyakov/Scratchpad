package com.casinojt.trainmvvm.utilits

import com.casinojt.trainmvvm.MainActivity
import com.casinojt.trainmvvm.database.DatabaseRepository
import com.google.firebase.FirebaseError
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

lateinit var FIREBASE_AUTH_INSTANCE: FirebaseAuth
lateinit var CURRENT_ID: String
lateinit var DATABASE_REFERENCES: DatabaseReference
lateinit var APP_ACTIVITY:MainActivity
lateinit var REPOSITORY:DatabaseRepository
const val TYPE_DATABASE = "type_database"
const val TYPE_ROOM = "type_room"
const val TYPE_FIREBASE = "type_firebase"
lateinit var EMAIL:String
lateinit var PASSSWORD:String
const val ID_FIREBASE = "idFirebase"
const val NAME = "name"
const val TEXT = "text"

