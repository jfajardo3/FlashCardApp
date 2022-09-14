package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishAdapter(private val wishes: List<Wish>): RecyclerView.Adapter<WishAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        // TODO: Create member variables for any view that will be set
        // as you render a row.

        val productTextView: TextView
        val priceTextView: TextView
        val urlTextView: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            productTextView = itemView.findViewById(R.id.productTV)
            priceTextView = itemView.findViewById(R.id.priceTV)
            urlTextView = itemView.findViewById(R.id.urlTV)
        }
        // TODO: Store each of the layout's views into
        // the public final member variables created above
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflator = LayoutInflater.from(context)

        val contactView = inflator.inflate(R.layout.wish_item, parent, false)

        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wish = wishes[position]

        holder.productTextView.text = wish.productString
        holder.priceTextView.text = wish.priceString
        holder.urlTextView.text = wish.urlString

    }

    override fun getItemCount(): Int {
        return wishes.size
    }
}