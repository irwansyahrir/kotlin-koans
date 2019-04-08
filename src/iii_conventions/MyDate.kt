package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return when {
            this.year < other.year -> -1
            this.year > other.year -> 1
            this.month < other.month -> -1
            this.month > other.month -> 1
            this.dayOfMonth < other.dayOfMonth -> -1
            this.dayOfMonth > other.dayOfMonth -> 1
            else -> 0
        }
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange {
    return DateRange(this, other)
}

operator fun MyDate.inc(): MyDate {
    return this.nextDay()
}

operator fun MyDate.plus(interval: TimeInterval): MyDate {
    return this.addTimeIntervals(interval, 1)
}

operator fun MyDate.plus(repeated: RepeatedTimeInterval): MyDate {
    return this.addTimeIntervals(repeated.interval, repeated.times)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

operator fun TimeInterval.times(n: Int): RepeatedTimeInterval {
    return RepeatedTimeInterval(this, n)
}

class RepeatedTimeInterval(val interval: TimeInterval, val times: Int)


class DateRange(val start: MyDate, val endInclusive: MyDate): Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return MyDateIterator(start, endInclusive)
    }
}

class MyDateIterator(start: MyDate, private val endInclusive: MyDate): Iterator<MyDate> {
    private var current = start
    override fun hasNext(): Boolean {
        return current <= endInclusive
    }

    override fun next(): MyDate {
        return current++
    }
}

operator fun DateRange.contains(d: MyDate): Boolean {
    return this.start <= d && d <= this.endInclusive
}