package com.duzceders.newscleanarch.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {
    suspend fun saveAppEntry()

    fun readAppEntry(): Flow<Boolean>
}