package i_introduction._4_Lambdas

import org.junit.Assert.*
import org.junit.Test

class _04_Lambdas {

    @Test
    fun contains() {
        assertTrue(task4(listOf(1, 2, 3, 126, 555)))
    }

    @Test
    fun notContains() {
        assertFalse(task4(listOf(44)))
    }

    @Test
    fun testSum() {
        assertEquals(5, sum(1, 4))
    }

    @Test
    fun testSquare() {
        assertEquals(4, square(2))
        assertEquals(8, sum(square(2), square(2)))
        assertEquals(49, square(sum(3, square(2))))
    }
}
