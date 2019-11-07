package com.example.homework3


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*
import androidx.navigation.NavController
import androidx.navigation.Navigation

/**
 * A simple [Fragment] subclass.
 */
class DiceRoller : Fragment(), View.OnClickListener{

    var navController: NavController? = null

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.toTipCalculator -> navController!!.navigate(R.id.action_diceRoller_to_tipCalculator)
        }
    }

    lateinit var diceImage: ImageView
    lateinit var diceImage2: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        diceImage = view.findViewById(R.id.dice_image)
        diceImage2 = view.findViewById(R.id.dice2_image)
        val rollButton: Button = view.findViewById(R.id.roll_button)
        rollButton.setOnClickListener{rollDice(); rollDice2()}

        navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.toTipCalculator).setOnClickListener(this)
    }

    private fun rollDice() {

        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }


        diceImage.setImageResource(drawableResource)
    }
    private fun rollDice2() {

        val randomInt = Random().nextInt(6) + 1
        val drawableResource = when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }


        diceImage2.setImageResource(drawableResource)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dice_roller, container, false)
    }


}
