package com.spiraldev.workmanagerwithexamples.UniqueWorkers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import com.spiraldev.workmanagerwithexamples.R
import com.spiraldev.workmanagerwithexamples.WorkersWithInput.WorkerWithInput
import kotlinx.android.synthetic.main.activity_start_worker.*
import java.util.concurrent.TimeUnit


class UniqueWorkerActivity : AppCompatActivity() {
    val UNIQUE_NAME = "WORKER_UNIQUE_NAME"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_worker)

        val workerInstance = getPeriodicTimeWorker()

        start_btn.setOnClickListener {
            // Run Period Work with Unique ID

            // 'enqueueUniquePeriodicWork' method allows you to enqueue a uniquely-named PeriodicWorkRequest,
            // where only one PeriodicWorkRequest of a particular name can be active at a time

            WorkManager.getInstance(this)
                .enqueueUniquePeriodicWork(
                    UNIQUE_NAME,
                    ExistingPeriodicWorkPolicy.KEEP,
                    workerInstance
                )

            // ExistingPeriodicWorkPolicy:
            // KEEP: If there is existing pending work with the same unique name, do nothing.
            // REPLACE: If there is existing pending work with the same unique name, cancel and delete it.
        }
    }

    // Create One Time Worker with Input Data
    private fun getPeriodicTimeWorker(): PeriodicWorkRequest {
        return PeriodicWorkRequest.Builder(UniqueWorker::class.java, 15, TimeUnit.MINUTES)
            .build()
    }

}