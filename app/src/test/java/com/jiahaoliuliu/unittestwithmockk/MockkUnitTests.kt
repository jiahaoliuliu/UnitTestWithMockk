package com.jiahaoliuliu.unittestwithmockk

import android.net.Uri
import io.mockk.*
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

data class Car(private val driver: String) {

    fun drive() = true
}

/**
 * Simple unit tests examples using Mockk.
 * @link https://github.com/mockk/mockk
 * @link https://medium.com/@ByteSizedBit/mockk-testing-extension-functions-8b207bcad21d
 */
class MockkUnitTests {

    fun setUp() = MockKAnnotations.init(this, relaxUnitFun = true) // turn relaxUnitFun on for all mocks

    @Test
    fun simpleTest() {
        MockKAnnotations.init(this)
        val car = mockk<Car>()
        every { car.drive() } returns false
        car.drive()
        verify { car.drive()}
        confirmVerified(car)
    }

    @Test
    fun mockStatic() {
        mockkStatic(Uri::class)
        val uriMock = mockk<Uri>()
        every {uriMock.authority} returns "Me"
        every { Uri.parse("http://test/path")} returns uriMock
        val uriParsed = Uri.parse("http://test/path")
        assertEquals("Me", uriParsed.authority)
    }
}