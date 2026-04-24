# 💰 Wallet API
![Java](https://img.shields.io/badge/Java-8-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/SpringBoot-2.x-brightgreen?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?style=for-the-badge&logo=postgresql)
![JWT](https://img.shields.io/badge/Auth-JWT-black?style=for-the-badge&logo=jsonwebtokens)
![License](https://img.shields.io/badge/License-MIT-lightgrey?style=for-the-badge)

API de carteira digital (Wallet) desenvolvida com **Java 8 + Spring Boot**, simulando operações financeiras reais como criação de contas, transferências e controle de saldo.

---

## 📌 Sobre o Projeto

Este projeto foi desenvolvido com foco em **boas práticas de backend**, arquitetura limpa e separação de responsabilidades.

A Wallet API permite:
- Gerenciar usuários
- Criar carteiras digitais
- Realizar transferências entre contas
- Consultar saldo e histórico
- Garantir segurança com autenticação JWT

---

## 🚀 Tecnologias Utilizadas

- ☕ **Java 8**
- 🌱 **Spring Boot**
- 🔐 **Spring Security + JWT**
- 🐘 **PostgreSQL**
- 📦 **Maven**
- 📄 **Swagger / OpenAPI**
- 🧪 **JUnit (opcional)**

---

## 🏗️ Arquitetura do Projeto

wallet/
│
├── controller/ # Endpoints REST
├── service/ # Regras de negócio
├── repository/ # Comunicação com banco
├── entity/ # Entidades JPA
├── dto/ # Data Transfer Objects
├── config/ # Segurança, JWT, Swagger
├── exception/ # Tratamento global de erros
└── util/ # Classes utilitárias


---

## ⚙️ Configuração

### 🔧 Pré-requisitos

- Java 8+
- Maven
- PostgreSQL

---

### 🐘 Banco de Dados

Crie o banco:

```sql
CREATE DATABASE wallet;
