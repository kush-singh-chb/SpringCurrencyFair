package com.kushcurrencyfair.demo.model

import java.time.LocalDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class TradeData {
    @Id
    @GeneratedValue
    val id: Long? = null
    lateinit var userId: String
    lateinit var currencyFrom: String
    lateinit var currencyTo: String
    var amountSell: Float? = null
    var amountBuy: Float? = null
    var rate: Float? = null
    lateinit var timePlaced: String
    lateinit var originatingCountry: String
}