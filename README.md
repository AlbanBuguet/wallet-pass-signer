# wallet-pass-signer

Signs the boarding passes of the trip wallet for Apple Wallet and Google Wallet. The keys live in AWS KMS and never leave it: the service signs with `kms:Sign`.

## Run it

```sh
./gradlew run
```

## Test it

```sh
./gradlew test
```
