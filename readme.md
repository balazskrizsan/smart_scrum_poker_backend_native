# Smart Scrum Poker - Native Java backend

## No more "Are 8 hours equivalent to 3 points" on planning

## Stack

| Technology  | Version    |
|-------------|------------|
| Java        | 21         |
| Runtime     | GraalVM 21 |
| Spring Boot | 3.3        |
| Maven       | 3.9        |
| JOOQ        | 3.2.3      |

# Dev setup

### IDEA setup

#### Env vars:

```
SERVER_ENV=DEV;SERVER_PORT=9998;SERVER_SOCKET_FULL_HOST=wss://localhost:9999/ws;SERVER_SSL_ENABLED=true;SERVER_SSL_KEY_STORE=classpath:keystore/dev.p12;SERVER_SSL_KEY_STORE_PASSWORD=password;SITE_DOMAIN=not.yet;SITE_FRONTEND_HOST=https://localhost:4200;SOCKET_IS_ENABLED_SOCKET_CONNECT_AND_DISCONNECT_LISTENERS=true;SPRING_DATASOURCE_HIKARI_MAXIMUM_POOL_SIZE=10;SPRING_DATASOURCE_HIKARI_MINIMUM_IDLE=10;SPRING_DATASOURCE_PASSWORD=admin_pass;SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:46030/smartscrumpoker;SPRING_DATASOURCE_USERNAME=admin;NATIVE_REFLECTION_CONFIGURATION_GENERATOR_ENABLED=true
```

### Native build commands:

#### Create docker image

```shell
./mvnw spring-boot:build-image -Pnative
````

#### Run tests

```shell
./mvnw clean package -Pnative -Dspring.profiles.active=native -Dserver.port=9999 -Dserver.socket.full.host=wss://localhost:9999/ws -Dserver.ssl.enabled=true -Dserver.ssl.key-store=classpath:keystore/dev.p12 -Dserver.ssl.key-store-password=password -Dspring.datasource.url=jdbc:postgresql://localhost:46040/smartscrumpoker -Dspring.datasource.username=admin -Dspring.datasource.password=admin_pass -Dsocket.is-enabled-socket-connect-and-disconnect-listeners=false -Dspring.datasource.driver-class-name=org.postgresql.Driver -Dspring.datasource.hikari.maximum-pool-size=5 -Dspring.datasource.hikari.minimum-idle=5 -Dsocket.is-enabled-socket-connect-and-disconnect-listener=true
```

#### Create native runnable application

```shell
./mvnw clean native:compile -Pnative -Dspring.profiles.active=native -Dserver.port=46011 -Dserver.socket.full.host=wss://localhost:46011/ws -Dserver.ssl.enabled=true -Dserver.ssl.key-store=classpath:keystore/dev.p12 -Dserver.ssl.key-store-password=password -Dspring.datasource.url=jdbc:postgresql://localhost:47050/smartscrumpoker -Dspring.datasource.username=admin -Dspring.datasource.password=admin_pass -Dsocket.is-enabled-socket-connect-and-disconnect-listeners=false -Dspring.datasource.driver-class-name=org.postgresql.Driver -Dspring.datasource.hikari.maximum-pool-size=5 -Dspring.datasource.hikari.minimum-idle=5 -Dsocket.is-enabled-socket-connect-and-disconnect-listener=true -Dnative.reflection-configuration-generator.enabled=true -Dsocket.message-broker-stats-logging-period-seconds=1000
```

#### Create native runnable application - NO test run

```shell
$ ./mvnw clean native:compile -Pnative -DskipTests -Dspring.profiles.active=native -Dserver.port=46011 -Dserver.socket.full.host=wss://localhost:46011/ws -Ds erver.ssl.enabled=true -Dserver.ssl.key-store=classpath:keystore/dev.p12 -Dserver.ssl.key-store-password=password -Dspring.datasource.url=jdbc:postgresql://l ocalhost:47050/smartscrumpoker -Dspring.datasource.username=admin -Dspring.datasource.password=admin_pass -Dsocket.is-enabled-socket-connect-and-disconnect-l isteners=false -Dspring.datasource.driver-class-name=org.postgresql.Driver -Dspring.datasource.hikari.maximum-pool-size=5 -Dspring.datasource.hikari.minimum- idle=5 -Dsocket.is-enabled-socket-connect-and-disconnect-listener=true -Dnative.reflection-configuration-generator.enabled=true -Dsocket.message-broker-stats -logging-period-seconds=1000 -Dlogback.logstash.enabled=false -Dlogback.logstash.full_host=""
```

### Start native runnable application on windows

```shell
 $ ./target/smart_scrum_poker_backend_native.exe --spring.profiles.active=native --server.port=46021 -Dserver.socket.full.host=wss://localhost:46021/ws --serv er.ssl.key-store=classpath:keystore/dev.p12 --server.ssl.key-store-password=password --spring.datasource.url=jdbc:postgresql://localhost:47040/smartscrumpoke r --spring.datasource.username=admin --spring.datasource.password=admin_pass --spring.datasource.driver-class-name=org.postgresql.Driver --spring.datasource. hikari.maximum-pool-size=5 --spring.datasource.hikari.minimum-idle=5 --native.reflection-configuration-generator.enabled=false -Dsocket.message-broker-stats- logging-period-seconds=1 --logback.logstash.enabled=true --logback.logstash.full_host=localhost:5044
 ```
