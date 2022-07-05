# 

# Inventory Management Api Project - REST Api


This is a Inventory Management Api Project developed with spring-boot

# Information
This is a Inventory Management project.    

Note ::Maven clean install needs to be done before starting the project

### Technology Stack
Component         | Technology
---               | ---
Backend (REST)    | [SpringBoot](https://projects.spring.io/spring-boot) (Java 8)
In DB             | [Mysql](https://spring.io/guides/gs/accessing-data-mysql/)
Persistence       | JPA (Using Spring Data)
Server Build Tools| Maven(Java) or Spring Boot


### Accessing Application
Cpmponent         | URL                                      | Credentials
---               | ---                                      | ---
Frontend          |  http://localhost:8081                   | `testdb/testdb`



Requirements
- *Java 1.8
- *Maven 3.6.3
- Postman
- Query Dsl


Built With : mvn clean install or "InventoryManagementApp" class run


# The InventoryManagementApp APIs Services :
# Inventory Management Services :
### Accessing Application
Method            | Endpoints                | Credentials
---               | ---                      | ---
Get               |  /api/depot/getAll       |
Get               |  /api/depot/{id}         |
Get               |  /api/depot/delete/{id}  |
Post              |  /api/depot/add          |

# Product Services :
### Accessing Application
Method            | Endpoints                  | Credentials
---               | ---                        | ---
Get               |  /api/product/getAll       |
Get               |  /api/product/{id}         |
Get               |  /api/product/delete/{id}  |
Post              |  /api/product/add          |


# Stock Services :
### Accessing Application
Method            | Endpoints                | Credentials
---               | ---                      | ---
Get               |  /api/stock/getAll       |
Get               |  /api/stock/{id}         |
Get               |  /api/stock/delete/{id}  |
Post              |  /api/stock/add          |

# ProductsInDepotController Services :
### Accessing Application
Method            | Endpoints                | Credentials
---               | ---                      | ---
Get               |  /api/productsInDepot/getAll       |
Get               |  /api/productsInDepot/{id}         |
Get               |  /api/productsInDepot/delete/{id}  |
Post              |  /api/productsInDepot/add          |
Post              |  /api/productsInDepot/getProductsInDepotsByDto          |    productsInDepot search end point   
Post              |  /api/productsInDepot/productExtractionInDepotsByDto          | Product extraction end point


Product extraction 

Note : All must be full. Child records are important.
- /api/productsInDepot/productExtractionInDepotsByDto -> Extraction Services
```json
{
  "id": 1,                     -- *Required  Master must be registered
  "depot_id": 2,               -- *Required  Master must be registered
  "product_id": 1,             -- *Required  Master must be registered
  "quantity": 1                -- *Required  Master must be registered
}
```

Search Endpoint

Note : Querying can be done with the specified parameters. Both multiple and single parameters can be given.
- /api/productsInDepot/getProductsInDepotsByDto -> Extraction Services
```json
{
  "depot_id": 0,
  "product_id": 0,
  "category_id": 2,
  "quantity": 6,
  "region": "Batı karadeniz",
  "category_definition": "Ayakkabı",
  "depot_definition": "1.depo",
  "product_definition": "Kundura",
  "city": "Düzce"
}
```
return : ->Code 200 Successfully Extraction and Return Dto.


