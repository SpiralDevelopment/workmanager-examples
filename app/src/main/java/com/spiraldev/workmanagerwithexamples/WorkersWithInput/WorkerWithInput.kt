package com.spiraldev.workmanagerwithexamples.WorkersWithInput

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.spiraldev.workmanagerwithexamples.Consts.TAG


class WorkerWithInput(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    companion object {
        val FIRST_KEY = "FIRST_KEY"
        val SECOND_KEY = "SECOND_KEY"
    }

    override fun doWork(): Result {
        Log.d(TAG, "Doing some work")

        return try {
            val firstValue = inputData.getString(FIRST_KEY)
            val secondValue = inputData.getInt(SECOND_KEY, -1)

            Log.d(TAG, "First Value: $firstValue")
            Log.d(TAG, "Second Value: $secondValue")
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}