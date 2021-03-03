package com.example.training

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var button_0: TextView
    private lateinit var button_1: TextView
    private lateinit var button_2: TextView
    private lateinit var button_3: TextView
    private lateinit var button_4: TextView
    private lateinit var button_5: TextView
    private lateinit var button_6: TextView
    private lateinit var button_7: TextView
    private lateinit var button_8: TextView
    private lateinit var button_9: TextView
    private lateinit var minus_button: TextView
    private lateinit var plus_button: TextView
    private lateinit var star_button: TextView
    private lateinit var div_button: TextView
    private lateinit var open_button: TextView
    private lateinit var close_button: TextView
    private lateinit var clear_button: TextView
    private lateinit var equal_button: TextView
    private lateinit var exponentation_button: TextView
    private lateinit var squareRoot_button: TextView
    private lateinit var math_operation: TextView
    private lateinit var result_text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_0 = findViewById(R.id.btn0)
        button_1 = findViewById(R.id.btn1)
        button_2 = findViewById(R.id.btn2)
        button_3 = findViewById(R.id.btn3)
        button_4 = findViewById(R.id.btn4)
        button_5 = findViewById(R.id.btn5)
        button_6 = findViewById(R.id.btn6)
        button_7 = findViewById(R.id.btn7)
        button_8 = findViewById(R.id.btn8)
        button_9 = findViewById(R.id.btn9)
        minus_button = findViewById(R.id.minus_btn)
        plus_button = findViewById(R.id.plus_btn)
        star_button = findViewById(R.id.star_btn)
        div_button = findViewById(R.id.div_btn)
        open_button = findViewById(R.id.open_btn)
        close_button = findViewById(R.id.close_btn)
        clear_button = findViewById(R.id.clear_btn)
        equal_button = findViewById(R.id.ravno_btn)
        exponentation_button = findViewById(R.id.exp_btn)
        squareRoot_button = findViewById(R.id.sqrRoot_btn)
        math_operation = findViewById(R.id.mth_operation)
        result_text = findViewById(R.id.res_text)
    }

    override fun onStart() {
        super.onStart()
        button_0.setOnClickListener { setTextFields("0") }
        button_1.setOnClickListener { setTextFields("1") }
        button_2.setOnClickListener { setTextFields("2") }
        button_3.setOnClickListener { setTextFields("3") }
        button_4.setOnClickListener { setTextFields("4") }
        button_5.setOnClickListener { setTextFields("5") }
        button_6.setOnClickListener { setTextFields("6") }
        button_7.setOnClickListener { setTextFields("7") }
        button_8.setOnClickListener { setTextFields("8") }
        button_9.setOnClickListener { setTextFields("9") }
        minus_button.setOnClickListener { setTextFields("-") }
        plus_button.setOnClickListener { setTextFields("+") }
        star_button.setOnClickListener { setTextFields("*") }
        div_button.setOnClickListener { setTextFields("/") }
        open_button.setOnClickListener { setTextFields("(") }
        close_button.setOnClickListener { setTextFields(")") }
        exponentation_button.setOnClickListener { setTextFields("^") }
        squareRoot_button.setOnClickListener {
            setTextFields("sqrt")
        }
        clear_button.setOnClickListener {
            math_operation.setTextColor(Color.BLACK)
            result_text.setTextColor(Color.BLACK)
            math_operation.text = ""
            result_text.text = ""
        }
        equal_button.setOnClickListener {
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()
                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    result_text.text = longRes.toString()
                else
                    result_text.text = result.toString()
            } catch (e: Exception){
                val er = "Error!"
                result_text.setTextColor(Color.RED)
                math_operation.setTextColor(Color.RED)
                result_text.text = er
            }
        }
    }

    fun setTextFields(str : String){
        if (result_text.text != "") {
            math_operation.text = result_text.text
            result_text.text = ""
        }
        math_operation.append(str)
    }

    override fun onStop() {
        super.onStop()
        button_0.setOnClickListener(null)
        button_1.setOnClickListener(null)
        button_2.setOnClickListener(null)
        button_3.setOnClickListener(null)
        button_4.setOnClickListener(null)
        button_5.setOnClickListener(null)
        button_6.setOnClickListener(null)
        button_7.setOnClickListener(null)
        button_8.setOnClickListener(null)
        button_9.setOnClickListener(null)
        minus_button.setOnClickListener(null)
        plus_button.setOnClickListener(null)
        star_button.setOnClickListener(null)
        div_button.setOnClickListener(null)
        open_button.setOnClickListener(null)
        close_button.setOnClickListener(null)
        exponentation_button.setOnClickListener(null)
        squareRoot_button.setOnClickListener(null)
        equal_button.setOnClickListener(null)
    }
}