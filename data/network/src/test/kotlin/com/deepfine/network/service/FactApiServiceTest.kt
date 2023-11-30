package com.deepfine.network.service

import com.deepfine.network.di.FakeNetworkModule
import com.skydoves.sandwich.isFailure
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
  private val successService: FactApiService = FactApiServiceImpl(FakeNetworkModule.provideKtorSuccessClient())
  private val failureService: FactApiService = FactApiServiceImpl(FakeNetworkModule.provideKtorFailureClient())

  @Before
  fun setUp() {
  }

  @AfterEach
  fun tearDown() {
  }

  @Test
  fun getFactsSuccess() = runTest {
    Assertions.assertTrue(successService.getFacts().isSuccess)
  }

  @Test
  fun getFactsFailure() = runTest {
    Assertions.assertTrue(failureService.getFacts().isFailure)
  }
}
