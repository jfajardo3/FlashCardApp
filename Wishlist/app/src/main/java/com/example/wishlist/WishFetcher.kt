package com.example.wishlist

import android.R
import android.widget.EditText



class WishFetcher {
    companion object{
        private var wishes: MutableList<Wish> = ArrayList()


        fun getWishes(): MutableList<Wish> {


//            val wish = Wish(productString, priceString, urlString)
//            wishes.add(wish)

            return wishes
        }

        fun addWishes(productString: String, priceString: String, urlString: String) {
            val wish = Wish(productString, priceString, urlString)
            wishes.add(wish)
        }

//        fun getNewWishes(): MutableList<Wish> {
//            var newWishes : MutableList<Wish> = ArrayList()
//            for (i in 10..14) {
//                val wish = Wish(productString[i], priceString[i], urlString[i])
//                newWishes.add(wish)
//            }
//            return newWishes
//        }

    }
}
