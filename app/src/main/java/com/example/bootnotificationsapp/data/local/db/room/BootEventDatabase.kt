package com.example.bootnotificationsapp.data.local.db.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bootnotificationsapp.data.local.db.dao.BootEventDao
import com.example.bootnotificationsapp.domain.BootEvent

@Database(entities = [BootEvent::class], version = 1)
abstract class BootEventDatabase : RoomDatabase() {
    abstract fun bootEventDao(): BootEventDao
}