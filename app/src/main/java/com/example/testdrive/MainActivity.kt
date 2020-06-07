package com.example.testdrive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_score.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var name=" !"


        Btn_EnterTest.setOnClickListener {
            name=edt_name.getText().toString()

            if (name.isEmpty()){
                textFieldName.error="Please enter name !"
            }else{
                var intent1=Intent(this@MainActivity,ConfirmTest::class.java)

                Toast.makeText(this,"$name",Toast.LENGTH_LONG).show()
                intent1.putExtra("name",name)
                startActivity(intent1)
            }


        }




    }
}
