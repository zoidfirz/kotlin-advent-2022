fun main() {

    partOneSolution(readInput("main/resources/Day02_Input"))
    partTwoSolution(readInput("main/resources/Day02_Input"))
}


private fun partOneSolution(records: List<String>) {
    var sum = 0
    val newRecords = records.map { it.split(" ") }
    for (record in newRecords) {
        val p1Record = record[0]
        val p2Record = record[1]
        val p1 = firstColumnPlay(p1Record)
        val p2 = secondColumnPlay(p2Record)
        sum += checkWinnerPartOne(p1, p2)
    }
    println(sum)
}

private fun partTwoSolution(records: List<String>) {
    var sum = 0
    val newRecords = records.map { it.split(" ") }
    for (record in newRecords) {
        val p1Record = record[0]
        val desiredOutComeRecord = record[1]
        val p1 = firstColumnPlay(p1Record)
        val desiredOutCome = desiredResult(desiredOutComeRecord)
        sum += checkWinnerPartTwo(p1, desiredOutCome)
    }
    println(sum)
}


enum class RockPaperScissors(val pointValue: Int, val opponentLoss:Int, val opponentWin:Int) {
    Rock(1,3,2),
    Paper(2, 1,3),
    Scissors(3, 2, 1),
    None(0, 0, 0);
}




enum class Result() {
    Win, Lose, Draw, None
}
private fun firstColumnPlay(value: String): RockPaperScissors {
    when(value) {
        "A" -> return RockPaperScissors.Rock
        "B" -> return RockPaperScissors.Paper
        "C" -> return RockPaperScissors.Scissors
        else -> return RockPaperScissors.None
    }
}

private fun secondColumnPlay(value: String): RockPaperScissors{
    when(value) {
        "X" -> return RockPaperScissors.Rock
        "Y" -> return RockPaperScissors.Paper
        "Z" -> return RockPaperScissors.Scissors
        else -> return RockPaperScissors.None
    }
}

private fun desiredResult(value: String): Result{
    when(value) {
        "X" -> return Result.Lose
        "Y" -> return Result.Draw
        "Z" -> return Result.Win
        else -> return Result.None
    }
}
private fun checkWinnerPartOne(value1: RockPaperScissors, value2: RockPaperScissors): Int {
    return if(value1 == value2) { // draw
        3 + value2.pointValue
    }else if(value1 == RockPaperScissors.Rock && value2 == RockPaperScissors.Scissors ) {
        value2.pointValue // loss
    }else if (value1 == RockPaperScissors.Paper && value2 == RockPaperScissors.Rock ) {
        value2.pointValue // loss
    }else if (value1 == RockPaperScissors.Scissors && value2 == RockPaperScissors.Paper ) {
        value2.pointValue // loss
    }else if(value1 == RockPaperScissors.Rock && value2 == RockPaperScissors.Paper ) {
        value2.pointValue + 6 // winner
    }else if (value1 == RockPaperScissors.Paper && value2 == RockPaperScissors.Scissors ) {
        value2.pointValue + 6 // winner
    }else if (value1 == RockPaperScissors.Scissors && value2 == RockPaperScissors.Rock ) {
        value2.pointValue + 6 // winner
    }else 0
}

private fun checkWinnerPartTwo(playerOneInput: RockPaperScissors, desiredOutCome:Result ): Int {
    return when(desiredOutCome) {
        Result.Draw -> playerOneInput.pointValue + 3
        Result.Win -> playerOneInput.opponentWin + 6
        Result.Lose -> playerOneInput.opponentLoss
        else -> {
            0
        }
    }
//    return if(desiredOutCome == Des) { // draw
//        3 + value2.pointValue
//    }else if(value1 == RockPaperScissors.Rock && value2 == RockPaperScissors.Scissors ) {
//        value2.pointValue // loss
//    }else if (value1 == RockPaperScissors.Paper && value2 == RockPaperScissors.Rock ) {
//        value2.pointValue // loss
//    }else if (value1 == RockPaperScissors.Scissors && value2 == RockPaperScissors.Paper ) {
//        value2.pointValue // loss
//    }else if(value1 == RockPaperScissors.Rock && value2 == RockPaperScissors.Paper ) {
//        value2.pointValue + 6 // winner
//    }else if (value1 == RockPaperScissors.Paper && value2 == RockPaperScissors.Scissors ) {
//        value2.pointValue + 6 // winner
//    }else if (value1 == RockPaperScissors.Scissors && value2 == RockPaperScissors.Rock ) {
//        value2.pointValue + 6 // winner
//    }else 0
}