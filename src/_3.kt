private const val X = 347991

fun main(args: Array<String>) {
/*
    println(getRowNumberFromSouthEastDiagonalesNumber(121.toFloat()))
    println(getRowNumberFromSouthEastDiagonalesNumber(81.toFloat()))
    println(getRowNumberFromSouthEastDiagonalesNumber(49.toFloat()))
    println(getRowNumberFromSouthEastDiagonalesNumber(25.toFloat()))
    println()
    println(getArrayCompleteCircleOfRow(3))
    println(getArrayCompleteCircleOfRow(5))
    println(getArrayCompleteCircleOfRow(7))
    println(getArrayCompleteCircleOfRow(9))
    println()
    println(getOtherPartOfDistance(49, 3, false, 46))
    println(getOtherPartOfDistance(49, 3, false, 47))
    println(getOtherPartOfDistance(49, 3, false, 48))
    println(getOtherPartOfDistance(49, 3, false, 49))
    println()
    println(getOtherPartOfDistance(46, 3, true, 46))
    println(getOtherPartOfDistance(46, 3, true, 45))
    println(getOtherPartOfDistance(46, 3, true, 44))
    println(getOtherPartOfDistance(46, 3, true, 43))
    println()
    println(findFourCenters(getArrayCompleteCircleOfRow(3),1).toSortedSet())
    println(findFourCenters(getArrayCompleteCircleOfRow(5),2).toSortedSet())
    println(findFourCenters(getArrayCompleteCircleOfRow(7),3).toSortedSet())

    for (i in 26..49) {
        println("X: $i")
        println(f(3, i))
    }
    for (i in 10..25) {
        println("X: $i")
        println(f(2, i))
    }*/

    println(getMangattanDistance(X))
}

fun getNighToXSouthEastDiagonalesNumber(x: Int): Int {
    var previous = 1
    while (x > previous * previous) {
        previous += 2
    }
    return previous
}

fun getRowNumberFromSouthEastDiagonalesNumber(number: Float) = ((number - 1) / 2).toInt()

fun getArrayCompleteCircleOfRow(diagonaleNumberRooted: Int): List<Int> {
    val round = 2 * diagonaleNumberRooted + 2 * (diagonaleNumberRooted - 2)
    var max = diagonaleNumberRooted * diagonaleNumberRooted
    val array = mutableListOf<Int>()
    for (j in 1..round) {
        array.add(max--)
    }
    return array
}

fun getOtherPartOfDependency(max: Int, rowNumber: Int, viceVersa: Boolean, x: Int, isFirst: Boolean = false): Int {
    if (!viceVersa) {
        val min = max
        val max = min + rowNumber
        for ((index, i) in (min..max).withIndex()) {
            if (x == i) return index
        }
    } else {
        val min = if (isFirst) max - rowNumber + 1 else max - rowNumber
        var reverseCounter = if (isFirst) rowNumber - 1 else rowNumber
        for (i in min..max) {
            if (x == i) {
                return reverseCounter
            } else {
                reverseCounter--
            }
        }
    }
    return -1
}

fun findFourCenters(circleArray: List<Int>, row: Int): IntArray {
    val fourCenters = IntArray(4)
    var x = circleArray.first() - row
    for (i in 0..3) {
        fourCenters[i] = x
        x -= row * 2
    }
    return fourCenters
}

fun getMangattanDistance(x: Int): Int {
    val diagonaleNumberRooted = getNighToXSouthEastDiagonalesNumber(X)
    val row = getRowNumberFromSouthEastDiagonalesNumber(diagonaleNumberRooted.toFloat())
    val set = findFourCenters(getArrayCompleteCircleOfRow(diagonaleNumberRooted), row).toSortedSet()
    set.forEachIndexed { index, i ->
        if (index == 0) {
            val a = getOtherPartOfDependency(i, row, true, x, true)
            if (a != -1) return a + row
            val a2 = getOtherPartOfDependency(i, row, false, x, true)
            if (a2 != -1) return a2 + row
        } else {
            val a = getOtherPartOfDependency(i, row, true, x)
            if (a != -1) return a + row
            val a2 = getOtherPartOfDependency(i, row, false, x)
            if (a2 != -1) return a2 + row
        }
    }
    return 0
}