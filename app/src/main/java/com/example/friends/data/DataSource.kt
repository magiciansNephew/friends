package com.example.friends.data

import com.example.friends.modal.Contact

// Class to prepare contacts data
class DataSource {

    val contactsMap = mapOf(
        "Bill Clinton Maharjan" to "9860310633",
        "Sulav Poudel" to "9843443777",
        "Anish Maharjan" to "9860033020",
        "Kiran Shahi" to "9843792316",
        "Shiva Hari Koirala" to "9843876090",
        "Saroj Tamang" to "1234567890",
        "Trijan Manandhar" to "9813798388",
        "Ashish Adhikari" to "9843539558",
        "Gaurab Karki" to "0123456789",
        "Roshan Gurung" to "0123456789",
        "Prayash Sapkota" to "9843027896",
        "Ashish Rawal" to "9823026820",
        "Anjana Lama" to "9840168217",
        "Nitesh Bagale" to "9801882099",
        "Pranab Subedi" to "9860127858",
        "Rupesh Karki" to "9843743002",
        "Sagar Bakhati" to "9860779753",
        "Nishant Thakur" to "9804839203",
        "Susan Shrestha" to "9813972009",
        "Basudev Acharya" to "9860976440"
    )

    // Function to load Contact list
    fun loadContacts(): List<Contact> {
        val names = contactsMap.keys.toList()
        val numbers = contactsMap.values.toList()
        val contactList = mutableListOf<Contact>()

        for (i in names.indices) {
            contactList.add(Contact(names[i], numbers[i]))
        }
        return contactList
    }

    // Function to load first letters of all the names
    fun loadLetters(): List<String> {
        val letters = mutableListOf<String>()
        val names = contactsMap.keys.toList()
        var letter: String

        names.forEach {
            letter = it[0].toString()
            if (!letters.contains(letter)) {
                letters.add(letter)
            }
        }
        return letters.sorted()
    }
}