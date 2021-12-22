package com.example.friends

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.friends.adapter.LetterAdapter
import com.example.friends.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataSource = DataSource()

        val letters = dataSource.loadLetters(this)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = LetterAdapter(letters, this)
        recyclerView.setHasFixedSize(true)
    }
}