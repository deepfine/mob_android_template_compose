package com.deepfine.network.service

import com.deepfine.network.di.FakeNetworkModule
import com.skydoves.sandwich.isSuccess
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
class FactApiServiceTest {
  private val apiService: FactApiService = FactApiServiceImpl(FakeNetworkModule.provideKtorClient())

  @Before
  fun setUp() {
  }

  @AfterEach
  fun tearDown() {
  }

  @Test
  fun getFacts() = runTest {
    Assertions.assertTrue(apiService.getFacts().isSuccess)
  }
}
