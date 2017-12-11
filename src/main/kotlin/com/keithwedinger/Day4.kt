package com.keithwedinger

import java.io.InputStream

/**
 * Day 4 Puzzle
 * http://adventofcode.com/2017/day/4
 *
 * @author Keith Wedinger <br>
 * Created On: 12/11/17
 */

// Extension function that determines if the String passed in is an anagram
// of the String instance
fun String.isAnagramOf(otherWord: String) : Boolean {
    var isAnagram = false
    // Two strings are anagrams of each other if their
    // lengths are equal and their sorted characters are equal
    if (this.length == otherWord.length) {
        val sortedThisChars = this.toCharArray()
        sortedThisChars.sort()
        val sortedOtherWordChars = otherWord.toCharArray()
        sortedOtherWordChars.sort()
        isAnagram = (sortedThisChars.contentToString() == sortedOtherWordChars.contentToString())
    }
    return isAnagram
}

class Day4 {
    fun isValidPassphrasePart1(passphrase: String) : Boolean {
        return if (passphrase.isNotEmpty()) {
            val passphraseWords = passphrase.split(" ")
            val distinctPassphraseWords = passphraseWords.distinct()
            (passphraseWords.size == distinctPassphraseWords.size)
        } else {
            false
        }
    }

    fun countValidPassphrases(passphraseInputStream: InputStream) : Int {
        var validPassphrases = 0
        passphraseInputStream.bufferedReader().useLines { passphrases ->
            passphrases.forEach { currentPassphrase ->
                if (isValidPassphrasePart1(currentPassphrase)) validPassphrases++
            }
        }
        return validPassphrases
    }
}