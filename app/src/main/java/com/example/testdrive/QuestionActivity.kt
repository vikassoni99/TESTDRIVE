package com.example.testdrive

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_question.*
import java.util.*

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        var name=intent.getStringExtra("name")

        val totalQues: Int = 20
        var quesCount: Int = 1
        var counter:Int = 0
        var score: Int = 0
        var correct = 0;
        val questions = arrayOf("You want to make a U-turn but there is a lot of traffic around. What should you do?",
            "A PUCC (Pollution Under Control Certificate) is valid for how long from the date of issue?",
            "You are driving on a dark road at night when you see another vehicle approaching. What should you do?",
            "A passenger may not be carried on a motorcycle unless it has…?",
            "What signals should you make if you are going straight across at a roundabout?",
            "It is permissible to exceed the speed limit…?",
            "A circular blue sign with a red border and two red diagonal lines crossing it means what?",
            "What color are the number plates for private car and motorised two-wheeler owners?",
            "When pulling away from the curb, what should you do?",
            "From which of these vehicles may a passenger disembark while it is still moving?",
            "Once you have obtained your learner's licence, it is valid for how long?",
            "Traveling at 60 km/h, how far will your vehicle travel in a single second?",
            "If you drive while drunk, you can face a term of imprisonment of up to…?",
            "The number plate of your vehicle must be…?",
            "If an ambulance or fire service vehicle approaches you from behind with siren on or lights flashing, what must you do?",
            "Your insurance has expired. How long can you legally drive your vehicle before you renew it?",
            "When you are driving near a school, you should do what?",
            "If you're approaching an unmanned railway crossing, what should you do?",
            "A state driving license is valid for use…?",
            "A cautionary traffic sign is what shape?"
        )
        val options = arrayOf(
            arrayOf("*Drive on until you find a less busy place",
                "Force others to stop and wait for you",
                "Make the turn as slowly as possible",
                "Make the turn as quickly as possible"),
            arrayOf("Eight months",
                "*Twelve months ",
                "Six months",
                "Twenty months"),
            arrayOf("Sound your horn long and hard",
                "Turn off your headlights",
                "*Switch to low beam headlights",
                "Switch to high beam headlights"),
            arrayOf("A large engine",
                "*Proper foot rests",
                "Wide tires",
                "Mudguards"),
            arrayOf("Left on entry, nothing on exit",
                "*Nothing on entry, left on exit",
                "Left on entry, right on exit",
                "Nothing on entry, right on exit"),
            arrayOf("When making an overtake",
                "*Under no circumstances",
                "In perfect conditions",
                "On empty roads"),
            arrayOf("No U-turns",
                "Give way",
                "*No stopping",
                "No overtaking"),
            arrayOf("White letters, blue background",
                "Yellow letters, black background",
                "Black letters, yellow background",
                "*Yellow letters, black background"),
            arrayOf("Pull out as quickly as possible",
                "Sound your horn as a warning",
                "*Wait for a gap in the traffic then pull away with caution",
                "Pull out at the sharpest angle possible"),
            arrayOf("A medium-sized passenger vehicle",
                "*None of them",
                "A public transport vehicle",
                "A motorized rickshaw"),
            arrayOf("One year",
                "Four months",
                "Eight months",
                "*Six months"),
            arrayOf("12.2 m",
                "8.6 m",
                "4.3 m",
                "*16.6 m"),
            arrayOf("Four months",
                "One month",
                "Three months",
                "*Six months"),
            arrayOf("*In English with Arabic numerals",
                "In Arabic with English numerals",
                "In the local language",
                "In Hindi"),
            arrayOf("*Pull over as soon as it is safe to do so",
                "Accelerate",
                "Maintain your current course and speed",
                "Slow down and activate your hazard lights"),
            arrayOf("1 month",
                "*0 days",
                "3 days",
                "1 week"),
            arrayOf("Accelerate to leave the area quickly",
                "Turn your lights on full beam",
                "Sound your horn constantly",
                "*Reduce your speed"),
            arrayOf("*Stop and get out to check for trains",
                "Speed up and cross as fast as possible",
                "Sound your horn to warn trains of your presence",
                "Drive across slowly"),
            arrayOf("Anywhere in the world",
                "Only in the state of issue",
                "Anywhere in India, Pakistan or Bangladesh",
                "*Anywhere in India"),
            arrayOf("Square",
                "Rectangular",
                "*Triangular",
                "Circular")

        )
        val ansCorrect = arrayOf(1,2,3,2,2,2,3,4,3,2,4,4,4,1,1,2,4,1,4,3)

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
                //Toast.makeText(this,"Correct h bhai !",Toast.LENGTH_LONG).show()
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

                RB5.setChecked(true)
            }else{
                //Toast.makeText(this,"Score : $score",Toast.LENGTH_LONG).show()
                var intent1= Intent(this@QuestionActivity,ScoreActivity::class.java)
                intent1.putExtra("score",score.toString())
                intent1.putExtra("name",name)
                startActivity(intent1)
            }
        }

        btn_endTest.setOnClickListener {
            Toast.makeText(this,"Score : $score",Toast.LENGTH_LONG).show()
            var intent1= Intent(this@QuestionActivity,ScoreActivity::class.java)
            intent1.putExtra("score",score.toString())
            intent1.putExtra("name",name)
            startActivity(intent1)
        }
    }
}