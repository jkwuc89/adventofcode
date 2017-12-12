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
        isAnagram = (sortedThisChars.joinToString("") == sortedOtherWordChars.joinToString(""))
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

    fun isValidPassphrasePart2(passphrase: String) : Boolean {
        val validPassphrase : Boolean
        if (passphrase.isNotEmpty()) {
            val passphraseWords = passphrase.split(" ")
            validPassphrase = if (passphraseWords.isNotEmpty()) {
                val passphraseWordsWithSortedChars = HashMap<String, Int>()
                passphraseWords.forEach { currentWord ->
                    val sortedWordChars = currentWord.toCharArray()
                    sortedWordChars.sort()
                    passphraseWordsWithSortedChars.put(sortedWordChars.joinToString(""), 0)
                }
                (passphraseWords.size == passphraseWordsWithSortedChars.size)
            } else {
                false
            }
        } else {
            validPassphrase = false
        }
        return validPassphrase
    }

    fun countValidPassphrases(passphraseInputStream: InputStream, isValidPassphrase: (passphrase: String) -> Boolean) : Int {
        var validPassphrases = 0
        passphraseInputStream.bufferedReader().useLines { passphrases ->
            passphrases.forEach { currentPassphrase ->
                if (isValidPassphrase(currentPassphrase)) validPassphrases++
            }
        }
        return validPassphrases
    }
}