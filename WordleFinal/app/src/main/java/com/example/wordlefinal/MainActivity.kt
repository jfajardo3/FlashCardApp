package com.example.wordlefinal


import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var wordToGuess = ""
    var attempts = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wordTextView = findViewById<TextView>(R.id.wordToGuessTV)
        val guessCheckTV = findViewById<TextView>(R.id.guessNumTV)
        val resultTV = findViewById<TextView>(R.id.userGuessTV)
        val guessButton = findViewById<Button>(R.id.button)
        var userInput = findViewById<EditText>(R.id.userGuess)




        wordToGuess = FourLetterWordList.getRandomFourLetterWord()
        wordTextView.text = wordToGuess


        guessButton.setOnClickListener {

                val guessWord = userInput.text.toString().uppercase()
                val answer = checkGuess(guessWord)
                val guesses = guessCheckTV.text
                val results = resultTV.text

                userInput.text.clear()

                guessCheckTV.text = StringBuilder(guesses).append("\nGuess #$attempts\nGuess #$attempts Check\n").toString()
                resultTV.text = StringBuilder(results).append("\n" + guessWord + "\n" + answer + "\n").toString()

                if(guesses.isEmpty()){
                    guessCheckTV.text = StringBuilder(guesses).append("Guess #$attempts\nGuess #$attempts Check").toString()
                    resultTV.text = StringBuilder(results).append(guessWord + "\n" + answer).toString()
                }
                else{
                    guessCheckTV.text = StringBuilder(guesses).append("\nGuess #$attempts\nGuess #$attempts Check").toString()
                    resultTV.text = StringBuilder(results).append("\n" + guessWord + "\n" + answer).toString()
                }

                if(answer == "0000"){
                    userInput.isEnabled = false
                    guessButton.isEnabled = false
                }
                else if(attempts == 3){
                    userInput.isEnabled = false
                    guessButton.isEnabled = false
                    wordTextView.visibility = View.VISIBLE
                }
                else{
                    attempts++
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

}
