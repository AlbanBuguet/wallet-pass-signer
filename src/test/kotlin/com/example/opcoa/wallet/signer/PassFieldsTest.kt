package com.example.opcoa.wallet.signer

import kotlin.test.Test
import kotlin.test.assertContains

class PassFieldsTest {
    @Test
    fun manifestHoldsTheGate() {
        val f = PassFields("ABC123", "A. Traveller", "OA123", "12A", "B12", "08:50", "2")
        assertContains(f.manifest(), "\"gate\":\"B12\"")
    }
}
