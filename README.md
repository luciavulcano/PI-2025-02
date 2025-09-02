# Sistema de Gerenciamento Acadêmico e Empresarial

Sistema completo de gerenciamento desenvolvido em Spring Boot para controle de pessoas físicas, jurídicas, acadêmicas e fornecedores com interface web e API REST.

## 📋 Descrição Detalhada

Este é um **sistema de gestão integrado** que oferece controle completo de diferentes tipos de entidades através de uma aplicação web moderna com Spring Boot. O sistema foi projetado para atender instituições educacionais e empresas que precisam gerenciar:

### 🎓 **Módulo Acadêmico**
- **Alunos**: Gestão completa de estudantes com dados pessoais, matrícula e informações acadêmicas
- **Professores**: Controle de docentes com especialidades, titulações e informações salariais

### 🏢 **Módulo Empresarial**
- **Fornecedores**: Gestão de empresas parceiras com controle de serviços e contatos
- **Pessoas Jurídicas**: Cadastro completo de empresas com dados fiscais

### 👥 **Módulo de Pessoas**
- **Pessoas Físicas**: Controle básico de indivíduos com documentação completa

## 🗃️ Modelos de Dados

### 📚 **Aluno**
```java
- ID único
- Dados Pessoais: Nome, CPF, RG, Data Nascimento
- Contato: Email, Telefone, Endereço
- Acadêmico: Matrícula, Curso, Data Matrícula
```

### 👨‍🏫 **Professor**
```java
- ID único
- Dados Pessoais: Nome, CPF
- Contato: Email, Telefone, Endereço
- Profissional: Especialidade, Titulação, Salário
```

### 🏭 **Fornecedor**
```java
- ID único
- Empresa: Razão Social, Nome Fantasia, CNPJ
- Contato: Email, Telefone, Endereço
- Negócio: Tipo Serviço, Pessoa Contato
```

### 👤 **Pessoa Física**
```java
- ID único
- Dados Pessoais: Nome, CPF, RG, Data Nascimento
- Contato: Email, Telefone, Endereço
```

### 🏢 **Pessoa Jurídica**
```java
- ID único
- Empresa: Razão Social, Nome Fantasia, CNPJ
- Fiscal: Inscrição Estadual
- Contato: Email, Telefone, Endereço
```

## 🚀 Funcionalidades

### 📱 **Interface Web (Thymeleaf)**
- Páginas dedicadas para cada tipo de entidade
- Interface responsiva e moderna
- Formulários de cadastro e edição

### 🔌 **API REST Completa**
- **CRUD Completo**: Create, Read, Update, Delete para todas entidades
- **Endpoints RESTful**: Seguindo padrões REST
- **Respostas JSON**: Formato padronizado para integração
- **Validação**: Controle de dados de entrada

