package com.example.gc_3

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import memorygame.Board

class MainActivity : AppCompatActivity() {
    private lateinit var card1: ImageView
    private lateinit var card2: ImageView
    private lateinit var card3: ImageView
    private lateinit var card4: ImageView
    private lateinit var card5: ImageView
    private lateinit var card6: ImageView

    private lateinit var board: Board

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        board = Board()



        card1 = findViewById(R.id.card_1)
        card1.setOnClickListener { view:View ->
            onClick(view)
        }
        card2 = findViewById(R.id.card_2)
        card2.setOnClickListener { view:View ->
            onClick(view)
        }
        card3 = findViewById(R.id.card_3)
        card3.setOnClickListener { view:View ->
            onClick(view)
        }
        card4 = findViewById(R.id.card_4)
        card4.setOnClickListener { view:View ->
            onClick(view)
        }
        card5 = findViewById(R.id.card_5)
        card5.setOnClickListener { view:View ->
            onClick(view)
        }
        card6 = findViewById(R.id.card_6)
        card6.setOnClickListener { view:View ->
            onClick(view)
        }
    }

    fun getCardID(view: View): Int {
        when (view) {
            card1 -> return 0
            card2 -> return 1
            card3 -> return 2
            card4 -> return 3
            card5 -> return 4
            else -> return 5
        }
    }

    fun onClick(view: View) {
        view as ImageView
        //Snackbar.make(view, "Button ${resources.getResourceEntryName(view.id)} was clicked", Snackbar.LENGTH_SHORT).show()
        var card =  board.getValueAt(getCardID(view))
        view.setImageResource(getImageID(card))
    }

    fun getImageID(card: Board.Card) : Int {
        var imageName = "card_"
        when (card.suit) {
            'c' -> imageName += "clubs_"
            'h' -> imageName += "hearts_"
            'd' -> imageName += "diamonds_"
            's' -> imageName += "spades_"
        }
        when (card.rank) {
            "2" -> imageName += "2"
            "3" -> imageName += "3"
            "4" -> imageName += "4"
            "5" -> imageName += "5"
            "6" -> imageName += "6"
            "7" -> imageName += "7"
            "8" -> imageName += "8"
            "9" -> imageName += "9"
            "10" -> imageName += "10"
            "j" -> imageName += "j"
            "q" -> imageName += "q"
            "k" -> imageName += "k"
            "a" -> imageName += "a"
        }

        return resources.getIdentifier(imageName.toString(), "drawable", packageName)
    }
}