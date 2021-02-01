package com.example.colormyview

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.colormyview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
        binding.resetButton.setOnClickListener { reset(it) }
    }
    private fun makeColored(view: View){
        when(view.id){
            R.id.box_one -> view.setBackgroundColor(Color.BLACK)
            R.id.box_two -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_three -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five -> view.setBackgroundColor(Color.CYAN)
            R.id.red_button -> binding.boxThree.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> binding.boxFour.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> binding.boxFive.setBackgroundResource(R.color.my_green)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
    private fun reset(view: View){
        binding.boxOne.setBackgroundResource(R.color.white)
        binding.boxTwo.setBackgroundResource(R.color.white)
        binding.boxThree.setBackgroundResource(R.color.white)
        binding.boxFour.setBackgroundResource(R.color.white)
        binding.boxFive.setBackgroundResource(R.color.white)
        binding.constraintLayout.setBackgroundResource(R.color.white)
    }
    private fun setListeners(){
        val clickableViews : List<View> =
            listOf( binding.boxOne, binding.boxTwo, binding.boxThree, binding.boxFour, binding.boxFive, binding.constraintLayout, binding.redButton, binding.yellowButton, binding.greenButton, binding.resetButton)
        for (item in clickableViews){
            item.setOnClickListener { makeColored(it) }
        }
    }
}