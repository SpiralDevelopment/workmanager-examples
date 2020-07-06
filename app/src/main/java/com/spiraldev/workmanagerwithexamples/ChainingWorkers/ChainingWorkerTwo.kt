package com.spiraldev.workmanagerwithexamples.ChainingWorkers

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.spiraldev.workmanagerwithexamples.Consts


class ChainingWorkerTwo(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {
        Log.d(Consts.TAG, "ChainingWorkerTwo is doing some work")
        return Result.success()
    }
}