package i_introduction._3_Default_Arguments

import org.junit.Assert.assertEquals
import org.junit.Test
import java.math.BigDecimal
import java.util.*

class _03_Default_Arguments {

    var amountCurrency = AmountCurrency()
    var debitAmountCurrency = DebitAmountCurrency()
    var creditAmountCurrency = CreditAmountCurrency()

    @Test
    fun testDefaultAndNamedParams() {
        assertEquals("a42b1C42D2", task3())
    }

    @Test
    fun firstParamNeedNotBeNamed() {
        assertEquals("myName0", kotlinFoo("myName", number = 0))
        assertEquals("namedName0", kotlinFoo( name = "namedName", number = 0))
    }

    @Test
    fun useDefaultNumberWhenNotSpecified() {
        assertEquals("name42", kotlinFoo("name"))
        assertEquals("name123", kotlinFoo("name", number = 123))
    }

    @Test
    fun useDefaultUpperCaseFlagWhenNotSpecified() {
        assertEquals("not_capitalized42", kotlinFoo("not_capitalized"))
        assertEquals("CAPITALIZED42", kotlinFoo("capitalized", toUpperCase = true))
    }

    @Test
    fun getDefaultAmount() {
        assertEquals("NOK 0", amountCurrency.create())
        assertEquals("-NOK 0", debitAmountCurrency.create())
        assertEquals("+NOK 0", creditAmountCurrency.create())
    }

    @Test
    fun defaultCurrencyIsNOK() {
        assertEquals("NOK 1", amountCurrency.create(BigDecimal.valueOf(1)))
        assertEquals("-NOK 1", debitAmountCurrency.create(BigDecimal.valueOf(1)))
        assertEquals("+NOK 1", creditAmountCurrency.create(BigDecimal.valueOf(1)))
    }

    @Test
    fun specifiedAmountAndCurrency() {
        val indonesianRupiah = Currency.getInstance("IDR")
        val amount = BigDecimal.valueOf(123)

        assertEquals("IDR 123", amountCurrency.create(amount, currency = indonesianRupiah))
        assertEquals("-IDR 123", debitAmountCurrency.create(amount, currency = indonesianRupiah))
        assertEquals("+IDR 123", creditAmountCurrency.create(amount, currency = indonesianRupiah))
    }
}
