package i_introduction._3_Default_Arguments

import util.TODO
import util.doc2
import java.math.BigDecimal
import java.util.*

fun todoTask3(): Nothing = TODO(
    """
        Task 3.
        Several overloaded 'foo' functions in the class 'JavaCode3' can be replaced with one function in Kotlin.
        Change the declaration of the function 'foo' in a way that makes the code using 'foo' compile.
        You have to add 'foo' parameters and implement its body.
        Uncomment the commented code and make it compile.
    """,
    documentation = doc2(),
    references = { name: String -> JavaCode3().foo(name); kotlinFoo(name) })

fun kotlinFoo(name: String, number: Number = 42, toUpperCase: Boolean = false): String {
    return (if (toUpperCase) name.toUpperCase() else name) + number
}

open class AmountCurrency {
    open fun create(
            amount: BigDecimal = BigDecimal.ZERO,
            currency: Currency = Currency.getInstance("NOK")
    ): String {
        return "${currency.currencyCode} $amount"
    }
}

class DebitAmountCurrency: AmountCurrency() {
    override fun create(amount: BigDecimal, currency: Currency): String {
        return "-${currency.currencyCode} $amount"
    }
}

class CreditAmountCurrency: AmountCurrency() {
    override fun create(amount: BigDecimal, currency: Currency): String {
        return "+${currency.currencyCode} $amount"
    }
}

fun task3(): String {
    return (kotlinFoo("a") +
            kotlinFoo("b", number = 1) +
            kotlinFoo("c", toUpperCase = true) +
            kotlinFoo(name = "d", number = 2, toUpperCase = true))
}
