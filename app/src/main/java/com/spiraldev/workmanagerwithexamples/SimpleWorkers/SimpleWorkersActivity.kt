package com.spiraldev.workmanagerwithexamples.SimpleWorkers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.spiraldev.workmanagerwithexamples.R
import kotlinx.android.synthetic.main.activity_start_worker.*
import java.util.concurrent.TimeUnit

class SimpleWorkersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_worker)

        // val workerInstance = getOneTimeWorker()
        val workerInstance = getPeriodicTimeWorker()

        start_btn.setOnClickListener {
            // Run One Time Work
            WorkManager.getInstance(this).enqueue(workerInstance)
        }
    }

    // Create One Time Work
    private fun getOneTimeWorker(): WorkRequest{
        return OneTimeWorkRequest.Builder(SimpleWorker::class.java)
                .build()
    }

    // Create Periodic Work that runs every 15 minutes.
    private fun getPeriodicTimeWorker(): WorkRequest{
        return PeriodicWorkRequest.Builder(SimpleWorker::class.java, 15, TimeUnit.MINUTES)
                .build()
    }
}