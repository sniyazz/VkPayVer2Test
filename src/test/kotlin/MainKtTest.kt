import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun transferVkNoLimit() {
        val moneyTransfer: Int = 140000
        val paymentMethod: String = "VKPay"
        var summTranfers = priviewTrasfers + moneyTransfer

        val result = transfer(paymentMethod, moneyTransfer, summTranfers)
        assertEquals(5, result)
    }

    @Test
    fun transferVkLimit() {
        val moneyTransfer: Int = 1600000
        val paymentMethod: String = "VKPay"
        var summTranfers = priviewTrasfers + moneyTransfer

        val result = transfer(paymentMethod, moneyTransfer, summTranfers)
        assertEquals(-1, result)
    }

    @Test
    fun transferVisaAndMirNonLimit() {
        val moneyTransfer: Int = 1600000
        val paymentMethod: String = "visaAndMir" // VKPay, visaAndMir, mastercardAndMaestro
        val priviewTrasfers: Int = 0
        var summTranfers = priviewTrasfers + moneyTransfer

        val result = transfer(paymentMethod, moneyTransfer, summTranfers)
        assertEquals(120000.0, result)
    }
    @Test
    fun transferVisaAndMirLimit() {
        val moneyTransfer: Int = 1600000000
        val paymentMethod: String = "visaAndMir" // VKPay, visaAndMir, mastercardAndMaestro
        val priviewTrasfers: Int = 0
        var summTranfers = priviewTrasfers + moneyTransfer

        val result = transfer(paymentMethod, moneyTransfer, summTranfers)
        assertEquals(-1, result)
    }
    @Test
    fun transferMastercardAndMaestroNonLimit() {
        val moneyTransfer: Int = 1600000
        val paymentMethod: String = "mastercardAndMaestro" // VKPay, visaAndMir, mastercardAndMaestro
        var summTranfers = priviewTrasfers + moneyTransfer

        val result = transfer(paymentMethod, moneyTransfer, summTranfers)
        assertEquals(0, result)
    }
    @Test
    fun transferMastercardAndMaestroLimit() {
        val moneyTransfer: Int = 1600000000
        val paymentMethod: String = "mastercardAndMaestro" // VKPay, visaAndMir, mastercardAndMaestro
        val priviewTrasfers: Int = 0
        var summTranfers = priviewTrasfers + moneyTransfer

        val result = transfer(paymentMethod, moneyTransfer, summTranfers)
        assertEquals(-1, result)
    }
    @Test
    fun transferMastercardAndMaestroComissionLimit() {
        val moneyTransfer: Int = 8000000

        val paymentMethod: String = "mastercardAndMaestro" // VKPay, visaAndMir, mastercardAndMaestro
        val priviewTrasfers: Int = 0
        var summTranfers = priviewTrasfers + moneyTransfer

        val result = transfer(paymentMethod, moneyTransfer, summTranfers)
        assertEquals(482000.0, result)
    }
    @Test
    fun transferMastercardAndMaestroComissionNonLimit() {
        val moneyTransfer: Int = 7400000
        val previewTransfers: Int = 0
        val paymentMethod: String = "mastercardAndMaestro" // VKPay, visaAndMir, mastercardAndMaestro
        val priviewTrasfers: Int = 0
        var summTranfers = priviewTrasfers + moneyTransfer

        val result = transfer(paymentMethod, moneyTransfer, summTranfers)
        assertEquals(0, result)
    }
    @Test
    fun transferErrorName() {
        val moneyTransfer: Int = 8000000
        val paymentMethod: String = "ErrorName" // VKPay, visaAndMir, mastercardAndMaestro
        val priviewTrasfers: Int = 0
        var summTranfers = priviewTrasfers + moneyTransfer

        val result = transfer(paymentMethod, moneyTransfer, summTranfers)
        assertEquals(-2, result)
    }
}