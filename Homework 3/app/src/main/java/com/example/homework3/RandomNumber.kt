package com.example.homework3


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_random_number.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class RandomNumber : Fragment(), View.OnClickListener {

    var navController: NavController? = null

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.toDiceRoller -> navController!!.navigate(R.id.action_randomNumber_to_diceRoller)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.toDiceRoller).setOnClickListener(this)

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

                Toast.makeText(this.context, "Must enter values!", Toast.LENGTH_SHORT).show()

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_random_number, container, false)
    }



}
