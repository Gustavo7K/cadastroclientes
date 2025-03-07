<h1 align="center">
  API Cadastro de Usuarios
</h1>

### API para criar e autenticar usuarios usando Spring Security

## Práticas adotadas no projeto:
- [API REST](https://www.ibm.com/br-pt/topics/rest-apis)
- Injeção de Dependências
- Consultas com Spring Data JPA
- Autenticação de usuarios por [token](https://www.totvs.com/blog/gestao-para-assinatura-de-documentos/jwt-token/)
- Criptografia de senhas inseridas no cadastro
- Tratamento de respostas de erros
- Geração automática do Swagger utilizando a [OpenAPI 3](https://www.ibm.com/docs/pt-br/app-connect/13.0?topic=apis-openapi-30)

## Tecnologias utilizadas no projeto:
- Java 21
- Spring Boot 3.4.2
- Spring Data JPA
- Spring Security
- SpringDoc OpenAPI 3
- Spring MVC
- Open SSL
- Postman para as requisições HTTP
- PostgreSQL

## Como rodar o projeto usando o Swagger:
- Instalação : O projeto é gerenciado pelo Maven, então para usa-lo basta importa-lo para uma IDE.

- Configurar o banco de dados: Foi utilizado o banco de dados PostgreSQL (recomendado ao instalar o projeto)
porém a API pode ser adaptavel ao banco de dados de sua preferência, entretanto é necessario adequar o projeto 
de acordo com as suas configurações. Para isso abra o arquivo application.properties, localizado em 
cadastrocliente/src/main/resources/application.properties e altere os comandos de datasource, username e password.

- Executando o projeto: Execute o projeto na sua IDE, abra um navegador e coloque: " localhost:8080/swagger-ui.html "
fazendo isso agora você pode acessar a interface do Swagger e utilizar os métodos de requisição da API.

## Endpoints da API
Após a requisição "POST" a api irá retornar a lista de usuarios completa (implementação feita somente para testes).
Um detalhe importante o primeiro usuario foi inserido por meio do "data.sql" para ser possivel utilizar a API.
Abaixo exemplos das requisições HTTP que podem ser feitas após inserir usuario e senha corretamente na requisição:

- Método POST para criar um usuario:
```
POST http://localhost:8080/register

  {
    "usuario": "usuarioSeguro",
    "email": "gustavoSeguro@gmail.com",
    "senha": "senhaSuperSegura"
  }
```
- Método POST para autenticar o usuario criado:
```
POST http://localhost:8080/authenticate

  Basic Auth: 
  Usuario = usuarioSeguro
  Password = senhaSuperSegura
  
  "Sera gerado o token de autenticação do usuario e exibido no corpo da requisição"
```
- Método GET para entrar no controlador privado:
```
GET http://localhost:8080/private

  Basic Auth: 
  Usuario = usuarioSeguro
  Password = senhaSuperSegura
```
- Método DELETE para remover um usuario pelo id:
```
DELETE http://localhost:8080/bc8c4cb1-b315-4ed9-9afb-0ab74d8c8g35

  Basic Auth: 
  Usuario = usuarioSeguro
  Password = senhaSuperSegura
```