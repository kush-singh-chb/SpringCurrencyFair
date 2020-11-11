package com.kushcurrencyfair.demo.exception

internal class TradeDataNotFoundException(id: Long) : RuntimeException("Trade Data Not Found")