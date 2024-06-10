package com.deepfine.network.datasource

import com.deepfine.network.service.ApiService
import javax.inject.Inject

class NetworkDataSourceImpl @Inject constructor(
  private val service: ApiService
) : NetworkDataSource
