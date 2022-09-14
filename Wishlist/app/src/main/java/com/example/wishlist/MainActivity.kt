package com.example.wishlist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
   lateinit var wishes: MutableList<Wish>

//    val productEditText = findViewById<EditText>(R.id.inputProductET)
//    val priceEditText = findViewById<EditText>(R.id.inputPriceET)
//    val urlEditText = findViewById<EditText>(R.id.inputURLET)


    //var wishesRV = findViewById<RecyclerView>(R.id.wishRV)

//@SuppressLint("NotifyDataSetChanged")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var productEditText = findViewById<EditText>(R.id.inputProductET)
        var priceEditText = findViewById<EditText>(R.id.inputPriceET)
        var urlEditText = findViewById<EditText>(R.id.inputURLET)
        val submitButton = findViewById<Button>(R.id.submitBTN)
        val wishesRV = findViewById<RecyclerView>(R.id.wishRV)


        wishes = WishFetcher.getWishes()
        val adapter = WishAdapter(wishes)
        wishesRV.adapter = adapter
        wishesRV.layoutManager = LinearLayoutManager(this)



        findViewById<Button>(R.id.submitBTN).setOnClickListener{


            var productString = productEditText.text.toString()
            var priceString = priceEditText.text.toString()
            var urlString = urlEditText.text.toString()




            productEditText.text.clear()
            priceEditText.text.clear()
            urlEditText.text.clear()

            wishes = WishFetcher.getWishes()
            WishFetcher.addWishes(productString, priceString, urlString)
         //   val newWishes = WishFetcher.getWishes()
            adapter.notifyDataSetChanged()

        }

    }
}