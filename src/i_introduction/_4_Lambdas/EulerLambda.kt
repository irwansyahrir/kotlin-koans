package i_introduction._4_Lambdas

fun numbersDivisibleByThreeOrFiveBelow(top: Int): List<Int> {
    val divisibles : MutableList<Int> = mutableListOf()

    val mod3 : (Int) -> Boolean =  { it.rem(3) == 0}
    val mod5 : (Int) -> Boolean =  { it.rem(5) == 0}

    for (i in 1..(top-1)) {
        if (mod3(i) || mod5(i)) {
            divisibles.add(i)
        }
    }

    return divisibles
}

fun sumOfNumbersDivisibleByThreeOrFiveBelow(topLimit: Int): Int {
    return numbersDivisibleByThreeOrFiveBelow(topLimit).sum()
}

fun fibo(x: Int): List<Int> {
    val fibos : MutableList<Int> = mutableListOf()
    for (i in 1..x) {
        if (i <= 2) {
            fibos.add(i)
        } else {
            fibos.add(fibos.get(i-2) + fibos.get(i-3))
        }
    }
    return fibos
}

fun maxFibo(x: Int): Int {
    return fibo(x).last()
}


fun numOfTermForValueBelow(x: Int): Int {
    var seed = 1

    while (maxFibo(seed) < x) {
        seed += 1
    }

    return seed -1
}

fun sumOfEvenTermsForFibo(x: Int): Int {
    return fibo(x).filter { f -> f.rem(2) == 0  }.sum()
}
