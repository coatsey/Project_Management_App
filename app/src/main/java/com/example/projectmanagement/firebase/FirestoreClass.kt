package com.example.projectmanagement.firebase

import com.example.projectmanagement.activities.SignInActivity
import com.example.projectmanagement.activities.SignUpActivity
import com.example.projectmanagement.models.User
import com.example.projectmanagement.utils.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions

class FirestoreClass {

    private val mFireStore = FirebaseFirestore.getInstance()

    fun registerUser(activity: SignUpActivity, userInfo : User){
        mFireStore.collection(Constants.Users)
            .document(getCurrentUserId())
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {
                activity.userRegisteredSuccess()
            }
    }

    fun signInUser(activity: SignInActivity){
        mFireStore.collection(Constants.Users)
            .document(getCurrentUserId())
            .get()
            .addOnSuccessListener { document ->
                val loggedInUser = document.toObject(User::class.java)
                if (loggedInUser !=null)
                activity.signInSuccess(loggedInUser)
            }

    }

   fun getCurrentUserId(): String{
       var currentUser = FirebaseAuth.getInstance().currentUser
       var currentUserID = ""
       if (currentUser != null){
           currentUserID = currentUser.uid
       }
       return currentUserID
    }
}