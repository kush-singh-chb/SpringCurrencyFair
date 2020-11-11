package com.kushcurrencyfair.demo

import com.kushcurrencyfair.demo.controller.TradeDataController
import com.kushcurrencyfair.demo.model.TradeData
import com.kushcurrencyfair.demo.repository.TradeRepo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.HttpStatus

@ExtendWith(MockitoExtension::class)
class TradeControllerTest {

    @InjectMocks
    var tradeDataContoller:TradeDataController? = null

    @Test
    @Throws
    fun saveTradeTest() {
//        {"userId": "134257", "currencyFrom": "EUR", "currencyTo": "GBP",
//"amountSell": 1200, "amountBuy": 745.10, "rate": 0.7877,
//"timePlaced" : "25-JAN-18 11:48:45", "originatingCountry" : "FR"}
        val tradeData1 = TradeData()
        tradeData1.apply {
            this.userId = "134257"
            this.currencyFrom = "EUR"
            this.currencyTo = "GBP"
            this.amountSell = 1000.0f
            this.amountBuy = 747.10f
            this.rate = 0.7471f
            this.timePlaced = "24-JAN-18 10:27:44"
            this.originatingCountry = "FR"
        }
        val resp = tradeDataContoller?.newData(tradeData1)

        val tradeData2 = TradeData()
        tradeData2.apply {
            this.userId = "134257"
            this.currencyFrom = "EUR"
            this.currencyTo = "GBP"
            this.amountSell = 1000.0f
            this.amountBuy = 1000.10f
            this.rate = 0.7472f
            this.timePlaced = "24-JAN-18 10:27:44"
            this.originatingCountry = "FR"
        }
        val resp2 = tradeDataContoller?.newData(tradeData2)

        assert(HttpStatus.CREATED == resp?.statusCode)
        assert(HttpStatus.BAD_REQUEST == resp2?.statusCode)

    }
}