package com.example.testdrive

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        val totalQues: Int = 3
        var quesCount: Int = 1
        var counter:Int = 0
        var score: Int = 0
        var correct = 0;
        val questions = arrayOf(
            "ye he ques 1, iska ans h option 2",
            "ye he ques 2, iska ans h option 3",
            "ye he ques 3, iska ans h option 1"
        )
        val options = arrayOf(
            arrayOf("a", "bb", "cc", "dd"),
            arrayOf("aa", "bb", "cc", "dd"),
            arrayOf("aaa", "bb", "cc", "dd")
        )
        val ansCorrect = arrayOf(2, 3, 1)

        var cId: RadioButton? = null

        //Toast.makeText(this,first[0][0],Toast.LENGTH_LONG).show()
        txt_question.text = questions[0]
        txt_quesNum.text = "1/$totalQues"
        RB1.text=options[counter][0]
        RB2.text=options[counter][1]
        RB3.text=options[counter][2]
        RB4.text=options[counter][3]
        counter=0

        radioGrp.setOnCheckedChangeListener { group, checkedId ->
            cId = findViewById(checkedId)
        }

        //button clicked
        btn_next.setOnClickListener {
            quesCount+=1
            when (cId) {
                RB1 -> if (ansCorrect[counter] == 1) {
                    correct = 1
                } else {
                    correct = 0
                }
                RB2 -> if (ansCorrect[counter] == 2) {
                    correct = 1
                } else {
                    correct = 0
                }
                RB3 -> if (ansCorrect[counter] == 3) {
                    correct = 1
                } else {
                    correct = 0
                }
                RB4 -> if (ansCorrect[counter] == 4) {
                    correct = 1
                } else {
                    correct = 0
                }
                else -> correct = 0
            }

            if(correct==1){
                Toast.makeText(this,"Correct h bhai !",Toast.LENGTH_LONG).show()
                score+=1
            }

            if (quesCount<=totalQues) {
                correct = 0
                counter += 1
                txt_question.text = questions[counter]
                txt_quesNum.text = "$quesCount/$totalQues"
                RB1.text = options[counter][0]
                RB2.text = options[counter][1]
                RB3.text = options[counter][2]
                RB4.text = options[counter][3]
                RB1.setChecked(false)
                RB2.setChecked(false)
                RB3.setChecked(false)
                RB4.setChecked(false)
            }else{
                Toast.makeText(this,"Score : $score",Toast.LENGTH_LONG).show()
                var intent1= Intent(this@QuestionActivity,ScoreActivity::class.java)
                startActivity(intent1)
            }


        }
        //button clicked stop

    }
}