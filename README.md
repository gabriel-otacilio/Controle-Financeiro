# Controle-Financeiro
Vai ser um trabalho full stack que implemente uma API de controle financeiro 

Aqui documentarei o meu avanço no projeto 

## Dia 5/8 - Primeiro dia
    
Eu consegui criar a estrutura da API, criei com o Spring initializr, ainda estou um pouco perdido no que eu tenho que fazer para que a API funcione, mas hoje eu pretendo no minimo fazer a conexão com o meu banco e fazer uma classe de test

1) [x] Criar o meu conteiner de DB do projeto

2) [x] Adicionar os parametros pra fazer a conexão com o banco

3) [x] testar isso de alguma maneira
   4) [x] criar uma entidade pra ver se é cadastrada corretamente no banco ;
        - aqui eu encontro alguns pontos a serem estudados como o mapeamento de Objeto-Relacional do JPA/Hibernate;
        - Depois que tenho que criar a camada de repository dessa entidade;
        - Camada de Serviço da entidade, onde fica as regras de negocio;
        - Camada de Controller da entidade;
         

## dia 6/8 - Segundo dia

1) [x] Eu criei a entidade Transacao e agora pretendo criar a de usuario pra executar as funções de transacao; 
2) [x] Planejo tambem fazer a Controler de usuario pras aplicações da API 
   3) falta testar a API a unica rota que eu fiz.

## dia 7/8 - Terceiro dia
1) [x] criar os metodos de ususario e tipo de transacao
2) [x] criar os metodos de transacao

- Obstáculos 
   - no método de buscar transações por id eu to meio perdido em como o jpa faz a query, esse lance dele entender pelo o nome do metodo assinado na interface me confundi, acho que fiz bagunça com o nome do atributo
     - o tipo de dado em um atributo assin lado com uma flag de relacionamento entre tabelas tem que ser sempre o objeto da classe que representa a tabela relacionada.

## dia 11/8 - Quarto dia
1) terminei de criar os metodos e eles tambem estao funcionando via Postman ou via arquivo http aqui no intellij mesmo, Parece que a API esta funcional