private const val X = 347991
 var cc = 0

fun main(args: Array<String>) {
//    var x = 347991.toDouble()
    /*for (i in 1..591 step 2) {
        printlnln("$i: ${i.toDouble().pow(2)}")
    }*/
/*
    println(rowCounter(8))
    println(rowCounter(24))
    println(rowCounter(48))
    println(getNumArrayForRow(7))
    println(getNumArrayForRow(5))
    println(getNumArrayForRow(3))
    println(getNumArrayForRow(11))

    println(findFirstCenter(7, 3))
    println(findFirstCenter(5, 2))
    println(findFirstCenter(3, 1))
    println(findFirstCenter(13, 6))
    println()
    println(returnPos(3, 47, 49, 46, false))
    println(returnPos(3, 48, 49, 46, false))
    println(returnPos(3, 45, 46, 43, true))
    println(returnPos(3, 44, 46, 43, true))
    println()*/
//    f(7,3, 36)
//    f(5, 2, 10)
//    f(7, 3, 29)
//    f(3, 1, 9)
/*
    f(3,1, 2)
    f(3,1, 3)
    f(3,1, 4)
    f(3,1, 5)
    f(3,1, 6)
    f(3,1, 7)
    f(3,1, 8)
    f(3,1, 9)
*/
    for (i in 10..25) {
        f2(5, 2, i)
    }
    println("XX $cc")
//    f(5,2, 23)
}

fun rowCounter(number: Int): Pair<Int, Int> {
    var prev = 0
    for ((row, i) in (1..500 step 2).withIndex()) {
        if (i * i >= number) {
            return Pair(prev, row - 1)
        }
        prev = i * i
    }
    return Pair(0, 0)
}

fun getNumArrayForRow(i: Int): List<Int> {
    val round = i + i + (i - 2) + (i - 2)
    var countdown2 = i * i
    val array = mutableListOf<Int>()
    for (j in 1..round) {
        array.add(countdown2--)
    }
    return array
}

fun findFirstCenter(amountInRow: Int, row: Int) = amountInRow * amountInRow - row

fun findNextCenter(amountInRow: Int, row: Int, startsFrom: Int) = startsFrom - amountInRow

fun returnPos(row: Int, x: Int, end: Int, begin: Int, viceVersa: Boolean): Int {
    cc++
    if (x == end) {
        println("X1")
        return 2 * row
    }
    if (x == begin) {
        println("x2")
        return 0
    }
    if (!viceVersa) {
        for ((counter, i) in (begin..end).withIndex()) {
            if (x == i) {
                println("X3")
                return counter
            }
        }
    } else {
        for ((counter, i) in (end downTo begin).withIndex()) {
            if (x == i) {
                println("X4")
                return counter
            }
        }
    }
    return 0
}

fun f2(sqr: Int, row: Int, x: Int) {
    println("actual x: $x")
    val array = getNumArrayForRow(sqr)
    println(array)
    var viceVersa = false
    for (i in array.first() downTo array.last() step row) {
        println("XXX $i")
        val gain = returnPos(row, x, i, i - row, viceVersa)
        if (gain > 0) {
            println(gain + row)
            break
        }
        viceVersa = !viceVersa
    }
}