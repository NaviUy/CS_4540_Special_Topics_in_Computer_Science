package com.example.randomnumbergenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //previousMin and previousMax used for checking if the numbers are the same

        var previousMin: Int? = null
        var previousMax: Int? = null

        //list of numbers used to check if the numbers already used

        val numbers = mutableListOf<Int>()

        //handle checkmark

        replacement_toggle.setOnClickListener(){

            minimum.text.clear()
            maximum.text.clear()

        }

        //handle button

        get_number.setOnClickListener() {

            //checking to see that minimum and maximum is not empty

            if (minimum.text.toString() == "" || maximum.text.toString() == "") {

                Toast.makeText(this, "Must enter values!", Toast.LENGTH_SHORT).show()

            } else {

                //change max and min

                val minDigit = minimum.text.toString().toInt()
                val maxDigit = maximum.text.toString().toInt() + 1

                //is replacement toggled?

                if (replacement_toggle.isChecked) {

                    //setting previous numbers if there doesnt exist one

                    if (previousMin == null && previousMax == null) {

                        previousMin = minimum.text.toString().toInt()
                        previousMax = maximum.text.toString().toInt()

                    }

                    //checking to see if previous numbers are the same

                    if (previousMin != minimum.text.toString().toInt() || previousMax != maximum.text.toString().toInt()) {

                        numbers.clear()
                        previousMin = minimum.text.toString().toInt()
                        previousMax = maximum.text.toString().toInt()

                    }

                    //max and min numbers


                    //checking to see if there are numbers available

                    if (maxDigit - minDigit != numbers.size) {

                        //generate random number

                        var randomNumber = Random().nextInt((maxDigit - minDigit)) + minDigit

                        //if the number already exist generate a new one

                        while (numbers.contains(randomNumber)) {
                            randomNumber = Random().nextInt((maxDigit - minDigit)) + minDigit
                        }

                        // add the number to list of its already been picked

                        numbers.add(randomNumber)
                        output.text = randomNumber.toString()

                    } else {

                        //if out of numbers, let the user know

                        output.text = "Out of Numbers!"

                    }

                } else {

                    //if toggle if off, just generate a random number

                    //numbers cleared in case user toggled off replacement

                    numbers.clear()

                    val randomNumber = Random().nextInt((maxDigit - minDigit)) + minDigit

                    output.text = randomNumber.toString()

                }

            }

        }

    }

}