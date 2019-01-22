package i_introduction._4_Lambdas

fun numbersDivisibleByThreeOrFiveBelow(top: Int): List<Int> {
    val divisibles : MutableList<Int> = mutableListOf()

    val isRemBy3 : (Int) -> Boolean =  { it.rem(3) == 0}
    val isRemBy5 : (Int) -> Boolean =  { it.rem(5) == 0}

    for (i in 1..(top-1)) {
        if (isRemBy3(i) || isRemBy5(i)) {
            divisibles.add(i)
        }
    }

    return divisibles
}

fun sumOfNumbersDivisibleByThreeOrFiveBelow(topLimit: Int): Int {
    return numbersDivisibleByThreeOrFiveBelow(topLimit).sum()
}
