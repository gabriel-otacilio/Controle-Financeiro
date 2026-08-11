# Mapeamento objeto-relacionamento do jpa/Hibernate

Num desenvolvimento que utiliza o Hibernate e o JPA as entidades devem ser mapeadas com notações, essas notações serao responsáveis por dizer ao hibernate qual campo é oque no seu banco de dados.
Existem tipos de mapeamento no Hibernate:   
1. Cada classe java marcada com a tag `@Entity`, vai representar uma tabela no DB;
2. A Ligação de atributos da classe serão as colunas da tabela e elas receberão o nome da coluna no DB, e terão a notação `@Column`;
3. Sobre os relacionamentos, a associação entre tabelas são traduzidas como `@ManyToOne`,`@OneToMany` e `@ManyToMany`;
   - Sobre de que lado ficam as especificações e as anotações, É SEMPRE NA TABELA QUE TEM O LADO MUITOS, então na relação Usuario-Transacao, vai existir uma coluna na tabela Transacao chamada usuario_id.
Essa tecnologia ajuda o 'descolamento' da camada da API pro banco, podendo mudar o banco sem alterar a camada de API.

Como exemplo teremos a classe Transacao.


# Camada de Repository
A camada de repossitory é como se fose uma ponte entre seu cosigo e o banco, o Spring fornece uma interface para a camada de repository,
E essa interface ja vem com alguns metodos padroes para manipular os dados. Eles são:
1. ``save(T entity)`` Salva um novo registro ou atualiza um existente.
2. ``findById(ID id)`` Busca um registro pelo id.
3. ``findAll()`` Busca todos os registros da tabela.
4. ``deleteById(ID id)`` Deleta um registro no Id informado.
5. ``count()`` Retorna a quantidade de registros da tabela.

Essa camada te permite tambem fazer querys personalizadas.
as anotações ``@Query``  é usado pra prescrever a consulta manualmente usando JPQL
como por exemplo 
````java
@Query("SELECT t FROM Transacao t WHERE t.valor > :valorMinimo AND t.tipo.nome = :nomeTipo")
List<Transacao> buscarTransacoesAltasPorTipo(Double valorMinimo, String nomeTipo);

// Exemplos de métodos que você pode apenas declarar dentro da interface:

// Gera: SELECT * FROM tb_transacao WHERE tipoTransacao_id = ?
List<Transacao> findByTipoId(Long tipoId);

// Gera: SELECT * FROM tb_transacao WHERE valor > ?
List<Transacao> findByValorGreaterThan(Double valor);

// Gera: SELECT * FROM tb_transacao WHERE data BETWEEN ? AND ?
List<Transacao> findByDataBetween(LocalDate inicio, LocalDate fim);

````
- Esses segundos metodos são automaticamente reconhecidos pelo Spring pelo o nome em ingles.
- Os métodos com as notações de relacionamento nao podem ter atributos de outro tipo senao a da entidade relacionada. 

# Camada de serviço
Nessa camada é onde vai ficar as regras de negocio e onde vamos injetar o repository pra fazer as manipulaçoes necessarias.
Os metodos de criação de novas entidades vao nessa camada, inclusive a da propria entidade.

# Controllers
Na Controllers é onde vamos expecificar oque vai fazer oque, e como fazer. Tambem existem mapeamenttos de rotas.
Alguns deles são: 
- Pra consumir as variaveis dinamicas da Url é so usar {} no endpoint e consumila como um parametro do metodo com a notaçao ``@PathVariable``
1) ``@GetMapping`` para GET
2) ``@PostMapping`` para POST
3) ``@PutMapping`` para PUT
4) ``@DeleteMapping`` para DELETE

