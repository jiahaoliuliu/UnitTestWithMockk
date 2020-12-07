package com.jiahaoliuliu.unittestwithmockk

import io.mockk.*
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class MockkExtensionUnitTests {

    @Test
    fun extensionTest() {
        with(mockk<Ext>()) {
            every {
                Obj(5).extensionFunc()
            } returns 11

            assertEquals(11, Obj(5).extensionFunc())

            verify {
                Obj(5).extensionFunc()
            }
        }
    }

    @Test
    fun extensionOnTopLevelExtensionTest() {
        MockKAnnotations.init(this)

        // Make sure to add Kt at the end of the class
        mockkStatic("com.jiahaoliuliu.unittestwithmockk.ExtensionForMockKt")

        every { Obj(5).topLevelExtension()} returns 2

        val result = Obj(5).topLevelExtension()
        Assert.assertEquals(2, result)

        verify {Obj(5).topLevelExtension()}
    }
}