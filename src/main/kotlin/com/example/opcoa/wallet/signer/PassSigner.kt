package com.example.opcoa.wallet.signer

import software.amazon.awssdk.core.SdkBytes
import software.amazon.awssdk.services.kms.KmsClient
import software.amazon.awssdk.services.kms.model.MessageType
import software.amazon.awssdk.services.kms.model.SignRequest
import software.amazon.awssdk.services.kms.model.SigningAlgorithmSpec
import java.security.MessageDigest

/** Signs the manifest of a pass with a key of AWS KMS, which never leaves it. */
class PassSigner(private val kms: KmsClient, private val keyId: String) {
    fun sign(fields: PassFields): ByteArray {
        val manifest = fields.manifest().toByteArray()
        val digest = MessageDigest.getInstance("SHA-256").digest(manifest)
        val signature = kms.sign(
            SignRequest.builder()
                .keyId(keyId)
                .message(SdkBytes.fromByteArray(digest))
                .messageType(MessageType.DIGEST)
                .signingAlgorithm(SigningAlgorithmSpec.ECDSA_SHA_256)
                .build(),
        ).signature().asByteArray()
        return PassPackage(manifest, signature).zip()
    }
}
