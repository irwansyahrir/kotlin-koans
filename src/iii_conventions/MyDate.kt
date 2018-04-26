package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int): Comparable<MyDate> {
    override fun compareTo(other: MyDate) = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }

    operator fun inc(): MyDate {
        return this.nextDay()
    }

    operator fun plus(timeInterval: TimeInterval) = when (timeInterval) {
        TimeInterval.YEAR -> this.nextYear()
        TimeInterval.WEEK -> this.nextWeek()
        else -> this.nextDay()
    }

    operator fun plus(repeated : RepeatedTimeInterval) = when (repeated.interval) {
        TimeInterval.YEAR -> this.addTimeIntervals(repeated)
        TimeInterval.WEEK -> this.addTimeIntervals(repeated)
        else -> this.addTimeIntervals(repeated)
    }

    private fun addTimeIntervals(repeated: RepeatedTimeInterval) : MyDate {
        return this.addTimeIntervals(repeated.interval, repeated.times)
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange {
    return DateRange(this, other)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR;

    operator fun times(i: Int): RepeatedTimeInterval {
        return RepeatedTimeInterval(this, i)
    }
}

data class RepeatedTimeInterval(val interval: TimeInterval, val times: Int)

class DateRange(val start: MyDate, val endInclusive: MyDate) {
    operator fun contains(d: MyDate): Boolean {
        return start <= d && d <= endInclusive
    }

    operator fun iterator(): Iterator<MyDate> {
        return DateRangeIterator(start, endInclusive)
    }
}

class DateRangeIterator(start: MyDate, private val endInclusive: MyDate) : Iterator<MyDate> {
    private var current = start

    override fun hasNext(): Boolean {
        return current <= endInclusive
    }

    override fun next(): MyDate {
        return current++
    }

}