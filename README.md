## Hibernate and JPA Project

This is a sample project showcasing how to use Hibernate and JPA (Java Persistence API) for data persistence in a Java application. In this project, we cover understanding the issues with JDBC and how JPA solves them, adding JPA to a Java application using Maven, configuring JPA via the `persistence.xml` file, mapping JPA entities and their relationships, understanding the JPA entity lifecycle, and performing queries using JPQL (Java Persistence Query Language).

## Table of Contents

- [Introduction](#introduction)
- [Configuration](#configuration)
- [Entity Mapping](#entity-mapping)
- [Entity Lifecycle](#entity-lifecycle)
- [Queries with JPQL](#queries-with-jpql)


## Introduction

In the world of Java database programming, JDBC (Java Database Connectivity) was a common way to interact with databases. However, JDBC had challenges such as repetitive code, security issues, and lack of portability. This is where JPA comes into play, a specification that defines how persistent entities should be managed in Java applications.

## Configuration

To add JPA to a Java application, we use Maven to manage dependencies. Dependencies for Hibernate and JPA are configured in the `pom.xml` file. JPA configuration is done through the `persistence.xml` file, where details of the persistence unit, data source, and other settings are defined.

## Entity Mapping

In this project, we map JPA entities to database tables. Through annotations such as `@Entity`, `@Table`, `@Column`, and others, we define how Java classes relate to tables in the database. We also explore mapping one-to-one, one-to-many, and many-to-many relationships between entities.

## Entity Lifecycle

JPA entities go through different states throughout their lifecycle. We explore how the `transient`, `managed`, `detached`, and `removed` states work. This allows us to understand how JPA automatically manages entities and how we can control their behavior.

## Queries with JPQL

JPQL (Java Persistence Query Language) is a query language similar to SQL but specific to JPA. Through examples, we learn how to perform queries on our entities using JPQL. This enables us to efficiently retrieve specific information from the database.
