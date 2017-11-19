# Virtual Markets

Virtual Markets provides a set of coordinating services that represents various entities in capital markets.This application is a proof of concept to model markets as set of services.These services coordinate to execute various
trades and update positions.Test update

# Rationale
Capital Markets represents a set of services that coordinate with each other to provide the following functionalities:
* Sale and purchase of Financial Instruments like Stocks, Bonds etc.
* Post Trade settlement entities like Clearinghouse, Depository etc.
* Reference Data services
* Billing services
*

## Steps to deploy and run the markets


### Technologies used

All code is build using the following languages:
 1. Java 8, Go, Python
 2. Spring Boot 2.0 (using reactive Technologies)
 3. dockerized services
 4. deployable on linux machines, cloud foundry, aws, zaure etc.
 5. graphql based rest end points
 6. Vert.x support
 7. blockchain (??) support during trade settlement and matching
 8. Terraform for Infrastructure as code (deploy to aws)
 9. Kubernetes for container orchestration
 9. Supporting different data stores like mysql, mongodb, cassandra etc.
