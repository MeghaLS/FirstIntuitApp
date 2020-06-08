package com.example.firstintuitapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var currentNumPeople: Int = 0;

    fun showCurrentNumPeople(): Unit {
        if (maxCount.text.toString().isNotEmpty()) {
            val maxCountNum = maxCount.text.toString().toInt(); // Is this the right thing to do? => Yes
            //Fixed variables for color? => colors.xml
            if (currentNumPeople <= 0.8 * maxCountNum) {
                myTitle.setTextColor(Color.parseColor("#15c433"));
            } else if (currentNumPeople > 0.8 * maxCountNum && currentNumPeople <= maxCountNum) {
                myTitle.setTextColor(Color.parseColor("#ffff00"));
            } else if (currentNumPeople > maxCountNum) {
                myTitle.setTextColor(Color.parseColor("#e71837"));
            }
        }
        myTitle.text = """${currentNumPeople} people in the stadium"""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showCurrentNumPeople();

        comeIn.setOnClickListener{
            currentNumPeople++
            showCurrentNumPeople()
        }
        // Std way of setting on
        this.goingOut.setOnClickListener{
            if (currentNumPeople > 0) {
                currentNumPeople--
                showCurrentNumPeople()
            }
        }
        this.clearButton.setOnClickListener{
            currentNumPeople = 0
            showCurrentNumPeople();
        }

    }
}
