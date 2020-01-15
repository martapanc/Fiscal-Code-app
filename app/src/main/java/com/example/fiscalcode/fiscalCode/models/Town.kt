package com.example.fiscalcode.fiscalCode.models

class Town(val townName: String, val townCode: String) {

    override fun toString(): String {
        return "$townName $townCode"
    }
}
