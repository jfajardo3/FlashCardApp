package com.example.wordletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    val wordTextView = findViewById<TextView>(textView)
    val guessCheckTV = findViewById<TextView>(guessNumTV)
    val resultTV = findViewById<TextView>(userGuessTV)
    val guessButton = findViewById<Button>(button)
    var userInput = findViewById<EditText>(R.id.userGuess)
    var wordToGuess = ""




    var attempts = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        wordToGuess = FourLetterWordList.getRandomFourLetterWord()
        wordTextView.text = wordToGuess


        guessButton.setOnClickListener {
            val size = userInput.length()

            if (size < 4){
                Toast.makeText(this, "TOO SHORT", Toast.LENGTH_SHORT).show()
            }
            else{
                val guessWord = userInput.text.toString().uppercase()
                val answer = checkGuess(guessWord)
                val guesses = guessCheckTV.text
                val results = resultTV.text

                userInput.text.clear()

                guessCheckTV.text = StringBuilder(guesses).append("\nGuess #$attempts\nGuess #$attempts Check\n").toString()
                resultTV.text = StringBuilder(results).append("\n" + guessWord + "\n" + answer + "\n").toString()

                if(answer == "0000"){
                    userInput.isEnabled = false
                    guessButton.isEnabled = false
                }
                else if(attempts == 4){
                    userInput.isEnabled = false
                    guessButton.isEnabled = false
                    wordTextView.visibility = View.VISIBLE
                }
                else{
                    attempts++
                }

            }

        }




    }

    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }







//
//    var attempts = 0
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//
//        //val textView = findViewById<TextView>(R.id.textView)
//        val guessButton = findViewById<Button>(R.id.button)
//        val userGuessTV = findViewById<TextView>(R.id.userGuessTV)
//
//        var userInput = findViewById<EditText>(R.id.userGuess)
//        var stringInput = userInput.text.toString()
//
//        val guesses = userGuessTV.text
//
//
//        userGuessTV.text = StringBuilder(guesses).append("\n" + stringInput + "\n" + check + "\n").toString()
//        userGuessTV.visibility = View.VISIBLE
//
//
//        guessButton.setOnClickListener {
//            Toast.makeText(it.context, "Clicked Button!", Toast.LENGTH_SHORT).show()
////            attempts++
////            textView.text = attempts.toString()
////
////            if(attempts >= 100){
////                upgradeButton.visibility = View.VISIBLE
////
////                upgradeButton.setOnClickListener {
////                    button.text = "ADD 2"
////
////                    button.setOnClickListener{
////                        attempts += 2
////                        textView.text = attempts.toString()
////                    }
////
////                    upgradeButton.visibility = View.INVISIBLE
////                }
////            }
//        }

    


}