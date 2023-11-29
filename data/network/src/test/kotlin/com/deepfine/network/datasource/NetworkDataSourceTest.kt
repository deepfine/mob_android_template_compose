package com.deepfine.network.datasource

import com.deepfine.network.entity.FactsEntity
import com.deepfine.network.service.FactApiService
import com.skydoves.sandwich.ApiResponse
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
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
  private val service: FactApiService = mockk()
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
      coEvery {
        service.getFacts()
      } returns ApiResponse.of { FactsEntity(emptyList()) }
    }

    @Test
    fun getFacts() = runTest {
      Assertions.assertEquals(dataSource.getFacts().first(), FactsEntity(emptyList()))
    }
  }

  @Nested
  inner class FailedGetFacts {
    @BeforeEach
    fun arrange() {
      coEvery {
        service.getFacts()
      } throws RuntimeException()
    }

    @Test
    fun getFacts() = runTest {
      assertFailsWith(RuntimeException::class) {
        dataSource.getFacts()
      }
    }
  }
}
