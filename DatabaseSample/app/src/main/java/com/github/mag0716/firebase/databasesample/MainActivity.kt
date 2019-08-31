package com.github.mag0716.firebase.databasesample

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "DatabaseSample"
        const val DB_NAME = "data"
    }

    private lateinit var database: FirebaseFirestore
    private lateinit var indicator: ProgressBar
    private lateinit var list: RecyclerView
    private lateinit var addButton: FloatingActionButton

    private lateinit var adapter: DataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = FirebaseFirestore.getInstance()

        adapter = DataAdapter()

        indicator = findViewById(R.id.indicator)
        list = findViewById(R.id.list)
        list.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        addButton = findViewById(R.id.add_button)
        addButton.setOnClickListener { addData() }

        if (savedInstanceState == null) {
            indicator.visibility = View.VISIBLE
            database.collection(DB_NAME)
                .get()
                .addOnSuccessListener { result ->
                    val list = mutableListOf<Data>()
                    result.forEach {
                        Log.d(TAG, "$it")
                        list.add(Data(it["datetime"] as Long, it["data"] as String))
                    }
                    adapter.addData(list)
                }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting documents.", exception)
                }
                .addOnCompleteListener { indicator.visibility = View.GONE }
        }
    }

    private fun addData() {
        val data = hashMapOf(
            "datetime" to System.currentTimeMillis(),
            "data" to "data"
        )

        database.collection(DB_NAME)
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
