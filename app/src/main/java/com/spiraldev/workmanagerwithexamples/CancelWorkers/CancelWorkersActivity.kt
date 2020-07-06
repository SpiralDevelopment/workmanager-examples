package com.spiraldev.workmanagerwithexamples.CancelWorkers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.spiraldev.workmanagerwithexamples.ChainingWorkers.ChainingWorkerOne
import com.spiraldev.workmanagerwithexamples.ChainingWorkers.ChainingWorkerTwo
import com.spiraldev.workmanagerwithexamples.R
import kotlinx.android.synthetic.main.activity_start_stop_worker.*
import kotlinx.android.synthetic.main.activity_start_worker.*
import kotlinx.android.synthetic.main.activity_start_worker.start_btn


class CancelWorkersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_stop_worker)

        val workerInstance = OneTimeWorkRequest.Builder(CancelingWorker::class.java).build()

        start_btn.setOnClickListener {
            WorkManager.getInstance(this)
                .enqueue(workerInstance)
        }

        // Cancel worker by its UUID
        stop_btn.setOnClickListener {
            WorkManager.getInstance(this).cancelWorkById(workerInstance.id)
        }
    }
}