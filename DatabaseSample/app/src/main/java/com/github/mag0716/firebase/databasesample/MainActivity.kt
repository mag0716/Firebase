package com.github.mag0716.firebase.databasesample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "DatabaseSample"
    }

    private lateinit var database: FirebaseFirestore
    private lateinit var addButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = FirebaseFirestore.getInstance()

        addButton = findViewById(R.id.add_button)
        addButton.setOnClickListener { addData() }
    }

    private fun addData() {
        val data = hashMapOf(
            "datetime" to System.currentTimeMillis(),
            "data" to "data"
        )

        database.collection("data")
            .add(data)
            .addOnSuccessListener { documentReference ->
                Log.d(
                    TAG,
                    "addData success: ${documentReference.id}"
                )
            }
            .addOnFailureListener { e -> Log.w(TAG, "addData failure", e) }
    }
}
