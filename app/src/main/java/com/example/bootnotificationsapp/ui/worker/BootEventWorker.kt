package com.example.bootnotificationsapp.ui.worker

import android.content.Context
import androidx.work.*
import java.util.concurrent.TimeUnit

class BootEventWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        //TODO End notifications logic

        return Result.success()
    }

    companion object {
        private const val WORK_TAG = "boot_event_work"

        fun scheduleBootEventWork(context: Context) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val bootEventWorkRequest = PeriodicWorkRequestBuilder<BootEventWorker>(
                15, TimeUnit.MINUTES
            )
                .setConstraints(constraints)
                .build()

            WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                WORK_TAG,
                ExistingPeriodicWorkPolicy.KEEP,
                bootEventWorkRequest
            )
        }
    }
}