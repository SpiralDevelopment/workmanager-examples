package com.spiraldev.workmanagerwithexamples.ChainingWorkers

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.spiraldev.workmanagerwithexamples.Consts

class ChainingWorkerOne(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {
        Log.d(Consts.TAG, "ChainingWorkerOne is doing some work")
        Thread.sleep(3000)

        return Result.success()
    }
}