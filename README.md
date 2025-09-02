# Meu Projeto Spring Boot

Um sistema de gerenciamento desenvolvido em Spring Boot para controle de diferentes tipos de pessoas (físicas e jurídicas) incluindo alunos, professores e fornecedores.

## 📋 Descrição

Este projeto é uma aplicação web desenvolvida com Spring Boot que permite o gerenciamento de:
- **Pessoas Físicas**: Cadastro e controle de indivíduos
- **Pessoas Jurídicas**: Cadastro e controle de empresas
- **Alunos**: Sistema específico para estudantes com matrícula e curso
- **Professores**: Controle de docentes
- **Fornecedores**: Gestão de fornecedores

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

## 🌐 Endpoints Disponíveis

### Páginas Web (Thymeleaf)
- `GET /` - Página inicial
- `GET /aluno` - Página de alunos
- `GET /professor` - Página de professores
- `GET /fornecedor` - Página de fornecedores
- `GET /pessoa-fisica` - Página de pessoas físicas
- `GET /pessoa-juridica` - Página de pessoas jurídicas

### API REST
- `GET /api` - Informações da API
- Controllers específicos para cada entidade (Aluno, Professor, etc.)

## 🗄️ Banco de Dados

### Acesso ao Console H2
1. Acesse: http://localhost:9000/h2-console
2. Configure:
   - **JDBC URL**: `jdbc:h2:mem:testdb`
   - **User Name**: `sa`
   - **Password**: (deixe em branco)
3. Clique em "Connect"

### Estrutura das Entidades

#### Aluno
- ID, Nome, CPF, RG
- Data de Nascimento, Email, Telefone, Endereço
- Matrícula, Curso, Data de Matrícula

#### Professor
- Informações pessoais básicas
- Dados específicos de docente

#### Fornecedor
- Dados de empresa/pessoa jurídica
- Informações de contato

#### Pessoa Física/Jurídica
- Estruturas base para herança de outras entidades

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

- [ ] Implementar validações nos models
- [ ] Adicionar testes unitários
- [ ] Implementar repositories JPA
- [ ] Adicionar sistema de autenticação
- [ ] Migrar para banco de dados persistente
- [ ] Implementar paginação nas listagens
- [ ] Adicionar documentação da API (Swagger)

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
