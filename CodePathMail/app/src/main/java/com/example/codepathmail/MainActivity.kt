package com.example.codepathmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var emails: MutableList<Email>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val emailsRV = findViewById<RecyclerView>(R.id.emailsRV)
        emails = EmailFetcher.getEmails()

        val adapter = EmailAdapter(emails)

        emailsRV.adapter = adapter
        emailsRV.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.loadBTN).setOnClickListener{
            val newEmails = EmailFetcher.getNext5Emails()
            emails.addAll(newEmails)
            adapter.notifyDataSetChanged()
        }

    }
}