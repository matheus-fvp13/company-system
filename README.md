# Company System

# About project

# Class diagram
```mermaid
classDiagram
    class Cargo {
        -id: Integer
        -name: String
    } 
    class Address {
        -id: Integer
        -uf: UF
        -city: String
        -street: String
        -number: String
    }
    class UF {
        <<enumeration>>
    }
    class Client {
        -id: Integer
        -name: String
        -cpf: String
        -phone: String
        -email: String
        -birthDate: LocalDate
        -address: Address
    }
    class Employee {
        -id: Integer
        -name: String
        -cpf: String
        -phone: String
        -email: String
        -birthDate: LocalDate
        -address: Address
        -hireDate: LocalDate
        -terminationDate: LocalDate
        -position: Cargo
    }
    class Project {
        -id: Integer
        -name: String
        -description: String
        -startDate: LocalDate
        -endDate: LocalDate
        -client: Client
        -leader: Employee
        -budget: BigDecimal
        -expenses: BigDecimal
        -team: List~Employee~
    }
    Employee "0..*"--"1" Cargo
    Address *-- UF
    Client "1"--"1" Address
    Employee "1"--"1" Address
    Project "n"--"1" Client
    Project "1..*"--"n" Employee
```

# Tools used

# How to execute the project

# Author
Matheus Fernando Vieira Pinto.

https://www.linkedin.com/in/matheus-fvp/