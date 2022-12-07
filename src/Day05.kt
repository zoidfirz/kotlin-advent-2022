fun main() {

//    PartOneSolution()
    var data = readInput("main/resources/Day05_input")
    var crateArray: MutableList<CrateRow> = arrayListOf()
    var workingList: MutableList<String> = arrayListOf()

    var rowOne = CrateRow(1, "")
    var rowTwo = CrateRow(2, "")
    var rowThree = CrateRow(3, "")
    var rowFour = CrateRow(4, "")
    var rowFive = CrateRow(5, "")
    var rowSix = CrateRow(6, "")
    var rowSeven = CrateRow(7, "")
    var rowEight = CrateRow(8, "")
    var rowNine = CrateRow(9, "")
    data.forEach { chunk ->
        workingList.add("$chunk              ")
    }

    for (i in 0..7) {
        rowOne.crates += workingList[i][1]
        rowTwo.crates += workingList[i][5]
        rowThree.crates += workingList[i][9]
        rowFour.crates += workingList[i][13]
        rowFive.crates += workingList[i][17]
        rowSix.crates += workingList[i][21]
        rowSeven.crates += workingList[i][25]
        rowEight.crates += workingList[i][29]
        rowNine.crates += workingList[i][33]
    }
    crateArray.add(rowOne)
    crateArray.add(rowTwo)
    crateArray.add(rowThree)
    crateArray.add(rowFour)
    crateArray.add(rowFive)
    crateArray.add(rowSix)
    crateArray.add(rowSeven)
    crateArray.add(rowEight)
    crateArray.add(rowNine)

    crateArray.forEach {
        it.crates = it.crates.replace(" ", "")
    }

    for (i in 10 until data.size) {
//    for (i in 5 until data.size) {
        var movementArrayHolder = data[i].split(" ")
        var movement = Movement(
            movementArrayHolder[1].toInt(),
            movementArrayHolder[3].toInt(),
            movementArrayHolder[5].toInt(),
            crateArray
        )
        movement.moveStackPartTwo()
    }

    crateArray.forEach {
        println(it.crates.toString())
    }

}

private fun PartOneSolution() {
    var data = readInput("main/resources/Day05_input")
    var crateArray: MutableList<CrateRow> = arrayListOf()
    var workingList: MutableList<String> = arrayListOf()

    var rowOne = CrateRow(1, "")
    var rowTwo = CrateRow(2, "")
    var rowThree = CrateRow(3, "")
    var rowFour = CrateRow(4, "")
    var rowFive = CrateRow(5, "")
    var rowSix = CrateRow(6, "")
    var rowSeven = CrateRow(7, "")
    var rowEight = CrateRow(8, "")
    var rowNine = CrateRow(9, "")
    data.forEach { chunk ->
        workingList.add("$chunk              ")
    }

    for (i in 0..7) {
        rowOne.crates += workingList[i][1]
        rowTwo.crates += workingList[i][5]
        rowThree.crates += workingList[i][9]
        rowFour.crates += workingList[i][13]
        rowFive.crates += workingList[i][17]
        rowSix.crates += workingList[i][21]
        rowSeven.crates += workingList[i][25]
        rowEight.crates += workingList[i][29]
        rowNine.crates += workingList[i][33]
    }
    crateArray.add(rowOne)
    crateArray.add(rowTwo)
    crateArray.add(rowThree)
    crateArray.add(rowFour)
    crateArray.add(rowFive)
    crateArray.add(rowSix)
    crateArray.add(rowSeven)
    crateArray.add(rowEight)
    crateArray.add(rowNine)

    crateArray.forEach {
        it.crates = it.crates.replace(" ", "")
    }

//    var movementArray: MutableList<Int> = arrayListOf()
    for (i in 10 until data.size) {
        var movementArrayHolder = data[i].split(" ")
        var movement = Movement(
            movementArrayHolder[1].toInt(),
            movementArrayHolder[3].toInt(),
            movementArrayHolder[5].toInt(),
            crateArray
        )
//        println(movement.toString())
        movement.moveStackPartOne()
    }

    crateArray.forEach {
        println(it.crates)
    }
}

class Movement(
    var amountToMove: Int,
    val moveFromRow: Int,
    var moveToRow: Int,
    var crateStacks: MutableList<CrateRow>
) {
    override fun toString(): String {
        return "amountToMove: $amountToMove, moveFromRow: $moveFromRow, moveToRow: $moveToRow"
    }

    fun moveStackPartOne() {
        crateStacks.forEach { stack ->
//            println("${stack.crates} ${stack.rowId} - count = ${stack.crates.length}")
        }
        var stackAccessed = crateStacks.filter { it.rowId == moveFromRow }[0]
        var stringWithNoSpaces = stackAccessed.crates.replace(" ", "")
        var stackBeingAddedTo = crateStacks.filter { it.rowId == moveToRow }[0]
        stackBeingAddedTo.crates = stackBeingAddedTo.crates.replace(" ", "")

        var tempDeletedString = stackAccessed.crates
        for (i in 0 until amountToMove) {

            var letter = stringWithNoSpaces[i]
            tempDeletedString = tempDeletedString.drop(1)
//            println("adding $letter to ${stackBeingAddedTo.crates}")
//            println("old stack $tempDeletedString")
            stackBeingAddedTo.crates = "$letter${stackBeingAddedTo.crates}"
        }
        stackAccessed.crates = tempDeletedString


    }

    fun moveStackPartTwo() {
        crateStacks.forEach { stack ->
//            println("${stack.crates} ${stack.rowId} - count = ${stack.crates.length}")
        }
        var stackAccessed = crateStacks.filter { it.rowId == moveFromRow }[0]
        var stringWithNoSpaces = stackAccessed.crates.replace(" ", "")
        var stackBeingAddedTo = crateStacks.filter { it.rowId == moveToRow }[0]
        stackBeingAddedTo.crates = stackBeingAddedTo.crates.replace(" ", "")
        stackBeingAddedTo.crates = "${stackAccessed.crates.substring(0, amountToMove)}${stackBeingAddedTo.crates}"


        var tempDeletedString = stackAccessed.crates
        for (i in 0 until amountToMove) {

            var letter = stringWithNoSpaces[i]
            tempDeletedString = tempDeletedString.drop(1)
//            stackBeingAddedTo.crates = "$letter${stackBeingAddedTo.crates}"
        }
        stackAccessed.crates = tempDeletedString


    }
}


class CrateRow(val rowId: Int, var crates: String) {

    fun moveFromRow(amountToRemove: Int): String {
        var tempString = crates.replace(" ", "")
        var result = ""
        return tempString.substring(0, amountToRemove)
    }

    fun deleteFromRow(amountToRemove: Int) {
//        crates.replaceRange(startIndex = 0, endIndex = amountToRemove, "")
        crates.removeRange(0, amountToRemove)
    }

    fun addToRow(valueToAdd: String) {
        crates = crates.replace(" ", "")
        crates = "$valueToAdd$crates"
    }
}
