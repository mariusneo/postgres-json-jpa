spring-data-jpa usage of Postgres JSONB fields
===============================================================

This simple project can be used as PoC in storing generically data in JSONB fields.
In a scenario where profession specific information would be stored in joined tables, with the help of JSONB fields 
in Postgres we can store all the information in one table and avoid the table joins needed to retrieve all the
required information about a person.

What this PoC brings new is that specific entities :

- Student
- Professor 

can be handled in a type-safe manner :

- Student class has a StudentInfo field
- Professor class has a ProfessorInfo field

On the other hand, if some batch processes need to deal with all the persons, this can be done with the help of
CommonPerson class (and associated CommonPersonRepository).


The table containing the persons (generated here by Hibernate) looks like this :

```sql

CREATE TABLE person
(
  dtype character varying(31) NOT NULL,
  id bigint NOT NULL,
  email character varying(255),
  info jsonb,
  CONSTRAINT person_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
```



## Similar projects 

- https://github.com/brant-hwang/springboot-postgresql94-hibernate5-example.git
- https://github.com/sasa7812/psql-cache-evict-POC.git



## Environment requirements
- Java 8
- Spring Boot 1.3.2.RELEASE
- Hibernate 5.0.2
- PostgreSQL 9.4
- Maven 3