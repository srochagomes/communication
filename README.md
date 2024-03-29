# communication

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running mvnw
use mvn wrapper:wrapper

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/communication-1.0.0-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- Camel AMQP ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/amqp.html)): Messaging with AMQP protocol using Apache QPid Client
- Camel Core ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/core.html)): Camel core functionality and basic Camel languages: Constant, ExchangeProperty, Header, Ref, Simple and Tokenize
- Camel Kotlin ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/kotlin.html)): Write Camel integration routes in Kotlin
- Camel String Template ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/stringtemplate.html)): Transform messages using StringTemplate engine
- Camel Kotlin DSL ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/kotlin-dsl.html)): Support for parsing Kotlin route definitions at runtime
- Kotlin ([guide](https://quarkus.io/guides/kotlin)): Write your services in Kotlin


## Email example

{
    "type": "EMAIL",
    "createAt": "2023-09-15T13:30:00",
    "specification": {
        "domainType": "ACCOUNT_CONFIRMATION",
        "accountId": "c6450c9b-b79e-4c3c-a394-1e5fc12b245f",
        "detail": {
            "emailTo": "dsdsds@gmail.com",
            "nameTo": "Usuário Exemplo",
            "subject": "Bem-vindo ao nosso serviço!",
            "urlConfirmation": "https://www.example.com/confirm"
        }
    }
}
