package com.duzceders.newscleanarch.domain.usecases

import com.duzceders.newscleanarch.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val localUserManager: LocalUserManager) {
    operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}