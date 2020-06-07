package com.example.testdrive

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_score.*

class ScoreActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        var strScore=intent.getStringExtra("score")
        var name=intent.getStringExtra("name")

        var score=strScore.toInt()
        var tcorrect=score
        var tincorrect=20-tcorrect
        var perScore:Double=(score.toDouble()/20)*100
        var qualify=""
        var strPer=perScore.toString()
        var strPoints=""

        if (strPer.length>=5){
            strPoints=strPer.substring(0,5)
        }else{
            strPoints=strPer
        }

        if (score>=10){
            qualify="PASSED"
        }else{
            qualify="FAILED"
        }

        txt_name.text="Hey $name"
        txt_points.text="$strPoints %"
        txt_total_correct.text="Total correct answers   ${tcorrect.toString()}"
        txt_total_incorrect.text="Total incorrect answers   ${tincorrect.toString()}"
        btn_result.text="$qualify"

        //Toast.makeText(this,"Score on Score : $score", Toast.LENGTH_LONG).show()

    }
}