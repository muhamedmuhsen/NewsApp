package com.example.newsapp.domain.usecases.appentry

import com.example.newsapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        return localUserManager.saveAppEntry()
    }
}