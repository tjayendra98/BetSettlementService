# BET SETTLEMENT SERVICE

A backend application that will simulate sports betting event outcome handling and bet settlement via Kafka and **Mocked RocketMQ**.

---

## Requirements
- Java 17
- Maven 3.9.6
- Kafka 4.1.0

---

## Prerequisites
- Ensure that the Kafka topic **'event-outcomes'** already exists if your Kafka broker property is auto.create.topics.enable=false.
  - If auto.create.topics.enable=true, the topic will be created automatically on first use
  - You can create the topic manually with:
    ```shell
    kafka-topics.sh --create --topic event-outcomes --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
    ```
- Create some sample records in bet table through [H2Console](http://localhost:8085/h2-console)    
  - The following table shows preloaded sample bets inserted into the system at startup:

| `betId` | `userId` | `eventId` | `eventMarketId` | `eventWinnerId` | `betAmount` |
|--------:|----------|-----------|------------------|------------------|------------:|
| 1       | user1    | cricket1  | market1          | RCB              | 100         |
| 2       | user2    | cricket1  | market1          | RCB              | 200         |
| 3       | user3    | cricket1  | market1          | CSK              | 150         |
| 4       | user4    | cricket1  | market1          | CSK              | 150         |
| 5       | user5    | cricket1  | market1          | RCB              | 250         |

  - You may create bet record using the cURL
  ```shell
curl --location 'http://localhost:8085/bet' --header 'Content-Type: application/json' --data '{"userId":"User7","eventId":"Football","eventMarketId":"Market1","eventWinnerId":"Team123","betAmount":500}'
  ```



---

### Build the Project

mvn clean install

---

### Run the Project

mvn spring-boot:run

---

## Configuration

- This application uses an embedded H2 database by default.
  - **Default Credentials**
    - **Username:** sa
    - **Password:** (empty string)
- Other application properties such as Kafka host, Kafka topic, RocketMQ topic, Application port, JPA and H2 config, are defined in application.yml file in resources folder.    

#### API endpoint to publish a sports event outcome:
```shell
curl --location 'localhost:8085/event/publish' \
--header 'Content-Type: application/json' \
--data '{
  "eventId": "cricket1",
  "eventName": "Cricket",
  "eventWinnerId": "CSK"
}'
```
#### **NOTE:** This service uses mocks for the RocketMQ producer and consumer. 