### 💾 **Armazenamento em Memória**
- **Listas dinâmicas**: Dados mantidos em ArrayList
- **IDs automáticos**: Geração sequencial de identificadores
- **Persistência de sessão**: Dados mantidos durante execução

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.3.5**
- **Spring Web** - Para criação de APIs REST e controllers
- **Spring Data JPA** - Para persistência de dados
- **Thymeleaf** - Template engine para renderização de páginas
- **H2 Database** - Banco de dados em memória para desenvolvimento
- **Spring Boot DevTools** - Para hot reload durante desenvolvimento
- **Gradle** - Gerenciador de dependências e build

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── spring/
│   │           ├── MeuProjetoSpringApplication.java  # Classe principal
│   │           ├── controller/                       # Controllers REST
│   │           │   ├── AlunoController.java
│   │           │   ├── FornecedorController.java
│   │           │   ├── HomeController.java
│   │           │   ├── PessoaFisicaController.java
│   │           │   ├── PessoaJuridicaController.java
│   │           │   ├── ProfessorController.java
│   │           │   └── ViewController.java
│   │           └── model/                            # Entidades/Models
│   │               ├── Aluno.java
│   │               ├── Fornecedor.java
│   │               ├── PessoaFisica.java
│   │               ├── PessoaJuridica.java
│   │               └── Professor.java
│   └── resources/
│       ├── application.properties                    # Configurações
│       ├── static/                                   # Arquivos estáticos
│       └── templates/                                # Templates Thymeleaf
│           ├── aluno.html
│           ├── fornecedor.html
│           ├── index.html
│           ├── pessoa-fisica.html
│           ├── pessoa-juridica.html
│           └── professor.html
```

## ⚙️ Configuração

### Pré-requisitos

- Java 21 ou superior
- Gradle (incluído via wrapper)

### Configurações do Banco de Dados

O projeto utiliza H2 Database em memória para desenvolvimento:
- **URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: (vazio)
- **Console H2**: Disponível em `/h2-console`

### Configurações da Aplicação

- **Porta padrão**: 9000
- **Profile ativo**: default
- **JPA DDL**: create-drop (recria tabelas a cada inicialização)
- **Show SQL**: habilitado para debug

## 🔧 Como Executar

### 1. Clone o repositório
```bash
git clone [url-do-repositorio]
cd PI-2025-02
```

### 2. Execute a aplicação
```bash
./gradlew bootRun
```

### 3. Acesse a aplicação
- **Aplicação**: http://localhost:9000
- **Console H2**: http://localhost:9000/h2-console
- **API Info**: http://localhost:9000/api

### 4. Para parar a aplicação
Pressione `Ctrl + C` no terminal onde a aplicação está rodando.

## 🌐 Endpoints da API

### 🎓 **Alunos** (`/api/aluno`)
- `GET /api/aluno` - Listar todos os alunos
- `GET /api/aluno/{id}` - Buscar aluno por ID
- `POST /api/aluno` - Criar/Atualizar aluno
- `DELETE /api/aluno/{id}` - Remover aluno

### 👨‍🏫 **Professores** (`/api/professor`)
- `GET /api/professor` - Listar todos os professores
- `GET /api/professor/{id}` - Buscar professor por ID
- `POST /api/professor` - Criar/Atualizar professor
- `DELETE /api/professor/{id}` - Remover professor

### 🏭 **Fornecedores** (`/api/fornecedor`)
- `GET /api/fornecedor` - Listar todos os fornecedores
- `GET /api/fornecedor/{id}` - Buscar fornecedor por ID
- `POST /api/fornecedor` - Criar/Atualizar fornecedor
- `DELETE /api/fornecedor/{id}` - Remover fornecedor

### 👤 **Pessoas Físicas** (`/api/pessoa-fisica`)
- `GET /api/pessoa-fisica` - Listar todas as pessoas físicas
- `GET /api/pessoa-fisica/{id}` - Buscar pessoa física por ID
- `POST /api/pessoa-fisica` - Criar/Atualizar pessoa física
- `DELETE /api/pessoa-fisica/{id}` - Remover pessoa física

### 🏢 **Pessoas Jurídicas** (`/api/pessoa-juridica`)
- `GET /api/pessoa-juridica` - Listar todas as pessoas jurídicas
- `GET /api/pessoa-juridica/{id}` - Buscar pessoa jurídica por ID
- `POST /api/pessoa-juridica` - Criar/Atualizar pessoa jurídica
- `DELETE /api/pessoa-juridica/{id}` - Remover pessoa jurídica

### 📄 **Páginas Web (Thymeleaf)**
- `GET /` - Página inicial do sistema
- `GET /aluno` - Interface de gestão de alunos
- `GET /professor` - Interface de gestão de professores
- `GET /fornecedor` - Interface de gestão de fornecedores
- `GET /pessoa-fisica` - Interface de gestão de pessoas físicas
- `GET /pessoa-juridica` - Interface de gestão de pessoas jurídicas
- `GET /api` - Informações da API

## 💡 Exemplos de Uso da API

### Criar um Aluno
```bash
curl -X POST http://localhost:9000/api/aluno \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "cpf": "123.456.789-00",
    "email": "joao@email.com",
    "matricula": "2025001",
    "curso": "Engenharia de Software"
  }'
