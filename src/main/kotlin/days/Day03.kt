package days

import Day
import jdk.jshell.spi.ExecutionControl.NotImplementedException
object Day03 : Day(3, "Rucksack Reorganization") {

    private var sharedItems = mutableListOf<Char>()
    private var badgeItems = mutableListOf<Char>()
    private const val ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"


    init {
        sharedItems = inputList.map {
            it.subSequence(0, it.length/2)
                .first { char -> it.subSequence(it.length/2, it.length).contains(char) }
        } as MutableList<Char>

        badgeItems = inputList.chunked(3) {
            it[0]
                .filter { item -> it[1].contains(item) }
                .first { item -> it[2].contains(item) }
        } as MutableList<Char>
    }

    override fun partOne() : Int {
        return sharedItems.fold(0) {acc, c -> acc+ ALPHABET.indexOf(c)+1 }
    }
    override fun partTwo() : Int {
        return badgeItems.fold(0) {acc, c -> acc+ ALPHABET.indexOf(c)+1 }
    }}

