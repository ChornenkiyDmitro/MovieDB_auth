package com.example.movie.presentation.profile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movie.R
import com.example.movie.presentation.auth.AuthActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_profile.*


class ProfileActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initProfileData()

        buttonSignOut.setOnClickListener {
            signOut()
        }
    }

    private fun initProfileData(){
        val signInAccount = GoogleSignIn.getLastSignedInAccount(this)
        if (signInAccount != null) {
            textUserName.text = signInAccount.displayName
            textEmailUser.text = signInAccount.email
        }
    }

    private fun signOut(){
        FirebaseAuth.getInstance().signOut()
        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
        finishAffinity()
    }
}