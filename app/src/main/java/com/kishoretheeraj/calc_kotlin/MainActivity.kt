package com.kishoretheeraj.calc_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kishoretheeraj.calc_kotlin.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Numbers
        binding.btn00.setOnClickListener { appendClick(true, "00") }
        binding.btn0.setOnClickListener { appendClick(true, "0") }
        binding.btn1.setOnClickListener { appendClick(true, "1") }
        binding.btn2.setOnClickListener { appendClick(true, "2") }
        binding.btn3.setOnClickListener { appendClick(true, "3") }
        binding.btn4.setOnClickListener { appendClick(true, "4") }
        binding.btn5.setOnClickListener { appendClick(true, "5") }
        binding.btn6.setOnClickListener { appendClick(true, "6") }
        binding.btn7.setOnClickListener { appendClick(true, "7") }
        binding.btn8.setOnClickListener { appendClick(true, "8") }
        binding.btn9.setOnClickListener { appendClick(true, "9") }
        binding.btnDot.setOnClickListener { appendClick(true, ".") }

        //Symbols
        binding.btnPlus.setOnClickListener { appendClick(false, "+") }
        binding.btnMinus.setOnClickListener { appendClick(false, "-") }
        binding.btnDivide.setOnClickListener { appendClick(false, "/") }
        binding.btnMultiply.setOnClickListener { appendClick(false, "*") }
        binding.btnLeftB.setOnClickListener { appendClick(false, "(") }
        binding.btnRightB.setOnClickListener { appendClick(false, ")") }

        //Clear and calculate button
        binding.btnEqual.setOnClickListener { calculate() }
        binding.btnClear.setOnClickListener { clear() }

    }

    private fun appendClick(boolean: Boolean, string: String) {

        if (boolean) {
            binding.tvOutput.text = ""
            binding.tvInput.append(string)
        } else {
            binding.tvInput.append(binding.tvOutput.text)
            binding.tvInput.append(string)
            binding.tvOutput.text = ""
        }

    }

    private fun calculate() {
        try {
            val input= ExpressionBuilder(binding.tvInput.text.toString()).build()
            val output=input.evaluate()
            val longOutput=output.toLong()
            if (output==longOutput.toDouble())
            {
                binding.tvOutput.text=longOutput.toString()
                binding.tvInput.text=""

            }
            else{
                binding.tvOutput.text=output.toString()
            }

        } catch (e: Exception) {

        }

    }

    private fun clear() {
        binding.tvInput.text = ""
        binding.tvOutput.text = ""

    }

}