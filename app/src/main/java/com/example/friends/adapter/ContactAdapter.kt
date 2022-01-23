package com.example.friends.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.friends.R
import com.example.friends.modal.Contact
import com.google.android.material.card.MaterialCardView

class ContactAdapter (
    private val dataSet: List<Contact>
        ):
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    // Class providing reference to all the views to represent an Item
    class ContactViewHolder (val view: View): RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.item_name)
        val number = view.findViewById<TextView>(R.id.item_number)
        val wrapper = view.findViewById<MaterialCardView>(R.id.contact_wrapper)
    }

    // Return Item View Holder view made with Item Layout template
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.contact_item, parent, false )
        return ContactViewHolder(view)
    }

    // Function to replace the contents of the Item Views
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = dataSet[position]
        holder.name.text = item.name
        holder.number.text = item.number
        holder.wrapper.setOnClickListener {
            val context = holder.view.context
            val number: Uri = Uri.parse("tel:${item.number}")
            val intent = Intent(Intent.ACTION_DIAL, number)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataSet.size
}