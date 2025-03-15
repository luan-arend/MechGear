# ⚙️ MechGear ⚙️

Projeto criado para solucionar um problema real de mecânicas.

## 🚀 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

## 🛠️ Construído com

Tecnologias utilizadas para o projeto:

* [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) - Linguagem Backend utilizada
* [Spring Boot](https://spring.io/projects/spring-boot) - Framework Backend Web utilizado
* [Maven](https://maven.apache.org/) - Gerente de Dependência
* [Postgres](https://www.postgresql.org/) - Banco de dados
* [Docker](https://docs.docker.com/desktop/) - Execução e manipulação do banco de dados

## 🔧 Instalação

Uma série de exemplos passo-a-passo que informam o que você deve executar para ter um ambiente de desenvolvimento em execução.

### 📌Docker - Para rodar o banco de dados Postgres da aplicação:
* Instalar Docker Desktop;
* Realizar o pull da imagem [Postgres](https://hub.docker.com/_/postgres) para Docker:
```
docker pull postgres
```
* Em seguida, rodar o comando para rodar o banco:
```
docker run -p 5432:5432 -e POSTGRES_PASSWORD=1234 -d postgres
```
Imagem estará baixada e rodando localmente via Docker 😊.

⌨️ com ❤️ por [Luan Arend](https://github.com/luan-arend) 😊
