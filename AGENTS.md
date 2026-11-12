# wallet-pass-signer

How coding agents work in wallet-pass-signer.

- Build: `./gradlew build`
- Test: `./gradlew test`
- Keys stay in AWS KMS: never read, export or log key material (ADR-0001 of wallet-api).
- A new field of the pass goes in `PassFields.kt`, with its test.
