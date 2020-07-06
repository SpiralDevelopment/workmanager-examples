package com.spiraldev.workmanagerwithexamples.UniqueWorkers

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.spiraldev.workmanagerwithexamples.Consts


class UniqueWorker(appContext: Context, workerParams: WorkerParameters)
    : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        Log.d(Consts.TAG, "Doing some work")
        Thread.sleep(3000)
        Log.d(Consts.TAG, "Finished the work")

        // Indicate task finished successfully
        return Result.success()
    }
}