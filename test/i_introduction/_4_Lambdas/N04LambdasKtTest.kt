package i_introduction._4_Lambdas

import org.junit.Assert.*
import org.junit.Test

class N04LambdasKtTest {
    @Test fun contains() {
        assertTrue(task4(listOf(1, 2, 3)))
    }

    @Test fun notContains() {
        assertFalse(task4(listOf(1, 3, 5)))
    }

    @Test
    fun isAllEven() {
        assertTrue(isAllEven(listOf(2, 4, 6)))
        assertFalse(isAllEven(listOf(2, 4, 5)))
    }

    @Test
    fun squareCollection() {
        assertEquals(listOf(1, 4, 9), square(listOf(1, 2, 3)))
        assertEquals(listOf(25, 64, 1024), square(listOf(5, 8, 32)))
    }
}