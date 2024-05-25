# Native Api gateway with Spring Api Gateway

## Getting Started

### Native build commands:

* ./mvnw spring-boot:build-image -Pnative
* ./mvnw native:compile -Pnative

### Start on windows
```shell
./smart_scrum_poker_backend_native.exe --spring.profiles.active=native --server.port=1234 --server.ssl.key-store=classpath:keystore/dev.p12 --server.ssl.key-store-password=password
```

### Usage
```shell
curl http://localhost:8080/get
```
