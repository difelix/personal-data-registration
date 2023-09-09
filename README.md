# APIs de cadastro de clientes

### Para executar o projeto

* necessário ter docker instalado
* executar comando abaixo:
 ~~~ 
    docker-compose -f docker/docker-compose-local.yml up
 ~~~

### Para acessar o swagger

* acessar URL http://localhost:8080/swagger-ui/index.html com a documentação de todas as APIs 
disponíveis no projeto.

### Para rodar testes integrados

* necessário rodar pelo menos uma vez o comando mvn test-compile para gerar lib do SQLite4 (exigido para subir dynamo-db local)