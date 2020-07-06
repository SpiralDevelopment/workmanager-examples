package com.spiraldev.workmanagerwithexamples.WorkersWithInput

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.spiraldev.workmanagerwithexamples.R
import com.spiraldev.workmanagerwithexamples.SimpleWorkers.SimpleWorker
import com.spiraldev.workmanagerwithexamples.WorkersWithInput.WorkerWithInput.Companion.FIRST_KEY
import com.spiraldev.workmanagerwithexamples.WorkersWithInput.WorkerWithInput.Companion.SECOND_KEY
import kotlinx.android.synthetic.main.activity_start_worker.*
import java.util.concurrent.TimeUnit


class WorkerWithInputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_worker)

        val workerInstance = getOneTimeWorker()

        start_btn.setOnClickListener {
            // Run One Time Work
            WorkManager.getInstance(this).enqueue(workerInstance)
        }
    }

    // Create One Time Worker with Input Data
    private fun getOneTimeWorker(): WorkRequest {
        val inputData = Data.Builder()
            .putString(FIRST_KEY, "My value")
            .putInt(SECOND_KEY, 5)
            .build()

        return OneTimeWorkRequest.Builder(WorkerWithInput::class.java)
            .setInputData(inputData)
            .build()
    }
}