package com.example.projectmanagement.firebase

import android.app.Activity
import android.util.Log
import android.widget.Toast
import com.example.projectmanagement.activities.MainActivity
import com.example.projectmanagement.activities.MyProfileActivity
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

    fun updateUserProfileData(activity: MyProfileActivity,
                              userHashMap: HashMap<String, Any>){
        mFireStore.collection(Constants.Users)
            .document(getCurrentUserId())
            .update(userHashMap)
            .addOnSuccessListener {
                Log.i(activity.javaClass.simpleName, "profile updated")
                Toast.makeText(activity, "profile has been updated!",Toast.LENGTH_LONG).show()
                activity.profileUpdateSuccess()
            }.addOnFailureListener {
                e ->
                activity.hideProgressDialog()
                Log.e(activity.javaClass.simpleName,
                    "profile updated")
                Toast.makeText(activity, "profile failed to updated!",Toast.LENGTH_LONG).show()
            }
    }

    fun loadUserData(activity: Activity){
        mFireStore.collection(Constants.Users)
            .document(getCurrentUserId())
            .get()
            .addOnSuccessListener { document ->
                val loggedInUser = document.toObject(User::class.java)
                when(activity){
                    is SignInActivity ->{
                        activity.signInSuccess(loggedInUser!!)
                    }
                    is MainActivity ->{
                        activity.updateNavigationUserDetails(loggedInUser!!)
                    }
                    is MyProfileActivity ->{
                        activity.setUserDataInUI(loggedInUser!!)
                    }
                }
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