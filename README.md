# 📦 InventoryFlow 
### Projeto utilizando Spring Boot e Apache Kafka para enviar e consumir mensagens. A aplicação permite o envio de mensagens sobre pessoas e seus estoques de responsabilidades, que são então consumidas e persistidas no banco de dados.

<br>

## 🎥  Assista ao vídeo do projeto  
### Vídeo detalhado do projeto onde cada recurso é explicado e demonstrado em ação! Veja abaixo:



https://github.com/devDouglasN/InventoryFlow_Kafka/assets/122110326/58833aa4-9133-4f1b-9e99-77ee6761dc31




<br>

### ⚙️ Funcionalidades
- 📤 Envio de mensagens sobre pessoas e seus estoques
- 📥 Consumo e persistência de mensagens no banco de dados  

<br>

### 🛠️ Tecnologias Utilizadas
### Backend
| Tecnologia              | Versão  |  
|-------------------------|---------|  
| Java                    | 17      |
| Spring Boot             | 3.2.5   |  
| Spring Kafka            | 3.2.1   |  
| Spring Boot Data JPA    | 3.2.5   |
| H2 Database             | runtime |
| Lombok                  | 1.18.16 |
| Apache Avro             | 1.11.3  |
| Confluent Kafka Avro    | 7.6.0   |
 
<br>

### 📁 Estrutura do Projeto
springkafka/  
├── src/  
│ ├── main/  
│ │ ├── java/com/douglas/springkafka/  
│ │ │ ├── config/   
│ │ │ ├── consumer/  
│ │ │ ├── domain  
│ │ │ ├── dtos/  
│ │ │ ├── producer/  
│ │ │ ├── repository/  
│ │ │ ├── resource/  
│ │ │ ├── services/  
│ │ │ └── SpringkafkaApplication.java  
│ ├── resources/  
│ │ ├── application.properties  
├── .gitignore  
├── pom.xml  
├── README.md  

<br>

### 🚀 Pré-requisitos
- Java 17
- Maven
- Kafka

<br>

### 📥 Instalação   
Você pode clonar o repositório no seu terminal:
```
glot clone git@github.com:devDouglasN/InventoryFlow_Kafka.git
````
OU
[Baixar o ZIP do projeto](https://github.com/devDouglasN/InventoryFlow_Kafka/archive/refs/heads/main.zip) e abri-lo em uma IDE de sua preferência.

<br> 

### 📦 Instalando as dependências do projeto:
```
mvn clean install
````

<br>

### 🏃‍♂️ Rodando o Projeto
#### Ambiente de Desenvolvimento
Para iniciar a aplicação, execute:

```
mvn spring-boot:run
````
A aplicação estará disponível em http://localhost:8080.


<br>

### 🔗 Endpoints
#### Você pode utilizar o Insomnia, Postman ou qualquer outra ferramenta de sua preferência para realizar as requisições.  
#### Pessoas:
POST (Enviando mensagem para o consumidor)

http://localhost:8080/peoples  
Exemplo:

json
```
{
    "name": "Douglas Nascimento",
    "cpf": "652.510.300-29",
    "stocks": [
        "estoque: 2",
        "estoque 4", 
        "estoque 5",
        "estoque 6",
        "estoque 8",
        "estoque  11"
    ]
}   
````

<br>

### 🏗️ Estrutura do Projeto
Módulos   
- config: Configurações do Kafka e Spring.
- consumer: Classe consumidora do Kafka.
- domain: Entidades JPA.
- dtos: Data Transfer Objects.
- producer: Classe produtora do Kafka.
- repository: Repositórios JPA.
- resource: Controladores REST.
- services: Serviços de negócios.

<br>
<br>

Developed by [Douglas do Nascimento](https://github.com/devDouglasN).
