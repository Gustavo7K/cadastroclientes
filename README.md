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

## Swagger:
Após executar o projeto o Swagger pode ser visualizado em " localhost:8080/swagger-ui.html "

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