import java.math.RoundingMode
import kotlin.system.exitProcess

fun main() {
    runProgram()
}

private fun runProgram() {
    println("Welcome to Credit Converter!")
    menu()
}

private fun menu() {
    val welcomeMsg = "What type of credits are being converted?" +
            "\nPress 1 for Semester or 2 for Quarter or press 3 to Quit "
    println(welcomeMsg)

    val userInput = readln().toIntOrNull()
    if (userInput != null) {
        menuOptions(userInput)
    } else {
        println("Invalid input, numbers only")
        menu()
    }
}

private fun menuOptions(option: Int) {
    when (option) {
        1 -> semesterToQuarter()
        2 -> quarterToSemester()
        3 -> continueProgram()
        else -> {
            println("Error, input not valid. Valid inputs include 1, 2, & 3.")
            menu()
        }
    }
}

private fun semesterToQuarter() {
    val msg = "Great! How many credits?"
    println(msg)

    val semesterCredits = readln().toInt()
    val convertedCredits = semesterCredits.times(1.5)
    val convertedMsg = "$semesterCredits semester credits were converted to $convertedCredits quarter credits."

    println(convertedMsg)

    println()

    continueProgram()
}

private fun quarterToSemester() {
    val msg = "Great! How many credits?"
    println(msg)

    println()

    val quarterCredits = readln().toInt()
    val convertedCreditsRaw = quarterCredits.times(0.67).toBigDecimal()
    val convertedCredits = convertedCreditsRaw.setScale(2, RoundingMode.FLOOR)
    val convertedMsg = "$quarterCredits quarter credits were converted to $convertedCredits semester credits."

    println(convertedMsg)

    println()

    continueProgram()
}

private fun continueProgram() {
    println("Wish to continue? y for yes or n for no")

    val userInput = readLine()
    if (userInput != null) {
        if (userInput.lowercase() == "y" || userInput.lowercase() == "yes") {
            menu()
        } else {
            println("Thank you for using the credit converter, Goodbye!")
            exitProcess(0)
        }
    }
}