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
SERVER_ENV=DEV;SERVER_PORT=9998;SERVER_SOCKER_FULL_HOST=wss://localhost:9999/ws;SERVER_SSL_ENABLED=true;SERVER_SSL_KEY_STORE=classpath:keystore/dev.p12;SERVER_SSL_KEY_STORE_PASSWORD=password;SITE_DOMAIN=not.yet;SITE_FRONTEND_HOST=https://localhost:4200;SOCKET_IS_ENABLED_SOCKET_CONNECT_AND_DISCONNECT_LISTENERS=true;SPRING_DATASOURCE_HIKARI_MAXIMUM_POOL_SIZE=10;SPRING_DATASOURCE_HIKARI_MINIMUM_IDLE=10;SPRING_DATASOURCE_PASSWORD=admin_pass;SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:46030/smartscrumpoker;SPRING_DATASOURCE_USERNAME=admin
```

### Native build commands:

#### Create docker image

```shell
./mvnw spring-boot:build-image -Pnative
````

#### Create native runnable application

```shell
./mvnw clean native:compile -Pnative -Dspring.datasource.url=jdbc:postgresql://localhost:46030/smartscrumpoker -Dspring.datasource.username=admin -Dspring.datasource.password=admin_pass -Dsocket.is-enabled-s ocket-connect-and-disconnect-listeners=false
```

### Start native runnable application on windows

```shell
./smart_scrum_poker_backend_native.exe --spring.profiles.active=native --server.port=1234 --server.ssl.key-store=classpath:keystore/dev.p12 --server.ssl.key-store-password=password --spring.d
atasource.url=jdbc:postgresql://localhost:46030/smartscrumpoker --spring.datasource.username=admin --spring.datasource.password=admin_pass --spring.datasource.driver-class-name=org.postgresql.D
river --spring.datasource.hikari.maximum-pool-size=5 --spring.datasource.hikari.minimum-idle=5
```
