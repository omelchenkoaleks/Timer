package com.omelchenkoaleks.timer

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TimerActivity : AppCompatActivity() {

    private var timerTv: TextView? = null
    private var progressBar: ProgressBar? = null
    private var startBtn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        timerTv = findViewById(R.id.timer_tv)
        progressBar = findViewById(R.id.progress_bar)
        startBtn = findViewById(R.id.start_button)

        startBtn?.setOnClickListener {
            object : CountDownTimer(60000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    timerTv?.text = "" + millisUntilFinished / 1000
                    progressBar?.progress = (millisUntilFinished / 1000).toInt()
                }

                override fun onFinish() {
                    timerTv?.text = "-"
                }
            }.start()

        }
    }
}

