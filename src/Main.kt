import javax.swing.JFrame
import javax.swing.JOptionPane
import kotlin.system.exitProcess


data class Double1(var first: Boolean, var second: Char)

fun main() {
    val illegalArgument = Double1(false, ' ')
    var inputString = ""
    var inputStringList: List<String>
    val mantzifuchMode = when (JOptionPane.showConfirmDialog(
        null,
        "Would you like the letters מנץף\"ך to equal 500,600,700,800, and 900 (answer \"No\" for them to equal their respective regular letters)?",
        "Gematria Calculator",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE
    )) {
        0 -> true
        else -> false
    }
    println(mantzifuchMode)
    getInput@ while (true) {
        var gematria = 0
        if (illegalArgument.first && (ordinal(inputString.indexOf(illegalArgument.second) + 1)) != "0th") JOptionPane.showInternalMessageDialog(null,
            "Illegal input: \"${illegalArgument.second}\" at the ${ordinal(
                inputString.indexOf(illegalArgument.second) + 1
            )} character. Please try again.","Please Try Again", JOptionPane.ERROR_MESSAGE
        )
        inputString = JOptionPane.showInputDialog("Enter word or phrase to compute: ")
        inputStringList = inputString.split(" ")
        for (inputWord in inputStringList) {
            for (input in inputWord) {
                val answer = when (input) {
                    'א' -> 1
                    'ב' -> 2
                    'ג' -> 3
                    'ד' -> 4
                    'ה' -> 5
                    'ו' -> 6
                    'ז' -> 7
                    'ח' -> 8
                    'ט' -> 9
                    'י' -> 10
                    'כ' -> 20
                    'ך' -> if (mantzifuchMode) 900 else 20
                    'ל' -> 30
                    'מ' -> 40
                    'ם' -> if (mantzifuchMode) 500 else 40
                    'נ' -> 50
                    'ן' -> if (mantzifuchMode) 600 else 50
                    'ס' -> 60
                    'ע' -> 70
                    'פ' -> 80
                    'ף' -> if (mantzifuchMode) 800 else 80
                    'צ' -> 90
                    'ץ' -> if (mantzifuchMode) 700 else 90
                    'ק' -> 100
                    'ר' -> 200
                    'ש' -> 300
                    'ת' -> 400
                    else -> null
                }
                if (answer != null) gematria += answer else {
                    illegalArgument.first = true
                    illegalArgument.second = input
                    continue@getInput
                }
            }
        }
        JOptionPane.showMessageDialog(null, "The gematria is: $gematria")
        println()
        val doItAgain = JOptionPane.showConfirmDialog(
            null, "Would you like to calculate another word? (Y or N): ", "Gematria Calculator",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        )
        when (doItAgain) {
            0 -> continue@getInput
            1 -> break@getInput
            else -> break@getInput
        }
    }
    exitProcess(0)
}



fun ordinal(i: Int): String? {
    val suffixes = listOf("th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th")
    return when (i % 100) {
        11, 12, 13 -> i.toString() + "th"
        else -> "$i${suffixes[i % 10]}"
    }
}