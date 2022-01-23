package com.example.friends

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.friends.adapter.ContactAdapter
import com.example.friends.data.DataSource

class ContactsActivity : AppCompatActivity() {

    // Constants to pass value among activities
    companion object{
        const val  LETTER = "letter"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        // Get DataSet
        val letter = intent?.extras?.getString(LETTER).toString()
        val dataSource = DataSource()
        val filteredContacts = dataSource.loadStartingWith(letter)

        // Set up RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.contacts_recycler_view)
        recyclerView.adapter = ContactAdapter(filteredContacts)
        recyclerView.setHasFixedSize(true)

    }
}