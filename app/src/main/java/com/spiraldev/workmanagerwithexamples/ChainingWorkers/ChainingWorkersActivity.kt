package com.spiraldev.workmanagerwithexamples.ChainingWorkers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.spiraldev.workmanagerwithexamples.R
import com.spiraldev.workmanagerwithexamples.WorkersWithInput.WorkerWithInput
import kotlinx.android.synthetic.main.activity_start_worker.*


class ChainingWorkersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_worker)

        val task1 = OneTimeWorkRequest.Builder(ChainingWorkerOne::class.java).build()
        val task2 = OneTimeWorkRequest.Builder(ChainingWorkerTwo::class.java).build()

        start_btn.setOnClickListener {
            // First run task1 worker followed by task2 worker
            WorkManager.getInstance(this).beginWith(task1).then(task2).enqueue()
        }
    }
}