## Stack Technique

- Java 17
- Spring Boot 2.7.3
- Spring Data JPA
- Spring Data REST
- Spring GraphQL
- H2 Database (in-memory)
- SpringDoc OpenAPI (Swagger UI)

## Configuration

| Property | Value |
|----------|-------|
| Port | 8081 |
| Database | H2 in-memory (accountdb) |
| GraphiQL | Enabled |

## Démarrage

```bash
mvn spring-boot:run
```

## URLs de Test

| URL | Description |
|-----|-------------|
| http://localhost:8081/swagger-ui.html | Swagger UI |
| http://localhost:8081/h2-console | H2 Console (JDBC URL: jdbc:h2:mem:accountdb) |
| http://localhost:8081/bankAccounts | Spring Data REST API |
| http://localhost:8081/api/bankAccounts | Custom REST API |
| http://localhost:8081/graphiql | GraphiQL Interface |
| http://localhost:8081/graphql | GraphQL Endpoint |

## Structure du Projet

```
bank-service/
├── pom.xml
├── src/main/
│   ├── java/ma/mundia/bankservice/
│   │   ├── BankServiceApplication.java
│   │   ├── dtos/
│   │   │   ├── BankAccountRequestDTO.java
│   │   │   └── BankAccountResponseDTO.java
│   │   ├── entities/
│   │   │   ├── BankAccount.java
│   │   │   └── Customer.java
│   │   ├── enums/
│   │   │   └── AccountType.java
│   │   ├── exceptions/
│   │   │   └── CustomExceptionResolver.java
│   │   ├── mappers/
│   │   │   └── AccountMapper.java
│   │   ├── projections/
│   │   │   └── AccountProjection.java
│   │   ├── repositories/
│   │   │   ├── BankAccountRepository.java
│   │   │   └── CustomerRepository.java
│   │   ├── services/
│   │   │   ├── AccountService.java
│   │   │   └── AccountServiceImpl.java
│   │   └── web/
│   │       ├── AccountRestController.java
│   │       └── BankAccountGraphQLController.java
│   └── resources/
│       ├── application.properties
│       └── graphql/
│           └── schema.graphqls
```

## API REST Endpoints

| Méthode | URI | Description |
|---------|-----|-------------|
| GET | /api/bankAccounts | Liste tous les comptes |
| GET | /api/bankAccounts/{id} | Récupère un compte par ID |
| POST | /api/bankAccounts | Crée un nouveau compte |
| PUT | /api/bankAccounts/{id} | Met à jour un compte |
| DELETE | /api/bankAccounts/{id} | Supprime un compte |

## GraphQL Queries

```graphql
# Liste tous les comptes
query {
    accountList {
        id
        balance
        currency
        type
        customer {
            name
        }
    }
}

# Récupère un compte par ID
query {
    accountById(id: "uuid") {
        id
        balance
        currency
        type
    }
}

# Liste tous les clients
query {
    customers {
        id
        name
        bankAccounts {
            id
            balance
        }
    }
}
```

## GraphQL Mutations

```graphql
# Créer un compte
mutation {
    addAccount(bankAccount: {
        balance: 5000.0
        currency: "MAD"
        type: "CURRENT_ACCOUNT"
    }) {
        id
        balance
        currency
        type
    }
}

# Mettre à jour un compte
mutation {
    updateAccount(id: "uuid", bankAccount: {
        balance: 10000.0
    }) {
        id
        balance
    }
}

# Supprimer un compte
mutation {
    deleteAccount(id: "uuid")
}
```
