package com.example.bootnotificationsapp.data.repository

import com.example.bootnotificationsapp.data.local.db.dao.BootEventDao
import com.example.bootnotificationsapp.data.repository.mappers.data_to_domain.BootEventDbToBootEventMapper
import com.example.bootnotificationsapp.data.repository.mappers.domain_to_data.BootEventToBootEventDbMapper
import com.example.bootnotificationsapp.domain.BootEvent

class BootEventRepository(
    private val bootEventDao: BootEventDao,
    private val bootEventDbToBootEventMapper: BootEventDbToBootEventMapper,
    private val bootEventToBootEventDbMapper: BootEventToBootEventDbMapper
) {

    suspend fun insertBootEvent(bootEvent: BootEvent) {
        bootEventDao.insert(bootEventToBootEventDbMapper(bootEvent))
    }
}