package com.deepfine.data.repository

import com.deepfine.domain.model.Fact
import com.deepfine.domain.repository.MainRepository
import com.deepfine.network.datasource.NetworkDataSource
import com.deepfine.network.entity.FactEntity
import com.deepfine.network.entity.FactsEntity
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

/**
 * @Description
 * @author yc.park (DEEP.FINE)
 */
class MainRepositoryTest {
  private val dataSource = mockk<NetworkDataSource>()
  private lateinit var repository: MainRepository

  @BeforeEach
  fun setUp() {
    repository = MainRepositoryImpl(dataSource)
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
        dataSource.getFacts()
      } returns flow {
        emit(
          FactsEntity(
            listOf(
              FactEntity("Fact1", 5),
              FactEntity("Fact2", 6),
            ),
          ),
        )
      }
    }

    @Test
    fun getFacts() = runTest {
      val result = repository.getFacts().first()

      Assertions.assertTrue(result.isSuccess)
      Assertions.assertEquals(
        result,
        Result.success(
          listOf(
            Fact("Fact1", 5),
            Fact("Fact2", 6),
          ),
        ),
      )
    }
  }

  @Nested
  inner class FailedGetFacts {
    @BeforeEach
    fun arrange() {
      coEvery {
        dataSource.getFacts()
      } returns flow {
        throw RuntimeException()
      }
    }

    @Test
    fun getFacts() = runTest {
      val result = repository.getFacts().first()

      Assertions.assertTrue(result.isFailure)
      Assertions.assertInstanceOf(RuntimeException::class.java, result.exceptionOrNull())
    }
  }
}
