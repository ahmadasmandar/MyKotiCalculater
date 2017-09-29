package com.example.eng_ahmad.mykoticalculater

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

import kotlin.String

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast.text=number1.toString()
    }

    var isnewOp =true
    var isPluspressed =false
    var minp=0
    val rchar:Char='-'
    var stringResult:String?=null
    var number1:Double=0.0
    var number2:Double=0.0
    var numberres:Double=0.0
    var operationbu:String?=null
    fun buNumberEvent(view: View)
    {

        if (isnewOp)
        {
            txtResult.text=""
        }

        isnewOp =false
        var txResult:String= txtResult.text.toString()
        val buSelect = view as Button


        when(buSelect.id) {
            bu0.id -> {
                txResult += "0"
            }
            bu1.id -> {
                txResult += "1"
            }
            bu2.id -> {
                txResult += "2"
            }
            bu3.id -> {
                txResult += "3"
            }
            bu4.id -> {
                txResult += "4"
            }
            bu5.id -> {
                txResult += "5"
            }
            bu6.id -> {
                txResult += "6"
            }
            bu7.id -> {
                txResult += "7"
            }
            bu8.id -> {
                txResult += "8"
            }
            bu9.id -> {
                txResult += "9"
            }
            buPlus.id -> {
                txResult = "-" + txResult
                isPluspressed = true
                minp = minp + 1

            }
            buDot.id -> {
                txResult += "."
            }
            buSum.id -> {
                operationbu = "sum"
                number1 = txResult.toDouble()
                txResult = ""
            }
            buDiv.id -> {
                while (number2!=0.0)
                {
                    operationbu = "div"
                    number1 = txResult.toDouble()
                    txResult = ""
                }

            }
            buMin.id -> {
                operationbu = "min"
                number1 = txResult.toDouble()
                txResult = ""
            }
            buMul.id -> {
                operationbu = "mul"
                number1 = txResult.toDouble()
                txResult = ""
            }
            buEq.id -> {
                number2 = txResult.toDouble()
                when (operationbu) {
                    "sum" -> {
                        numberres = (number1 + number2)
                    }
                    "min" -> {
                        numberres = (number1 - number2)
                    }

                    "div" -> {
                        while (number2!=0.0)
                        {
                            numberres = (number1 / number2)
                        }
                    }
                    "mul" -> {
                        numberres = (number1 * number2)

                    }
                }
                txResult = numberres.toString()
            }
        }
        toast.text=number1.toString()
        val stringCheck=txResult
        /* The check process for - signal if putet
        more than one time
        under function name pluspressed()
         */
        stringResult=txResult
        fun pluspressed():String{
            if(isPluspressed && minp==2)
            {
                stringResult=stringCheck.replace(rchar.toString(),"")
                minp=0
            }
            else
            {
                stringResult=txResult
            }
            return stringResult as String
        }
        txtResult.text=stringResult
    }
    fun acClearView(view: View){
        txtResult.text=""
    }
}
