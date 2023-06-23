package com.example.bootnotificationsapp.data.repository.mappers.domain_to_data

import com.example.bootnotificationsapp.data.local.db.models.BootEventDb
import com.example.bootnotificationsapp.domain.BootEvent

class BootEventToBootEventDbMapper :
        (BootEvent) -> BootEventDb {
    override fun invoke(bootEvent: BootEvent): BootEventDb = BootEventDb(
        timestamp = bootEvent.timestamp
    )
}
