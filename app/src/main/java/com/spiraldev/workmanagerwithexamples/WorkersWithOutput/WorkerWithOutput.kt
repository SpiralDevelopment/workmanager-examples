package com.spiraldev.workmanagerwithexamples.WorkersWithOutput

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.spiraldev.workmanagerwithexamples.Consts


class WorkerWithOutput(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    companion object {
        val FIRST_KEY = "FIRST_KEY"
        val SECOND_KEY = "SECOND_KEY"
    }

    override fun doWork(): Result {
        Log.d(Consts.TAG, "Doing some work")
        Thread.sleep(2000)

        return try {
            val outputData = createOutputData("Success", 100)
            Result.success(outputData)
        } catch (e: Exception) {
            val outputData = createOutputData("Error", -100)
            Result.failure(outputData)
        }
    }

    private fun createOutputData(firstData: String, secondData: Int): Data {
        return Data.Builder()
            .putString(FIRST_KEY, firstData)
            .putInt(SECOND_KEY, secondData)
            .build()
    }
}