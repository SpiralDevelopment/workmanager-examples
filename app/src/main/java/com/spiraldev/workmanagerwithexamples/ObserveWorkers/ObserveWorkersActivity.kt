package com.spiraldev.workmanagerwithexamples.ObserveWorkers

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.spiraldev.workmanagerwithexamples.R
import com.spiraldev.workmanagerwithexamples.SimpleWorkers.SimpleWorker
import kotlinx.android.synthetic.main.activity_start_worker.*


class ObserveWorkersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_worker)

        val workerInstance = getOneTimeWorker()

        start_btn.setOnClickListener {
            // Run One Time Work
            WorkManager.getInstance(this).enqueue(workerInstance)
        }

        // Observe the status of the worker by its UUID
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(workerInstance.id)
            .observe(this, Observer { workInfo ->
                work_manager_status.append(workInfo.state.name + "\n")
            })
    }

    // Create One Time Worker
    private fun getOneTimeWorker(): WorkRequest {
        return OneTimeWorkRequest.Builder(SimpleWorker::class.java)
            .build()
    }
}