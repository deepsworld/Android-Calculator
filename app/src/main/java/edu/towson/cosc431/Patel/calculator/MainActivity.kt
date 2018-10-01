package edu.towson.cosc431.Patel.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import kotlinx.android.synthetic.main.activity_main.*
import android.R.attr.button
import android.R.attr.fastScrollPreviewBackgroundLeft

class MainActivity : AppCompatActivity() {

    var decimalValue = false
    var operator1 = " "
    var operator2 = " "

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        disableButtons()

        equalBtn.setOnClickListener{ calculateResult()}
        oneBtn.setOnClickListener { addOne() }
        twoBtn.setOnClickListener { addTwo() }
        threeBtn.setOnClickListener { addThree() }
        fourBtn.setOnClickListener { addFour() }
        fiveBtn.setOnClickListener { addFive() }
        sixBtn.setOnClickListener { addSix() }
        sevenBtn.setOnClickListener { addSeven() }
        eightBtn.setOnClickListener { addEight() }
        nineBtn.setOnClickListener { addNine() }
        zeroBtn.setOnClickListener { addZero() }
        addBtn.setOnClickListener { addAdd() }
        subBtn.setOnClickListener { addSub() }
        multiplyBtn.setOnClickListener { addMultiply() }
        divideBtn.setOnClickListener { addDivide() }
        dotBtn.setOnClickListener { addDot() }
        clearBtn.setOnClickListener { clearDisplay() }

    }

    private fun clearDisplay() {
        display.text = null
        decimalValue = false
        //disableButtons()
    }

    private fun addDot() {
        addToDisplay(".")
        decimalValue = true
        disableButtons()
    }

    private fun addDivide() {
        addToDisplay("/")
        operator1 = display.editableText.toString()
        clearDisplay()
        disableButtons()
    }

    private fun addMultiply() {
        addToDisplay("*")
        disableButtons()
    }

    private fun addSub() {
        addToDisplay("-")
    }

    private fun addAdd() {
        addToDisplay("+")
        operator1 = display.editableText.toString()
        clearDisplay()
        disableButtons()
    }

    private fun addZero() {
        enableButtons()
        addToDisplay("0")

    }

    private fun addNine() {
        enableButtons()
        addToDisplay("9")
    }

    private fun addEight() {
        enableButtons()
        addToDisplay("8")
    }

    private fun addSeven() {
        enableButtons()
        addToDisplay("7")
    }

    private fun addSix() {
        enableButtons()
        addToDisplay("6")
    }

    private fun addFive() {
        enableButtons()
        addToDisplay("5")
    }

    private fun addFour() {
        enableButtons()
        addToDisplay("4")
    }

    private fun addThree() {
        enableButtons()
        addToDisplay("3")
    }

    private fun addTwo() {
        enableButtons()
        addToDisplay("2")
    }

    private fun addOne() {
        enableButtons()
        addToDisplay("1")
    }

    private fun addToDisplay(value : String) {
        display.append(value)
    }

    private fun disableButtons(){
        for (i in 0 until linearLayout2.getChildCount()) {
            val child = linearLayout2.getChildAt(i)
            child.setEnabled(false)
        }
        subBtn.isEnabled = true
        dotBtn.isEnabled = false
    }
    private fun disableEqualButton(){
        equalBtn.isEnabled = false
    }

    private fun enableButtons(){
        for (i in 0 until linearLayout2.getChildCount()) {
            val child = linearLayout2.getChildAt(i)
            child.setEnabled(true)
        }
        dotBtn.isEnabled = true

    }

    // when equal button is clicked
    private fun calculateResult(){
        // get the input String from the edit text
        operator2 = display.editableText.toString()
        var result: String?
        if(operator1.isEmpty() || operator2.isEmpty())
        {
            result = "Enter value"
        }
        else {

            var op = " "//inputString.split("+","/","*")
            var op1 = " "//inputString.split("-","+","/","*")
            var op2 = " "//inputString.split("-")
                if(decimalValue){
                    if(inputString.contains("+")){
                        result = (add(op[0].toDouble(),op[1].toDouble())).toString()
                        result = operator2
                    }
                    else if(inputString.contains("*")){
                        result = (multiply(op[0].toDouble(),op[1].toDouble())).toString()
                    }
                    else if(inputString.contains("/")){
                        if(op[1].toDouble() == 0.0){
                            result = "Error"
                        }
                        else {
                            result = (divide(operator1.toDouble(), operator2.toDouble())).toString()
                        }
                    }
                    else {
                        if (inputString[0].toString().equals("-")){
                            result = (subtract(("-"+op2[1]).toDouble(),op2[2].toDouble())).toString()
                        }
                        else{
                            result = (subtract(op1[0].toDouble(),op1[1].toDouble())).toString()
                        }
                    }
                }

                else{
                    if(inputString.contains("+")){
                        result = (add(op[0].toInt(),op[1].toInt())).toString()
                    }
                    else if(inputString.contains("*")){
                        result = (multiply(op[0].toInt(),op[1].toInt())).toString()
                    }
                    else if(inputString.contains("/")){
                        if(op[1].toInt() == 0){
                            result = "Error"
                        }
                        else {
                            result = (divide(op[0].toDouble(), op[1].toDouble())).toString()
                        }
                    }
                    else {
                        if (inputString[0].toString().equals("-")){
                            result = (subtract(("-"+op2[1]).toInt(),op2[2].toInt())).toString()
                        }
                        else{
                            result = (subtract(op1[0].toInt(),op1[1].toInt())).toString()
                        }
                    }
                }
            }
        // display the result into the textView
        display.text = result.toString()
    }

    private fun add(num1: Double, num2: Double): Double{
        return num1 + num2
    }
    private fun add(num1: Int, num2: Int): Int{
        return num1 + num2
    }
    private fun subtract(num1: Double, num2: Double): Double{
        return num1 - num2
    }
    private fun subtract(num1: Int, num2: Int): Int{
        return num1 - num2
    }
    private fun multiply(num1: Double, num2: Double): Double{
        return num1 * num2
    }
    private fun multiply(num1: Int, num2: Int): Int{
        return num1 * num2
    }
    private fun divide(num1: Double, num2: Double): Double?{
        return num1/num2
    }





}
