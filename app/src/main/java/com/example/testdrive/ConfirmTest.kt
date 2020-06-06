package com.example.testdrive

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.confirm_test.*

class ConfirmTest:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirm_test)

        Btn_StartTest.setOnClickListener {
            var intent1= Intent(this,QuestionActivity::class.java)
            startActivity(intent1)
        }
    }
}