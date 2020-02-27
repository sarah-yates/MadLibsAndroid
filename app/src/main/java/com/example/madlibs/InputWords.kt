package com.example.madlibs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.activity_input_words.*
import java.io.File
import java.util.*


class InputWords : AppCompatActivity() {
    var lines = ""
    var userInputS = ""
    var count = 0
    var firstWord = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_words)
        if (intent != null) {
            val filename = intent.getStringExtra("clicked")
            val fileID = resources.getIdentifier(filename, "raw", packageName)
            val inputFile = Scanner(resources.openRawResource(fileID))
            lines = inputFile.nextLine()
            firstWord = Regex("[<](.*?)[>]").find(lines)!!.value
            val words = Regex("[<](.*?)[>]").findAll(lines)
            userInput.hint = firstWord.substring(1,firstWord.length-1)
            for (findText in words) {
                count++
            }
            wordsRemaining.text = "$count words remaining"

        }

    }

    fun nextButtonClicked(view: View) {
        wordsRemaining.text = "${count - 1} words remaining"
        userInputS = userInput.text.toString()
        lines = lines.replaceFirst(firstWord,userInputS.toUpperCase())
        count -= 1
        if(count > 0){
            firstWord = Regex("[<](.*?)[>]").find(lines)!!.value
            userInput.hint = firstWord.substring(1,firstWord.length-1)
        }else{
            userInput.hint = "Click See Story Button!"
        }
        userInput.text.clear()
    }

    fun seeStoryClicked(view: View) {
        val myIntent = Intent(this, FinalStory::class.java)
        myIntent.putExtra("newStory", lines)
        startActivity(myIntent)
    }
}

