package com.deepfine.network.datasource

import com.deepfine.network.di.FakeNetworkModule
import com.deepfine.network.service.FactApiService
import com.deepfine.network.service.FactApiServiceImpl
import io.mockk.clearAllMocks
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */

class NetworkDataSourceTest {
  private val service: FactApiService = FactApiServiceImpl(FakeNetworkModule.provideKtorClient())
  private lateinit var dataSource: NetworkDataSource

  @BeforeEach
  fun setUp() {
    dataSource = NetworkDataSourceImpl(service)
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
      Assertions.assertEquals(dataSource.getFacts().first().facts.size, 10)
    }
  }

  @Nested
  inner class FailedGetFacts {
    @BeforeEach
    fun arrange() {
    }

    @Test
    fun getFacts() = runTest {
      assertFailsWith(RuntimeException::class) {
        dataSource.getFacts()
      }
    }
  }
}
