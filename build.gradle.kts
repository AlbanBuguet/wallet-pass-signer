plugins {
    kotlin("jvm") version "2.1.0"
    application
}

dependencies {
    implementation("software.amazon.awssdk:kms:2.29.0")
    implementation("io.ktor:ktor-server-netty:3.0.2")
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("com.example.opcoa.wallet.signer.MainKt")
}
