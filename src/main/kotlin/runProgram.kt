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
    val userInput = readln().toInt()

    menuOptions(userInput)
}

private fun menuOptions(option: Int) {
    when (option) {
        1 -> semesterToQuarter()
        2 -> quarterToSemester()
        3 -> exitProcess(0)
        else -> menu()
    }
}

private fun semesterToQuarter() {
    val msg = "Great! How many credits?"
    println(msg)

    val semesterCredits = readln().toInt()
    val convertedCredits = semesterCredits.times(1.5)
    val convertedMsg = "$semesterCredits Semester credits were converted to $convertedCredits Quarter Credits."

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
    val convertedMsg = "$quarterCredits Quarter credits were converted to $convertedCredits Semester Credits."

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