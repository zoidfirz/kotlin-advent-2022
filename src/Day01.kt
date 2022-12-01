fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1)

    val input = readInput("Day01Input")
    var highNumber: Int = 0
    var arrOfCalories:MutableList<Int> = ArrayList()
    var sum:Int = 0
    for (i in input.indices){
        if (input[i] != "") {
            sum += input[i].toInt()
        } else {
            arrOfCalories.add(sum)
            sum = 0
        }
    }

    arrOfCalories.sort()
    arrOfCalories.reverse()
    println(arrOfCalories[0]+arrOfCalories[1]+ arrOfCalories[2])

//    println(part1(input))
//    println(part2(input))
}
