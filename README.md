# API IMC
![GitHub](https://img.shields.io/github/license/oTalDoHud/ProjetoDashBoardVendas)

# Sobre o projeto

API IMC é uma aplicação web backend realizada em Java, utilizando o framework Spring.

A aplicação consiste em um web service, arquitetado no padrão MVC que recebe a altura, peso e gênero. Retornando o seu IMC e se você está ou não saudável e por último, registra esses dados no banco de dados PostgreSQL.

## Padrão MVC (Controllers, Services and repositories)
![MVC](https://github.com/oTalDoHud/API-IMC/blob/main/assets/Padrão_MVC.png) 

O projeto está arquitetado no padrão MVC, com responsabilidades divididas entre camada Rest, service e Repository.

## Requisições IMC - Consultas de IMC
Todas as requisições foram feitas pelo [Postman](https://web.postman.co "Site da DevSuperior"):
<br/>
![req](https://github.com/oTalDoHud/API-IMC/blob/main/assets/Req_possiveis/baixoPeso_Homem.png)

![req](https://github.com/oTalDoHud/API-IMC/blob/main/assets/Req_possiveis/Obesidade_mulher.png)

![req](https://github.com/oTalDoHud/API-IMC/blob/main/assets/Req_possiveis/Sobrepeso_Homem.png)

![req](https://github.com/oTalDoHud/API-IMC/blob/main/assets/Req_possiveis/Normal_Homem.png)

![req](https://github.com/oTalDoHud/API-IMC/blob/main/assets/Req_possiveis/Obesidade_grave_mulher.png)

![req](https://github.com/oTalDoHud/API-IMC/blob/main/assets/Req_possiveis/Obesidade_gravissima_mulher.png)]

## Requisições IMC - Consultas inválidas
### A requisição retorna o IMC e um aviso de como a pessoa está.
Todas as requisições foram feitas pelo [Postman](https://web.postman.co "Site da DevSuperior"):
<br/>
<br/>
![req](https://github.com/oTalDoHud/API-IMC/blob/main/assets/Req_Erro/menor_0.png)]

![req](https://github.com/oTalDoHud/API-IMC/blob/main/assets/Req_Erro/req_0.png)]

A API aceita apenas requisições positivas e diferentes de zero.
<br/>
<br/>

## Consultas ao banco de dados - Consultas por Id:

![req](https://github.com/oTalDoHud/API-IMC/blob/main/assets/Consulta/consulta_id_1.png)]

![req](https://github.com/oTalDoHud/API-IMC/blob/main/assets/Consulta/consulta_id_2.png)]
<br/>
<br/>

## Consultas ao banco de dados - Consultas paginadas:

![req](https://github.com/oTalDoHud/API-IMC/blob/main/assets/Consulta/consultaPaginada.png)]

A método "all" retorna apenas 10000 processos, mas é altamente não a utilizar

![req](https://github.com/oTalDoHud/API-IMC/blob/main/assets/Consulta/findAll-pag.png)]
<br/>
<br/>

# Tecnologias utilizadas
- Java
- Spring Boot
- JPA / Hibernate
- Rest
- Maven

## Implantação em produção
- Banco de dados: Postgresql
- Postman

# Como executar o projeto

## Back end
Pré-requisitos: Java 11, IDE Spring Boot

```bash
# clonar repositório
git clone https://github.com/oTalDoHud/API-IMC.git

# executar o projeto

```

# Autor

Hudson Lucas Teles Vieira

www.linkedin.com/in/otaldohud

hudson.lucas.vieira@gmail.com
