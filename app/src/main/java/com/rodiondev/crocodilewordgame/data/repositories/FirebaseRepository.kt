package com.rodiondev.crocodilewordgame.data.repositories

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.rodiondev.crocodilewordgame.data.db.remote.FirebaseData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseRepository @Inject constructor(
    private val firebaseData: FirebaseData
) {
    fun signUpUser(email: String, password: String, fullName: String) =
        firebaseData.signUpUser(email, password, fullName)

    fun signInUser(email: String, password: String) = firebaseData.signInUser(email, password)

    fun signInWithGoogle(acct: GoogleSignInAccount) = firebaseData.signInWithGoogle(acct)

    fun saveUser(email: String, name: String) = firebaseData.saveUser(email, name)

    fun fetchUser() = firebaseData.fetchUser()

    fun sendForgotPassword(email: String) = firebaseData.sendForgotPassword(email)
}