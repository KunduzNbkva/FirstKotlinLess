package com.example.kotlin.h1
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.*
import kotlinx.android.synthetic.main.activity_main.*

const val MAIN_CODE=0
const val MAIN_RESULT="result"
class MainActivity : AppCompatActivity() {
    private val list=ArrayList<String>()
    private var data=" "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendData()
    }


    private fun sendData() {
        send_btn.setOnClickListener {
            data=edit_text_txt.text.toString()
            if(data.isNotEmpty()) { val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(SECOND_ACTIVITY, data)
            startActivityForResult(intent, SECOND_CODE) } else{ this.showToastLong("Заполните данные")
        }}
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode== MAIN_CODE)
            edit_text_txt.setText(data?.getStringExtra(MAIN_RESULT).toString())
        list.add(data?.getStringExtra(MAIN_RESULT).toString())
        array_txt.text= list.toString().replace("[", "").replace("]", "")
    }
}
