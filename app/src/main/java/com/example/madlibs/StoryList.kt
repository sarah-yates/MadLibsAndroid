package com.example.madlibs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class StoryList : AppCompatActivity() {

    private val stories = arrayOf("simple_story","clothes","dr_sykes_welcome","dance","tarzan","university")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story_list)

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, stories)
        val listView:ListView = findViewById(R.id.storyLists)
        listView.adapter = adapter

        listView.onItemClickListener =
            AdapterView.OnItemClickListener { _, view, position, _ ->
                val itemValue = listView.getItemAtPosition(position)as String
                storyClicked(view, itemValue)
            }

    }
    fun storyClicked(view: View,item: String){
        val myIntent = Intent(this, InputWords::class.java)
        myIntent.putExtra("clicked", item)
        startActivity(myIntent)
    }
}
