package com.app.mobillium.core.repository

import com.app.mobillium.core.helper.Constants
import com.app.mobillium.presentation.model.ResultModel
import retrofit2.Response
import retrofit2.http.GET

interface IAppService {

    /**
     * @return the ResultModel at the specified URL
     * @see Object
     */
    @GET(Constants.END_POINT)
    suspend fun getAllDiscover(
    ): Response<ResultModel>
}