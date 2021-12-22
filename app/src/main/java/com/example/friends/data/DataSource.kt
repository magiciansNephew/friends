package com.example.friends.data

import android.content.Context
import com.example.friends.R
import com.example.friends.modal.Contact

// Class to prepare contacts data
class DataSource {

    // Function to load Contact list
    fun loadContacts(context: Context): List<Contact>{
        val names = context.resources.getStringArray(R.array.names).toList()
        val numbers = context.resources.getStringArray(R.array.numbers).toList()
        val contactList = mutableListOf<Contact>()

        for (i in names.indices) {
            contactList.add(Contact(names[i],numbers[i]))
        }
        return contactList
    }

    // Function to load first letters of all the names
    fun loadLetters(context: Context): List<String>{
        val letters = mutableListOf<String>()
        val names = context.resources.getStringArray(R.array.names).toList()
        var letter: String

        names.forEach {
            letter = it[0].toString()
            if (!letters.contains(letter)){
                letters.add(letter)
            }
        }
        return letters.sorted()
    }
}