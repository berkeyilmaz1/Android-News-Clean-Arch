package com.duzceders.newscleanarch.domain.usecases

import com.duzceders.newscleanarch.domain.manager.LocalUserManager

class SaveAppEntry(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}