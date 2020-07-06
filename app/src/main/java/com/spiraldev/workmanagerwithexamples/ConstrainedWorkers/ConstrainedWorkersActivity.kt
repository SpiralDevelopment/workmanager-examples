package com.spiraldev.workmanagerwithexamples.ConstrainedWorkers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import com.spiraldev.workmanagerwithexamples.R
import kotlinx.android.synthetic.main.activity_start_worker.*

class ConstrainedWorkersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_worker)

         val workerInstance = getConstrainedOneTimeWorker()

        start_btn.setOnClickListener {
            // Run One Time Work
            WorkManager.getInstance(this).enqueue(workerInstance)
        }
    }

    // Create One Time Work
    private fun getConstrainedOneTimeWorker(): WorkRequest{
        // create constraint object with required conditions to start worker
        // There are 5 limitations that could be used

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .setRequiresStorageNotLow(true)
//            .setRequiresDeviceIdle(false)
//            .setRequiresCharging(false)
            .build()

        return OneTimeWorkRequest.Builder(ConstrainedWorker::class.java)
            .setConstraints(constraints)
            .build()
    }

}