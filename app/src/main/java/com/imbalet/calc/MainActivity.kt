package com.imbalet.calc

import android.os.Bundle
import android.text.InputType
import androidx.appcompat.app.AppCompatActivity
import com.imbalet.calc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var sign: String = ""
    var first: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextNumber.inputType = InputType.TYPE_CLASS_NUMBER or
                InputType.TYPE_NUMBER_FLAG_DECIMAL or
                InputType.TYPE_NUMBER_FLAG_SIGNED

        binding.buttonplus.setOnClickListener{
            getNumber("+")
        }
        binding.buttonminus.setOnClickListener{
            getNumber("-")
        }
        binding.buttondivide.setOnClickListener{
            getNumber("/")
        }
        binding.buttonmultiply.setOnClickListener{
            getNumber("*")
        }
        binding.buttonequals.setOnClickListener{

                getResult(sign,first,binding.editTextNumber.text.toString())
        }
    }
    fun getNumber(s:String){
        if (binding.editTextNumber.text.isBlank()){
            binding.editTextNumber.error = "НИЗЗЯ"
        }
        else {
            first = binding.editTextNumber.text.toString().toDouble()
            sign = s
            binding.textView.text = first.toString() + s
            binding.editTextNumber.setText("")
        }
    }
    fun getResult(s:String, _first:Double, _second:String){
        if (_second.toString() contentEquals  "" || ((_second.toString().toDouble() == 0.0)&&(sign == "/"))){
            binding.editTextNumber.error = "НИЗЗЯ"
        }
        else{
            val second: Double = _second.toDouble()
            val temp = _first.toString() + s + second.toString() + "="
            val value: Double
            when (s) {
                "+" -> value =
                    _first + second
                "-" -> value =
                    _first - second
                "/" -> value =
                    _first / second
                "*" -> value =
                    _first * second
                else -> value =
                    0.0
            }

            binding.textView.text = temp + value
        }
    }
}