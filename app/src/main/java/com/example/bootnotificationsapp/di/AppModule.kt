package com.example.bootnotificationsapp.di

import androidx.room.Room
import com.example.bootnotificationsapp.data.local.db.room.BootEventDatabase
import com.example.bootnotificationsapp.data.repository.BootEventRepository
import com.example.bootnotificationsapp.data.repository.mappers.data_to_domain.BootEventDbToBootEventMapper
import com.example.bootnotificationsapp.data.repository.mappers.domain_to_data.BootEventToBootEventDbMapper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single {
        Room.databaseBuilder<BootEventDatabase>(
            androidContext(),
            BootEventDatabase::class.java,
            "BootEventDb"
        ).build().bootEventDao()
    }

    single { BootEventRepository(get(), get(), get()) }
}

val mappersModule = module {
    factory { BootEventToBootEventDbMapper() }
    factory { BootEventDbToBootEventMapper() }
}