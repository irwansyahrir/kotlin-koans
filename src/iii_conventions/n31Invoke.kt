package iii_conventions

import util.TODO


data class Invokable(var numberOfInvocation: Int = 0)

operator fun Invokable.invoke(): Invokable {
    numberOfInvocation += 1
    return this
}

fun Invokable.getNumberOfInvocations(): Int {
    return numberOfInvocation
}

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change the class 'Invokable' to count the number of invocations:
        for 'invokable()()()()' it should be 4.
    """,
    references = { invokable: Invokable -> })

fun task31(invokable: Invokable): Int {
    return invokable()()()().getNumberOfInvocations()
}
