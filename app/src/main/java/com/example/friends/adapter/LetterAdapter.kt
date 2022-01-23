package com.example.friends.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.friends.ContactsActivity
import com.example.friends.R

class LetterAdapter(
    private val dataset: List<String>
): RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    // Provides reference to views needed to display the items
    class LetterViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val button: Button = view.findViewById<Button>(R.id.button_item)
    }

    // Creates new Item View Holder with the Item Layout template
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.letter_item,parent,false)
        return LetterViewHolder(view)
    }

    // Bind data to the Item Views
    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = dataset[position]
        holder.button.text = item
        holder.button.setOnClickListener {
            val context = holder.view.context
            val intent = Intent(context, ContactsActivity::class.java)
            intent.putExtra(ContactsActivity.LETTER, holder.button.text.toString())
            context.startActivity(intent)
        }
    }

    // Return the size of your dataset (invoked by layout manager)
    override fun getItemCount() = dataset.size

}