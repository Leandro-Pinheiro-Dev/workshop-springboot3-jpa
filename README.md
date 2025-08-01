
````markdown
# 📦 Web Services com Spring Boot, JPA e Hibernate

Este projeto tem como objetivo o desenvolvimento de uma **API RESTful completa**
utilizando as principais tecnologias do ecossistema **Java com Spring**,
voltada para estudos, prática e aplicação de conceitos sólidos de desenvolvimento backend moderno.

A aplicação simula um sistema de pedidos de e-commerce (loja virtual),
com funcionalidades como cadastro de usuários, produtos, categorias, pedidos, pagamentos, entre outros.
Tudo foi estruturado com base em boas práticas de **arquitetura em camadas**, **tratamento global de exceções**, **persistência com JPA e Hibernate**,
**autenticação via JWT**, além de opções de **execução com banco em memória (H2)** e **deploy em nuvem com PostgreSQL e Docker**.

Este projeto foi construído com fins **educacionais e profissionais**,
servindo como base para quem deseja dominar o desenvolvimento de **serviços RESTful com Spring Boot** e aplicar conhecimentos em:

- Modelagem de domínio com entidades JPA
- Relacionamentos entre tabelas (OneToMany, ManyToMany, etc.)
- Padrão de repositórios com Spring Data JPA
- Tratamento de erros com Exception Handlers personalizados
- Versionamento de ambientes (test, dev e prod)
- Integração com banco H2 e PostgreSQL
- Deploy em ambiente real com **Heroku** ou via **Docker**
- Autenticação e autorização com **JWT**
- Testes unitários com JUnit

---

## 🔧 Ferramentas e Tecnologias Utilizadas

- ✅ **Java 17** — linguagem principal da aplicação  
- ✅ **Spring Boot 3** — para facilitar a criação e configuração do projeto  
- ✅ **Spring Data JPA** — para acesso a dados com ORM (Hibernate)  
- ✅ **Hibernate** — implementação JPA para mapeamento objeto-relacional  
- ✅ **Banco de dados H2** — usado em ambiente de teste e desenvolvimento local  
- ✅ **PostgreSQL** — banco de dados utilizado para produção e deploy  
- ✅ **Maven** — gerenciador de dependências e build da aplicação  
- ✅ **Postman** — para testes das requisições REST (CRUD e autenticação)  
- ✅ **Docker** — para empacotamento e execução da aplicação em containers  
- ✅ **Heroku** — plataforma de nuvem para deploy de aplicações Java  (deploy opcional) necessario cartão de credito
- ✅ **JUnit + Spring Boot Test** — para testes automatizados de serviços  

---

## ✅ Etapas de Desenvolvimento

Cada etapa foi versionada no GitHub com commits descritivos. Veja os principais marcos:

- User entity and resource  
- H2 database, test profile, JPA  
- JPA repository, database seeding  
- Service layer registration  
- Order, Instant, ISO 8601  
- OrderStatus enum  
- Category, Product, relacionamento many-to-many  
- OrderItem, relacionamento composto com atributos extras  
- Subtotal & Total methods  
- Payment, one-to-one  
- User insert, delete, update  
- Exception handling - findById, delete, update  

---

## 🧪 Execução Local

1. Clone o repositório:  
   ```bash
   git clone https://github.com/Leandro-Pinheiro-Dev/workshop-springboot3-jpa.git
   cd workshop-springboot3-jpa
````

2. Execute com Maven:

   ```bash
   ./mvnw spring-boot:run
   ```

3. Acesse o console H2:

   ```
   http://localhost:8080/h2-console  
   JDBC URL: jdbc:h2:mem:testdb
   ```
<img width="479" height="397" alt="Image" src="https://github.com/user-attachments/assets/80980e73-656b-4555-b5e7-fe989658096b" />

apos logar:

<img width="842" height="458" alt="Image" src="https://github.com/user-attachments/assets/f88f7ac2-5098-409b-b1ed-8cb3f2b8f9dc" />

4. Teste via Postman (exemplos):

   * GET /users
   * POST /users
   * PUT /users/{id}
   * DELETE /users/{id}
   * 
<img width="893" height="585" alt="Image" src="https://github.com/user-attachments/assets/88c7d9e4-77a2-4747-8fdd-0a6608596180" />
---

## 🛠️ Rodando com Docker (opcional)

1. Crie um arquivo **Dockerfile** na raiz com o conteúdo:

   ```dockerfile
   FROM openjdk:17-jdk-slim
   COPY target/*.jar app.jar
   ENTRYPOINT ["java", "-jar", "/app.jar"]
   ```

2. Build da imagem:

   ```bash
   docker build -t springboot-api .
   ```

3. Run da imagem:

   ```bash
   docker run -p 8080:8080 springboot-api
   ```

---

## ✨ Deploy no Heroku (opcional)

1. Criar app no Heroku

2. Provisionar PostgreSQL

3. Configurar `application-prod.properties`

4. Enviar variáveis de ambiente:

   ```
   DATABASE_URL, JWT_SECRET, JWT_EXPIRATION
   ```

5. Deploy:

   ```bash
   heroku git:remote -a nome-do-app
   git add .
   git commit -m "Deploy Heroku"
   git push heroku main
   ```

---

## ⚠️ Tratamento de Exceções

A aplicação usa manipuladores globais para lidar com erros:

* ResourceNotFoundException
* DatabaseException
* ResourceExceptionHandler

Essas classes retornam mensagens padronizadas em casos como: ID inexistente, conflitos de chave estrangeira ou requisições inválidas.

---

## 🔐 Autenticação JWT

O projeto suporta autenticação baseada em token JWT com configurações:

```properties
jwt.secret=MYJWTSECRET
jwt.expiration=3600000
```

As variáveis são utilizadas para proteger rotas e autenticar usuários.

---

## 🧪 Testes Automatizados

Inclua testes com JUnit no diretório `src/test/java`. Exemplo:

```java
@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService service;

    @Test
    void shouldFindUserById() {
        User user = service.findById(1L);
        assertNotNull(user);
    }
}
```

Execute os testes com:

```bash
./mvnw test
```

---

## 🧩 Diagramas

As imagens dos diagramas estão na pasta `docs/images` (ou informe a pasta onde você colocou). Para visualizá-las, veja abaixo:

### Domain Instance

<img width="977" height="521" alt="Image" src="https://github.com/user-attachments/assets/0b912afc-afb4-4214-ae03-9b031dd2537f" />

### Domain Model

<img width="930" height="431" alt="Image" src="https://github.com/user-attachments/assets/49ef7b2e-aa48-4255-b0ef-97e4cc95a7c3" />

### Logical Layers

<img width="841" height="570" alt="Image" src="https://github.com/user-attachments/assets/2a5ce568-a393-481f-8a59-5a0e23e56dbf" />


## 📜 Licença

Distribuído sob a licença MIT. Veja o arquivo LICENSE para mais informações.

---

## 📊 Status do Projeto

Todas as funcionalidades do backend estão implementadas com tratamento de exceções robusto, autenticação e lógica de negócio separada em camadas. Pronto para integração com frontend React ou Angular.



