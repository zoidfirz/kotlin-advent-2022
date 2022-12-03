fun main() {

    firstHalfSolution()
    secondHalfSolution()
}

private fun secondHalfSolution() {
    val data = readInput("main/resources/Day03_Input")


    val groupedData = data.chunked(3)
    var sum = 0
    groupedData.forEach { chunk ->
        var badge: Char = ' '
        chunk[0].forEach { charChunk ->
            if (chunk[1].contains(charChunk)) {
                if (chunk[2].contains(charChunk)) {
                    badge = charChunk
                }
            }
        }
        if (badge.isLowerCase()) {
            sum += getLowerCasePointValue(badge.toString())
        } else {
            sum += getUpperCasePointValue(badge.toString())
        }

    }
    println(sum)
}

private fun firstHalfSolution() {
    //        Parse examples into variable
    val data = readInput("main/resources/Day03_Input")

    var duplicate: MutableList<Char> = arrayListOf()

    data.forEach { it ->
//        split string evenly in two parts
        val mid = it.length / 2
        val a = it.substring(0, mid).toSet()
        val b = it.substring(mid, it.length).toSet()

        // find duplicates in the arrays and assign them to a new array
        a.forEach { obj ->
            if (b.contains(obj)) {
                duplicate.add(obj)
            }
        }

    }

    println(duplicate)
    //separate the newly formed duplicate array into lower and upper case letter arrays
    var (lowerCaseArr, upperCaseArr) = duplicate.partition { it.isLowerCase() }

    var sum = 0

    // getPointValue of lower case letters
    var lowerCaseArrPoints = lowerCaseArr.map { getLowerCasePointValue(it.toString()) }

    // getPointValue of upper case letters
    var upperCaseArrPoints = upperCaseArr.map { getUpperCasePointValue(it.toString()) }


    //add values of lower case letters and upper case letters
    sum = lowerCaseArrPoints.sum() + upperCaseArrPoints.sum()


    println(sum)
}

fun getLowerCasePointValue(value: String): Int {
    return when (value) {
        "a" -> 1
        "b" -> 2
        "c" -> 3
        "d" -> 4
        "e" -> 5
        "f" -> 6
        "g" -> 7
        "h" -> 8
        "i" -> 9
        "j" -> 10
        "k" -> 11
        "l" -> 12
        "m" -> 13
        "n" -> 14
        "o" -> 15
        "p" -> 16
        "q" -> 17
        "r" -> 18
        "s" -> 19
        "t" -> 20
        "u" -> 21
        "v" -> 22
        "w" -> 23
        "x" -> 24
        "y" -> 25
        "z" -> 26

        else -> 0
    }
}

fun getUpperCasePointValue(value: String): Int {
    val lower = value.lowercase()
    val lowercasePoints = getLowerCasePointValue(lower)
    return lowercasePoints + 26
}
