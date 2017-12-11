package com.keithwedinger

import java.io.InputStream

/**
 * Day 4 Puzzle
 * http://adventofcode.com/2017/day/4
 *
 * @author Keith Wedinger <br>
 * Created On: 12/11/17
 */

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