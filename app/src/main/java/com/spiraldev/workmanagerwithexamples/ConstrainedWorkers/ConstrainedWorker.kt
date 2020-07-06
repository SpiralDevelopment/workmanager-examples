package com.spiraldev.workmanagerwithexamples.ConstrainedWorkers

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.spiraldev.workmanagerwithexamples.Consts
import java.util.*
import kotlin.concurrent.timerTask


class ConstrainedWorker(appContext: Context, workerParams: WorkerParameters)
    : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        Log.d(Consts.TAG, "Doing some work when certain constrains are met")
        Thread.sleep(3000)
        Log.d(Consts.TAG, "Finished the work")

        // Indicate task finished successfully
        return Result.success()
    }
}