# Swagger

Como o swagger funciona num projeto java com Spring:
Você adiciona a dependência no projeto. no caso desse meu é no maven. A versão deve ser escolhida conforme a versão do Spring.

Depois disso o Swagger já reconhece os seus 
``@RestController, @GetMapping, @PostMapping, @PutMapping, @DeleteMapping`` e gera a especificação OpenAPI.

Ao entrar na url da sua aplicação na url ``/swagger-ui/index.html`` ele vai abrir para você a documentação.

Se quiser uma anotação da openAPI amais em algum endpoint, basta usar a notação ``@Operation(corpo)``, onde esse corpo pode ter campos como: ``summary = "Consulta todos os usuários",
    description = "Retorna a lista de usuários cadastrados no sistema"``, desse modo fica mais amigavel a transarencia no swagger

Deixando claro que o swagger nao substitui o Postman, tendo em vista que o swagger é pra entender melhor os endpoints e o Postman é pra testar as aplicações


ordem pra estudar as funcionalidades do OpenAPI
1) Swagger automatico
2) @Operation
3) @Parameter
4) @APIResponse
5) @Schema
6) Exemplos
7) Autenticação

# Postman

Junto com o swagger uma outra tecnologia a aprender é o Postman nele alem de gerar os testes de endpoint, é possivel vc codar testes pr uma determinada rota.
Disparar as requisições no postman junto com o uso de variaveis de ambiente. é fácil, agora codar os testes em JS e entender o fluxo do OAuth2 é mais complicado.

- Testes
    - Pra codificação de testes a parte onde vc vai codar eles, é na aba ``scripts -> post-response`` embaixo da url;
    - O Postman usa a biblioteca ``pm.test``; 
    - Aqui vai alguns exemplos de testes:
    - EX:
      - validar status code:
        ````js
        pm.test("Status deve ser 200 OK", function () {
            pm.response.to.have.status(200);
        });
        ````
      - validar conteudo da resposta(JSON):
        ````js
        pm.test("o nome do usuario deve ser fulano", function () {
            var jsonData = pm.response.json();
            pm.expect(jsonData.nome).to.eql("fulano");

        })
        ````
      - validar o tempo da resposta:
      ````js
      pm.test("tempo de reposta em menos de 5 minutos", function () {
            pm.expect(pm.response.responseTime).to.be.below(500);        
        })
      ````