```

### Listar Professores
```bash
curl http://localhost:9000/api/professor
```

### Buscar Fornecedor por ID
```bash
curl http://localhost:9000/api/fornecedor/1
```

## 🗄️ Banco de Dados

### Acesso ao Console H2
1. Acesse: http://localhost:9000/h2-console
2. Configure:
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **User Name**: `sa`
   - **Password**: (deixe em branco)
3. Clique em "Connect"

### Estrutura das Entidades

#### 🎓 **Aluno** - Gestão Acadêmica Completa
- **Identificação**: ID único, Nome, CPF, RG
- **Dados Pessoais**: Data de Nascimento
- **Contato**: Email, Telefone, Endereço
- **Acadêmico**: Matrícula única, Curso, Data de Matrícula

#### 👨‍🏫 **Professor** - Controle Docente
- **Identificação**: ID único, Nome, CPF
- **Contato**: Email, Telefone, Endereço
- **Profissional**: Especialidade, Titulação Acadêmica
- **Financeiro**: Salário (BigDecimal para precisão)

#### 🏭 **Fornecedor** - Gestão de Parceiros
- **Identificação**: ID único, CNPJ
- **Empresa**: Razão Social, Nome Fantasia
- **Contato**: Email, Telefone, Endereço
- **Negócio**: Tipo de Serviço, Pessoa de Contato

#### 👤 **Pessoa Física** - Cadastro Individual
- **Identificação**: ID único, Nome, CPF, RG
- **Pessoal**: Data de Nascimento
- **Contato**: Email, Telefone, Endereço

#### 🏢 **Pessoa Jurídica** - Cadastro Empresarial
- **Identificação**: ID único, CNPJ
- **Empresa**: Razão Social, Nome Fantasia
- **Fiscal**: Inscrição Estadual
- **Contato**: Email, Telefone, Endereço

## 🛠️ Comandos Úteis

### Build do projeto
```bash
./gradlew build
```

### Executar testes
```bash
./gradlew test
```

### Limpar build
```bash
./gradlew clean
```

### Build sem testes
```bash
./gradlew build -x test
```

## 📝 Logs e Debug

O projeto está configurado para exibir:
- Consultas SQL no console (show-sql=true)
- Logs de debug do Spring Boot
- Hot reload automático com DevTools

## 🔄 Hot Reload

O projeto inclui Spring Boot DevTools, que permite:
- Reinicialização automática quando arquivos são alterados
- LiveReload do browser (porta 35729)
- Propriedades de desenvolvimento otimizadas

## 📋 TODO / Melhorias Futuras

### 🔧 **Melhorias Técnicas**
- [ ] **Persistência**: Migrar de listas em memória para JPA/Hibernate
- [ ] **Validações**: Implementar Bean Validation (@Valid, @NotNull, etc.)
- [ ] **Repositories**: Criar interfaces JPA Repository para cada entidade
- [ ] **Services**: Implementar camada de serviços para lógica de negócio
- [ ] **Exception Handling**: Sistema global de tratamento de erros
- [ ] **Logging**: Implementar logs estruturados com Logback

### 🧪 **Testes e Qualidade**
- [ ] **Testes Unitários**: JUnit 5 + Mockito para controllers e services
- [ ] **Testes de Integração**: TestContainers para testes com banco
- [ ] **Cobertura**: Jacoco para análise de cobertura de código
- [ ] **Testes de API**: RestAssured para testes de endpoints

### 🔐 **Segurança e Autenticação**
- [ ] **Spring Security**: Implementar autenticação e autorização
- [ ] **JWT**: Tokens para autenticação de API
- [ ] **Roles**: Sistema de perfis (Admin, Professor, Aluno)
- [ ] **CORS**: Configuração para chamadas cross-origin

### 🎨 **Interface e UX**
- [ ] **Frontend Moderno**: React ou Vue.js para SPA
- [ ] **Bootstrap/Tailwind**: Framework CSS para UI responsiva
- [ ] **Paginação**: Sistema de paginação para grandes listas
- [ ] **Filtros**: Busca e filtros avançados
- [ ] **Upload**: Sistema de upload de arquivos/fotos

### 📊 **Funcionalidades Avançadas**
- [ ] **Relatórios**: Geração de PDF/Excel com JasperReports
- [ ] **Dashboard**: Painel com estatísticas e gráficos
- [ ] **Notificações**: Sistema de emails automáticos
- [ ] **Auditoria**: Log de alterações com Spring Data Envers
- [ ] **Cache**: Redis para cache de consultas frequentes

### 🛠️ **DevOps e Produção**
- [ ] **Docker**: Containerização da aplicação
- [ ] **CI/CD**: Pipeline com GitHub Actions
- [ ] **Monitoring**: Actuator + Micrometer para métricas
- [ ] **Documentation**: Swagger/OpenAPI para documentação automática
- [ ] **Database**: PostgreSQL ou MySQL para produção

### 📱 **Integrações**
- [ ] **API Externa**: Consulta CEP automática
- [ ] **Email Service**: SendGrid ou Amazon SES
- [ ] **Storage**: Amazon S3 para arquivos
- [ ] **Mensageria**: RabbitMQ ou Apache Kafka

## 🤝 Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## 👨‍💻 Autor

Desenvolvido como projeto de estudos em Spring Boot.

---

**Última atualização**: 2 de setembro de 2025
