package com.kushcurrencyfair.demo.repository

import com.kushcurrencyfair.demo.model.TradeData
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface TradeRepo : JpaRepository<TradeData, Long> {
    @Query("SELECT t from TradeData t where t.currencyFrom = :from and t.currencyTo = :to")
    fun findByCurrency(@Param("from") from: String, @Param("to") to: String): List<TradeData>
}