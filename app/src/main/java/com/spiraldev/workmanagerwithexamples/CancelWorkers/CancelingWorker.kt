package com.spiraldev.workmanagerwithexamples.CancelWorkers

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.spiraldev.workmanagerwithexamples.Consts


class CancelingWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {
        Log.d(Consts.TAG, "Doing some long work")
        Thread.sleep(10000)
        Log.d(Consts.TAG, "Finished the work")

        return if (isStopped) Result.failure() else Result.success()

        // If you have a pending worker which hasn't started yet, the worker will be cancelled and will not run.
        // However if the worker is already running, cancelling work does not terminate the worker in a hard fashion
        // it simply sets the state flag of the worker to CANCELLED
    }

    override fun onStopped() {
        // This method is called when worker is canceled
        super.onStopped()
        Log.d(Consts.TAG, "Worker canceled")
    }
}