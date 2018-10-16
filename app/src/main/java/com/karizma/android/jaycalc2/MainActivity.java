package com.karizma.android.jaycalc2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    // String SPACE_B = " ";
    String resultView = "";
    String operatorSign = "";
    String opOneStr = "";
    String opTwoStr = "";
    boolean checkInitDecimal = true;
    int operandOne, operandTwo, operandType, result;
    int checkOperand = 0;
    float fOperandOne, fOperandTwo, fResult;

    /* Description of variables declared above found on comments in the clrMethod function */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayMessage(String message) {
        TextView resultDisplayed = findViewById(R.id.result_view);
        resultDisplayed.setText(message);
    }

    public void displayScreen (){
        resultView = opOneStr + operatorSign + opTwoStr;
        displayMessage(resultView);
    }

    public String noZeroTrails(float ans){
        String formatted;
        int noDecimal = (int) ans;
        if (noDecimal == ans) formatted = Integer.toString(noDecimal);
        else formatted = Float.toString(ans);

        return formatted;

    }

    /* Method for handling the equal sign (=) button */

    public void calcRes(View view) {

        if (checkOperand < 1) return; // check if number has been inputted
        avoidTwoSignsFloat();
        //avoidTwoSigns();
        //else if (checkOperand < 2) return; // check if sign has been inputted
        //calcAfterCheck();
        //displayMessage(Integer.toString(result));
        //clrMethod();

        displayScreen();  // display (operand1 + sign + operand 2) if present

    }

    public void calcAfterCheckFloat() {
        if (opTwoStr.isEmpty() || opOneStr.isEmpty()) clrMethod();
        else {
            fOperandOne = Float.parseFloat(opOneStr);
            fOperandTwo = Float.parseFloat(opTwoStr);
            calcMethodFloat();
        }
    }

    public void calcMethodFloat() {

        switch (operandType) {
            case (1): // addition operand
                fResult = fOperandOne + fOperandTwo;
                //displayMessage(noZeroTrails(fResult));
                break;
            case (2): // subtraction operand
                fResult = fOperandOne - fOperandTwo;
                //displayMessage(noZeroTrails(fResult));
                break;
            case (3): // multiplication operand
                fResult = fOperandOne * fOperandTwo;
                //displayMessage(noZeroTrails(fResult));
                break;
            case (4): // division operand
                fResult = fOperandOne / fOperandTwo;
                //displayMessage(noZeroTrails(fResult));
                break;
            default:
                break;
        }
    }

    /* The actual FINAL CALCULATING METHOD!!! */
    public void avoidTwoSignsFloat() {
        String tempResult;
        if (!opTwoStr.isEmpty()) { // Check if operand 2 is NOT empty, then performs calculation

            calcAfterCheckFloat(); // Do the calculation, puts the result in fResult
            tempResult = (noZeroTrails(fResult)); // fResult -> string tempResult
            clrMethod();   // clear all global variables
            opOneStr = tempResult; // put the result (tempResult) to operand 1 (opOneStr)
            checkOperand = 1;  // show that operand 1 is set

        }
    }

    /* Method for handling the clear (C) button */

    public void calcClr(View view) {
        // reset operands and result and displays 0 on the screen
        clrMethod();

        displayMessage(Integer.toString(result));

    }

    public void clrMethod() {
        checkOperand = 0;   // no number input(0), if operand1 is set-> (1), operand2 set-> (2)
        operandOne = 0;     // integer variable operand1
        operandTwo = 0;     // integer variable operand2
        operandType = 0;    // sign: 1=add, 2=subtract, 3=multiply, 4=divide
        result = 0;         // integer variable for calculated answer
        opOneStr = "";      // string display for operand1
        opTwoStr = "";      // string display for operand2
        operatorSign = "";  // string display for the operator
        resultView = "";    // string displayed on text view
        fOperandOne = 0;    // float variable operand1
        fOperandTwo = 0;    // float variable operand2
        fResult = 0;        // float variable for calculated answer
        checkInitDecimal = true;   // check decimal point: true=not set, false=dec point set
    }

    /* Methods for handling sign buttons */

    public void setOpAdd(View view) {
        if (checkOperand < 1) { //if checkOperand is less than 1 i.e. 0, there's no number input
            return;
        } else if (checkOperand == 1) { // at least one number has been typed in i.e. first operand

            operandType = 1;            // set operandType flag to addition -> 1
            operatorSign = "+";
            //resultView += "+";          // append sign to result view
            checkOperand = 2;           // set the sign set flag on
            checkInitDecimal = true;    // reset the decimal set flag
            // displayMessage(resultView);

        } else if (checkOperand == 2) {  // sign set flag on, calculate and print results instead
            avoidTwoSignsFloat();
            //avoidTwoSigns();
            //if (opTwoStr.isEmpty()) return;
            //else {
            //    calcAfterCheck();
            //    displayMessage(Integer.toString(result));
            //    clrMethod();


            //}
            //operandType = 1;
            //resultView += "+";
            /* put code to operand one = operandOne (previous sign) operand two, then
             *  put change check operand to 1*/


        }

        displayScreen();

    }

    public void setOpSub(View view) {
        if (checkOperand < 1) {
            return;

        } else if (checkOperand == 1) {

            operandType = 2; // set operandType flag to subtraction -> 2
            operatorSign = "-";
            checkOperand = 2;
            checkInitDecimal = true;

        } else if (checkOperand == 2) {
            avoidTwoSignsFloat();
            //avoidTwoSigns();

            //operandType = 2;
            //resultView += "-";
            /* put code to operand one = operandOne (previous sign) operand two, then
             *  put change check operand to 1*/

        }

        displayScreen();

    }

    public void setOpMul(View view) {
        if (checkOperand < 1) {
            return;

        } else if (checkOperand == 1) {

            operandType = 3; // set operandType flag to multiplication -> 3
            operatorSign = "x";
            checkOperand = 2;
            checkInitDecimal = true;

        } else if (checkOperand == 2) {
            avoidTwoSignsFloat();
            //avoidTwoSigns();

            //operandType = 3;
            //resultView += "x";
            /* put code to operand one = operandOne (previous sign) operand two, then
             *  put change check operand to 1*/


        }

        displayScreen();

    }

    public void setOpDiv(View view) {
        if (checkOperand < 1) {
            return;

        } else if (checkOperand == 1) {

            operandType = 4; // set operandType flag to division -> 4
            operatorSign = "÷";
            checkOperand = 2;
            checkInitDecimal = true;

        } else if (checkOperand == 2) {
            avoidTwoSignsFloat();
            //avoidTwoSigns();

            //operandType = 4;
            //resultView += "÷";
            /* put code to operand one = operandOne (previous sign) operand two, then
             *  put change check operand to 1*/

        }

        displayScreen();

    }

    /* Method for handling the backspace button */

    public void delPad(View view) {
        if (checkOperand < 1) { //if checkOperand is less than 1 i.e. 0, there's no number input
            return;
        }
        displayScreen();

    }

    /* Methods for handling the number pad buttons */

    public void setPad1(View view) {
        if (checkOperand < 1) { //check that no number has been inputted
            checkOperand = 1;
            // resultView += "1";
            opOneStr += "1";
        } else if (checkOperand == 1) { // no sign put, operand appended is operandOne
            // resultView += "1";
            opOneStr += "1";
        } else if (checkOperand == 2) { // sign has been put, operand appended is operandTwo
            // resultView += "1";
            opTwoStr += "1";
        }

        displayScreen();
    }

    public void setPad2(View view) {
        if (checkOperand < 1) {
            checkOperand = 1;
            // resultView += "2";
            opOneStr += "2";
        } else if (checkOperand == 1) {
            // resultView += "2";
            opOneStr += "2";
        } else if (checkOperand == 2) {
            // resultView += "2";
            opTwoStr += "2";
        }

        displayScreen();
    }

    public void setPad3(View view) {
        if (checkOperand < 1) {
            checkOperand = 1;
            // resultView += "3";
            opOneStr += "3";
        } else if (checkOperand == 1) {
            // resultView += "3";
            opOneStr += "3";
        } else if (checkOperand == 2) {
            // resultView += "3";
            opTwoStr += "3";
        }

        displayScreen();
    }

    public void setPad4(View view) {
        if (checkOperand < 1) {
            checkOperand = 1;
            // resultView += "4";
            opOneStr += "4";
        } else if (checkOperand == 1) {
            // resultView += "4";
            opOneStr += "4";
        } else if (checkOperand == 2) {
            // resultView += "4";
            opTwoStr += "4";
        }

        displayScreen();
    }

    public void setPad5(View view) {
        if (checkOperand < 1) {
            checkOperand = 1;
            // resultView += "5";
            opOneStr += "5";
        } else if (checkOperand == 1) {
            // resultView += "5";
            opOneStr += "5";
        } else if (checkOperand == 2) {
            // resultView += "5";
            opTwoStr += "5";
        }

        displayScreen();
    }

    public void setPad6(View view) {
        if (checkOperand < 1) {
            checkOperand = 1;
            // resultView += "6";
            opOneStr += "6";
        } else if (checkOperand == 1) {
            // resultView += "6";
            opOneStr += "6";
        } else if (checkOperand == 2) {
            // resultView += "6";
            opTwoStr += "6";
        }

        displayScreen();
    }

    public void setPad7(View view) {
        if (checkOperand < 1) {
            checkOperand = 1;
            // resultView += "7";
            opOneStr += "7";
        } else if (checkOperand == 1) {
            // resultView += "7";
            opOneStr += "7";
        } else if (checkOperand == 2) {
            // resultView += "7";
            opTwoStr += "7";
        }

        displayScreen();
    }

    public void setPad8(View view) {
        if (checkOperand < 1) {
            checkOperand = 1;
            // resultView += "8";
            opOneStr += "8";
        } else if (checkOperand == 1) {
            //resultView += "8";
            opOneStr += "8";
        } else if (checkOperand == 2) {
            // resultView += "8";
            opTwoStr += "8";
        }

        displayScreen();
    }

    public void setPad9(View view) {
        if (checkOperand < 1) {
            checkOperand = 1;
            // resultView += "9";
            opOneStr += "9";
        } else if (checkOperand == 1) {
            // resultView += "9";
            opOneStr += "9";
        } else if (checkOperand == 2) {
            // resultView += "9";
            opTwoStr += "9";
        }

        displayScreen();
    }

    public void setPad0(View view) {
        if (checkOperand < 1) { //check that no number has been inputted
            // clrMethod();
            // displayMessage(Integer.toString(result));
            return;
        } else if (checkOperand == 1) { // no sign put, operand appended is operandOne
            // resultView += "0";
            opOneStr += "0";
        } else if ((checkOperand == 2)&&(opTwoStr.length() > 0 )) {
            // sign has been put & operand Two is NOT empty, operand appended is operandTwo
            // resultView += "0";
            opTwoStr += "0";
        }

        displayScreen();
    }

    /* Method for handling the decimal button */

    public void setDec(View view) {
        if (checkOperand < 1) { //check that no number has been inputted
            checkOperand = 1;
            // resultView += "0.";
            opOneStr += "0.";
            checkInitDecimal = false; //set decimal flag ON

        } else if ((checkOperand == 1)&&(checkInitDecimal)){
            // sign set flag OFF & decimal set flag OFF; operand ONE will have decimal appended

            // resultView += ".";
            opOneStr += ".";
            checkInitDecimal = false; //set decimal flag ON

        } else if ((checkOperand == 2)&&(checkInitDecimal)&&(opTwoStr.isEmpty())) {
            // sign set flag ON & decimal set flag OFF & operand TWO is empty;
            // operand TWO will have decimal appended

            // resultView += "0.";
            opTwoStr += "0.";
            checkInitDecimal = false; //set decimal flag ON

        } else if ((checkOperand == 2)&&(checkInitDecimal)) {
            // sign set flag ON & decimal set flag OFF; operand TWO will have decimal appended

            // resultView += ".";
            opTwoStr += ".";
            checkInitDecimal = false; //set decimal flag ON
        }
        //resultView += ".";

        displayScreen();
    }
}
