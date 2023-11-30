package com.deepfine.network.datasource

import app.cash.turbine.test
import com.deepfine.network.di.FakeNetworkModule
import com.deepfine.network.service.FactApiService
import com.deepfine.network.service.FactApiServiceImpl
import io.mockk.clearAllMocks
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

class NetworkDataSourceTest {
  private val successService: FactApiService = FactApiServiceImpl(FakeNetworkModule.provideKtorSuccessClient())
  private val failureService: FactApiService = FactApiServiceImpl(FakeNetworkModule.provideKtorFailureClient())
  private lateinit var successDataSource: NetworkDataSource
  private lateinit var failureDataSource: NetworkDataSource

  @BeforeEach
  fun setUp() {
    successDataSource = NetworkDataSourceImpl(successService)
    failureDataSource = NetworkDataSourceImpl(failureService)
  }

  @AfterEach
  fun tearDown() {
    clearAllMocks()
  }

  @Nested
  inner class SucceedGetFacts {
    @BeforeEach
    fun arrange() {
    }

    @Test
    fun getFacts() = runTest {
      successDataSource.getFacts().test {
        assertTrue(awaitItem().facts.isNotEmpty())
        awaitComplete()
      }
    }
  }

  @Nested
  inner class FailedGetFacts {
    @BeforeEach
    fun arrange() {
    }

    @Test
    fun getFacts() = runTest {
      failureDataSource.getFacts().test {
        awaitError()
      }
    }
  }
}
