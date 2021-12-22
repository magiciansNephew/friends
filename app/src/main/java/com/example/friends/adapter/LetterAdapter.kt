package com.example.friends.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.friends.R

class LetterAdapter(
    private val dataset: List<String>,
    private val context: Context
    ): RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    class LetterViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val button: Button = view.findViewById<Button>(R.id.button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.letter_item,parent,false)
        return LetterViewHolder(view)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = dataset[position]
        holder.button.text = item
    }

    // Return the size of your dataset (invoked by layout manager)
    override fun getItemCount() = dataset.size

}