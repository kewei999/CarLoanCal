package com.example.carloancal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            calculateLoan()
        }

    }

    private fun calculateLoan(){
        //Validation
        if(editTextCarPrice.text.isEmpty()){
            editTextCarPrice.setError(getString(R.string.error_input))
            return
        }
        if(editTextDownPayment.text.isEmpty()){
            editTextDownPayment.setError(getString(R.string.error_input))
            return
        }

        if(editTextLoanPeriod.text.isEmpty()){
            editTextLoanPeriod.setError(getString(R.string.error_input))
            return
        }

        //get
        val carPrice:Int = editTextCarPrice.text.toString().toInt()
        val downPayment:Int=editTextDownPayment.text.toString().toInt()
        val carLoan:Int=carPrice-downPayment
        val interestRate=editTextinterestRate.text.toString().toFloat()
        val loanPeriod=editTextLoanPeriod.text.toString().toInt()
        val interest:Float=carLoan * interestRate * loanPeriod
        val monthlyRepayment:Float=(carLoan+interest)/loanPeriod/12
         val currency=Currency.getInstance(Locale.getDefault())

        textViewLoan.setText(getString(R.string.loan) + currency.getSymbol()+ "${carLoan}")
        textViewInterest.setText(getString(R.string.interest) + "${interest}")
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment)+"${monthlyRepayment}")

        Toast.makeText(this,"calculate Loan",Toast.LENGTH_SHORT).show()
    }

    fun reset(view: View){
    Toast.makeText(this,"Reset",Toast.LENGTH_SHORT).show()
    }
}
