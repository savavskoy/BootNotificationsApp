package com.example.bootnotificationsapp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.bootnotificationsapp.data.local.db.models.BootEventDb

@Dao
interface BootEventDao {
    @Insert
    suspend fun insert(bootEventDb: BootEventDb)

    @Update
    suspend fun update(bootEventDb: BootEventDb)

    @Query("SELECT * FROM boot_events")
    suspend fun getAllBootEvents(): List<BootEventDb>

    @Query("SELECT * FROM boot_events WHERE id = :eventId")
    suspend fun getBootEventById(eventId: Long): BootEventDb?
}
