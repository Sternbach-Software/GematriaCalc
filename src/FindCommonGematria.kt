fun main() {
    var word1 = "ABC"
    var word2 = "DEF"
    var listOfGematrias1: Array<Int> = calcGematria(word1)
    var listOfGematrias2: Array<Int> = calcGematria(word2)
    val commonGematriasWithRespectToFirstWord: MutableMap<Int, Int> = mutableMapOf(
        /*typeOfGematriaRepresentedAsIndexInListOfGematriaBeingCalculated to valueOfGematria,
        etc1 to etc2*/
    )
    val commonGematriasWithRespectToSecondWord: MutableMap<Int, Int> = mutableMapOf(
        /*typeOfGematriaRepresentedAsIndexInListOfGematriaBeingCalculated to valueOfGematria,
        etc1 to etc2*/
    )
    var mapOfIndexesToGematriaNames: Map<Int, String> = mapOf(
        0 to "Mispar Hechrachi",
        1 to "Mispar Gadol",
        2 to "Mispar Siduri",
        3 to "Mispar Katan",
        4 to "Mispar Perati",
        5 to "Mispar Shemi",
        6 to "Mispar Musafi",
        7 to "Atbash",
        8 to "Albam",
        9 to "Mispar Boneeh",
        10 to "Mispar Kidmi",
        11 to "Mispar Neelam",
        12 to "Mispar Meshulash",
        13 to "Mispar Haakhor",
        14 to "Mispar Mispari",
        15 to "Achbi",
        16 to "Atbach",
        17 to "Ayakbakar",
        18 to "Ofanim",
        19 to "Achasbeta",
        20 to "Avgad",
        21 to "Reverse Avgad"
    )
    for (gematria1 in listOfGematrias1) {
        for (gematria2 in listOfGematrias2) {
            if (gematria1 == gematria2) {
                commonGematriasWithRespectToFirstWord += (listOfGematrias1.indexOf(gematria1) to gematria1)
                commonGematriasWithRespectToSecondWord += (listOfGematrias2.indexOf(gematria2) to gematria2)
            }
        }
    }
    var numberOfCommonValues =
        commonGematriasWithRespectToFirstWord.size //should equally work if queried with respect to list of second word, because theoretically they should have the same number of matches, just chose first arbitrarily
    var arrayOfAnswerStringsToPrint: Array<String> = Array(numberOfCommonValues) {""}
    var counter = 0
    for ((key, value) in commonGematriasWithRespectToFirstWord) {
        arrayOfAnswerStringsToPrint[counter] =
            ("\nThe " + mapOfIndexesToGematriaNames[key] + " of " + word1 + " (" + commonGematriasWithRespectToFirstWord[key] + ") = ")//e.g. "The Mispar Musafi of ABC (9) = "
        counter++
    }
    counter = 0
    for ((key, value) in commonGematriasWithRespectToSecondWord) {
        arrayOfAnswerStringsToPrint[counter] += "the " + mapOfIndexesToGematriaNames[key] + " of " + word2 + " (" + commonGematriasWithRespectToSecondWord[key] + ")"
        counter++
    }
    println(arrayOfAnswerStringsToPrint.contentToString())
/*should print: "The Mispar Gadol of ABC (17) = the Mispar Hechrachi of DEF (17),
               The Mispar Katan of ABC (9) = the Mispar Siduri of DEF (9),
               The Achasbeta of ABC (19) = the Achasbeta of DEF (19)*/
}

fun calcGematria(word: String): Array<Int> {
    //dummy data:
    return if (word == "ABC") arrayOf(100,17,102,9,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,19,120,121)
    else arrayOf(17,201,9,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,19,220,221)
}