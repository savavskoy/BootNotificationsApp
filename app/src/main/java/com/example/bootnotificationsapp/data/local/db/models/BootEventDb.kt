package com.example.bootnotificationsapp.data.local.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "boot_events")
data class BootEventDb(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val timestamp: Long,
)