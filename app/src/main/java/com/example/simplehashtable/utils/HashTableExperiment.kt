package com.example.simplehashtable.utils

import java.security.MessageDigest

class HashTableExperiment (val size : Int) {
    private val table = Array<String?>(size) { null }

    public fun getValue(key: String) : String? {
        return table[hashOfKey(key)]
    }

    public fun insertValue(key : String, value : String) : Boolean {
        val idx = hashOfKey(key)
        return if (table[idx] == null) {
            table[idx] = value
            true
        } else {
            false
        }
    }

    private fun sha256(inp : String) : ByteArray {
        val md = MessageDigest.getInstance("SHA-256")
        val input = inp.toByteArray(Charsets.UTF_8)
        return md.digest(input)
    }

    private fun hashOfKey (key : String) : Int {
        val sha = sha256(key)
        val that = sha

        var subSet: Int = 0
        for (i in 0 .. 8) {
            var twoPow: Int = 1
            for (j in 1 .. i) twoPow *= 2
            subSet += sha[i] * twoPow
        }
        return size and subSet
    }
}