package com.example.bootnotificationsapp.ui.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.bootnotificationsapp.data.repository.BootEventRepository
import com.example.bootnotificationsapp.domain.BootEvent
import com.example.bootnotificationsapp.ui.worker.BootEventWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BootCompletedReceiver(
    private val bootEventRepository: BootEventRepository
) : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
            BootEventWorker.scheduleBootEventWork(context)
            saveBootEventToDb()
        }
    }

    private fun saveBootEventToDb() {
        CoroutineScope(Dispatchers.IO).launch {
            bootEventRepository.insertBootEvent(createBootEvent())
        }
    }

    private fun createBootEvent(): BootEvent {
        val timestamp = System.currentTimeMillis()
        return BootEvent(timestamp = timestamp)
    }
}