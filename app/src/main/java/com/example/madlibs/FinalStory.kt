package com.example.madlibs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_final_story.*

class FinalStory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_story)
        if(intent != null) {
            val finishedStory = intent.getStringExtra("newStory")
            finalStoryText.text = finishedStory
        }
    }
}
