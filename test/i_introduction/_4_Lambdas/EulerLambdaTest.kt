package i_introduction._4_Lambdas

import org.junit.Assert.*
import org.junit.Test

class EulerLambdaTest {

    @Test
    fun getNumbersDivisibleByThreeOrFive() {
        assertEquals(listOf(3, 5, 6, 9), numbersDivisibleByThreeOrFiveBelow(10))
    }

    @Test
    fun getSumOfNumbersDivisibleByThreeOrFive() {
        assertEquals(23, sumOfNumbersDivisibleByThreeOrFiveBelow(10))
        assertEquals(233168, sumOfNumbersDivisibleByThreeOrFiveBelow(1000))
    }
}
