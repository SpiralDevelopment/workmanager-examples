package com.spiraldev.workmanagerwithexamples.WorkersWithOutput

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.*
import com.spiraldev.workmanagerwithexamples.Consts
import com.spiraldev.workmanagerwithexamples.R
import com.spiraldev.workmanagerwithexamples.WorkersWithInput.WorkerWithInput
import com.spiraldev.workmanagerwithexamples.WorkersWithOutput.WorkerWithOutput.Companion.FIRST_KEY
import com.spiraldev.workmanagerwithexamples.WorkersWithOutput.WorkerWithOutput.Companion.SECOND_KEY
import kotlinx.android.synthetic.main.activity_start_worker.*


class WorkerWithOutputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_worker)

        val workerInstance = getOneTimeWorker()

        start_btn.setOnClickListener {
            // Run One Time Work
            WorkManager.getInstance(this).enqueue(workerInstance)
        }

        // Observe the output data from workers
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(workerInstance.id)
            .observe(this, Observer {
                if (it?.state == null)
                    return@Observer

                when (it.state) {
                    WorkInfo.State.SUCCEEDED -> {
                        val successOutputData = it.outputData
                        val firstValue = successOutputData.getString(FIRST_KEY)
                        val secondValue = successOutputData.getInt(SECOND_KEY, 0)

                        Log.d(Consts.TAG, "Outputs: $firstValue $secondValue")
                    }
                    WorkInfo.State.FAILED -> {
                        val failureOutputData = it.outputData
                        val firstValue = failureOutputData.getString(FIRST_KEY)
                        val secondValue = failureOutputData.getInt(SECOND_KEY, 0)

                        Log.d(Consts.TAG, "Outputs: $firstValue $secondValue")
                    }
                    else -> {
                    }
                }
            })
    }

    // Create One Time Worker
    private fun getOneTimeWorker(): WorkRequest {
        return OneTimeWorkRequest.Builder(WorkerWithOutput::class.java)
            .build()
    }

}