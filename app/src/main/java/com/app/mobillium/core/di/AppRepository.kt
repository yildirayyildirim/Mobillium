package com.app.mobillium.core.di

import com.app.mobillium.core.repository.IAppService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository
@Inject
constructor(private val apiService: IAppService) {

    suspend fun getAllDiscover() =
        apiService.getAllDiscover()
}