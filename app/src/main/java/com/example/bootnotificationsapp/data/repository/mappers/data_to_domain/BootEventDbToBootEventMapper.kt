package com.example.bootnotificationsapp.data.repository.mappers.data_to_domain

import com.example.bootnotificationsapp.data.local.db.models.BootEventDb
import com.example.bootnotificationsapp.domain.BootEvent

class BootEventDbToBootEventMapper :
        (BootEventDb) -> BootEvent {
    override fun invoke(bootEvent: BootEventDb): BootEvent = BootEvent(
        timestamp = bootEvent.timestamp
    )
}
