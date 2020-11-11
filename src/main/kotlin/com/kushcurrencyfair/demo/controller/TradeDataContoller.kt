package com.kushcurrencyfair.demo.controller

import com.kushcurrencyfair.demo.model.TradeData
import com.kushcurrencyfair.demo.repository.TradeRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class TradeDataController {
    @Autowired
    var repository: TradeRepo? = null

    @PostMapping("/save_tradeData")
    fun newData(@RequestBody tradeData: TradeData): ResponseEntity<Any> {
        return if ((tradeData.amountBuy!! / tradeData.amountSell!!) == tradeData.rate) {
            val response = repository?.save(tradeData)
            ResponseEntity.status(HttpStatus.CREATED).body(response)
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Data")
        }
    }

    @GetMapping("/get_trade")
    fun getGraphData(@RequestBody tradeData: TradeData): List<TradeData> {
        return repository!!.findByCurrency(tradeData.currencyFrom, tradeData.currencyTo)
    }
}