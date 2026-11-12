package com.example.opcoa.wallet.signer

/** The fields of a boarding pass, as wallet-api sends them. */
data class PassFields(
    val booking: String,
    val passenger: String,
    val flight: String,
    val seat: String,
    val gate: String?,
    val boarding: String,
    val group: String,
    val assetsUrl: String = "https://opco-a-trip-wallet-prod-pass-assets.s3.eu-west-1.amazonaws.com",
) {
    fun manifest(): String = buildString {
        append("{\"flight\":\"").append(flight).append("\",")
        append("\"seat\":\"").append(seat).append("\",")
        append("\"gate\":\"").append(gate ?: "").append("\",")
        append("\"boarding\":\"").append(boarding).append("\",")
        append("\"logo\":\"").append(assetsUrl).append("/logo.png\"}")
    }
}
