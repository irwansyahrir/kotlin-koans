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

    @Test
    fun generateFibonacci() {
        assertEquals(listOf(1), fibo(1))
        assertEquals(listOf(1, 2), fibo(2))
        assertEquals(listOf(1, 2, 3), fibo(3))
        assertEquals(listOf(1, 2, 3, 5), fibo(4))
        assertEquals(listOf(1, 2, 3, 5, 8), fibo(5))
        assertEquals(listOf(1, 2, 3, 5, 8, 13, 21, 34, 55, 89), fibo(10))
    }

    @Test
    fun getMaxFiboValue() {
        assertEquals(1, maxFibo(1))
        assertEquals(2, maxFibo(2))
        assertEquals(3, maxFibo(3))
        assertEquals(5, maxFibo(4))
        assertEquals(89, maxFibo(10))
        assertEquals(3524578, maxFibo(32))
        assertEquals(5702887, maxFibo(33))
    }

    @Test
    fun getNumberOfTermsForMaxValue() {
        assertEquals(0, numOfTermForValueBelow(1))
        assertEquals(1, numOfTermForValueBelow(2))
        assertEquals(2, numOfTermForValueBelow(3))
        assertEquals(3, numOfTermForValueBelow(5))
        assertEquals(9, numOfTermForValueBelow(89))
        assertEquals(32, numOfTermForValueBelow(4000000))
    }

    @Test
    fun getSumOfEvenTerms() {
        assertEquals(0, sumOfEvenTermsForFibo(1))
        assertEquals(2, sumOfEvenTermsForFibo(2))
        assertEquals(2, sumOfEvenTermsForFibo(3))
        assertEquals(2, sumOfEvenTermsForFibo(4))
        assertEquals(10, sumOfEvenTermsForFibo(5))
        assertEquals(4613732, sumOfEvenTermsForFibo(32))
    }
}
