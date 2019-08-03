package com.github.mag0716.firebase.authsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "AuthenticationSample"
    }

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signInButton.setOnClickListener { signIn() }
        auth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser)
        Log.d(TAG, "Play Serives = ${isPlayServicesAvailable()}")
    }

    private fun updateUI(user: FirebaseUser?) {
        Log.d(TAG, "updateUI : $user")
        if (user != null) {
            text.text = user.email
            emailEditText.isVisible = false
            passwordEditText.isVisible = false
            signInButton.isVisible = false
        } else {
            emailEditText.isVisible = true
            passwordEditText.isVisible = true
            signInButton.isVisible = true
        }

    }

    private fun signIn() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        if (email.isNotEmpty() && password.isNotEmpty()) {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "signInWithEmail:success")
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        Log.w(TAG, "signInWithEmail:failure", task.exception)
                        Snackbar.make(container, "Authentication failed.", Snackbar.LENGTH_SHORT)
                            .show()
                        updateUI(null)
                    }
                }
        } else {
            Snackbar.make(container, "Invalid Email or Password.", Snackbar.LENGTH_SHORT)
                .show()
        }
    }

    // for debug
    private fun isPlayServicesAvailable(): Boolean {
        val googleAPI = GoogleApiAvailability.getInstance()
        return googleAPI.isGooglePlayServicesAvailable(this) == ConnectionResult.SUCCESS
    }
}
