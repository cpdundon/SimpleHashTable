package com.example.simplehashtable.utils

import java.security.MessageDigest

class HashTableGeneric <in K, V> (val size : Int) {
    private val table = MutableList<V?>(size) {null}

    public fun getValue(key: K) : V? {
        return table[hashOfKey(key.toString())]
    }

    public fun insertValue(key : K, value : V) : Boolean {
        val idx = hashOfKey(key.toString())
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

        var subSet = 0
        for (i in 0 .. 8) {
            var twoPow = 1
            for (j in 1 .. i) twoPow *= 2
            subSet += sha[i] * twoPow
        }
        return size and subSet
    }
}