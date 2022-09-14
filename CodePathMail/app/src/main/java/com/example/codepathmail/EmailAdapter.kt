package com.example.codepathmail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private val emails: List<Email>): RecyclerView.Adapter<EmailAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        // TODO: Create member variables for any view that will be set
        // as you render a row.

        val senderTextView: TextView
        val titleTextView: TextView
        val summaryTextView: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            senderTextView = itemView.findViewById(R.id.senderTV)
            titleTextView = itemView.findViewById(R.id.titleTV)
            summaryTextView = itemView.findViewById(R.id.summaryTV)
        }
            // TODO: Store each of the layout's views into
            // the public final member variables created above
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflator = LayoutInflater.from(context)

        val contactView = inflator.inflate(R.layout.email_item, parent, false)

        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val email = emails.get(position)

        holder.senderTextView.text = email.sender
        holder.titleTextView.text = email.title
        holder.summaryTextView.text = email.summary

    }

    override fun getItemCount(): Int {
        return emails.size
    }
}