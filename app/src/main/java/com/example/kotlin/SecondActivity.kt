package com.example.kotlin
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

const val SECOND_ACTIVITY="second"
const val SECOND_CODE=2

class SecondActivity : AppCompatActivity() {
    private var data:String?=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        getIntentData()
        returnDataAction()
    }

    private fun returnDataAction() {
       change_btn.setOnClickListener {
           val newData=edit_result.text.toString()
           if(newData==data||newData.isEmpty()) {
               this.showToastLong("Поменяйте или заполните данные")
           }
           else  returnData(newData)
       }
    }

    private fun returnData(data: String) {
        val intentChange=Intent()
        intentChange.putExtra(MAIN_RESULT,data)
        setResult(MAIN_CODE,intentChange)
        finish()
    }

    private fun getIntentData() {
        data=intent.getStringExtra(SECOND_ACTIVITY)
        edit_result.setText(data)
    }
}