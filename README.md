# 🏋️ GymPulse

O **GymPulse** é um projeto de aplicação web voltada à organização de treinos e atividades físicas, desenvolvido com **Java e Spring Boot** e interface web com **HTML, CSS e Thymeleaf**.

## 🛠️ Tecnologias

- Java 21
- Spring Boot 4.1.1
- Maven
- Spring Web MVC
- Thymeleaf
- HTML e CSS

## ✅ Pré-requisitos

Antes de começar, instale:

1. **JDK 21** — confira com `java -version`.
2. **Git** — confira com `git --version`.
3. **Maven** — necessário caso o projeto não inclua o Maven Wrapper (`mvnw`/`mvnw.cmd`). Confira com `mvn -version`.

Você também pode usar uma IDE como IntelliJ IDEA, Eclipse ou VS Code com extensões Java.

## 📥 1. Baixar o projeto

Abra um terminal e execute:

```bash
git clone https://github.com/Mauromjr/GymPulse.git
cd GymPulse
```

Se você já baixou o projeto, basta abrir o terminal na pasta do GymPulse.

## ▶️ 2. Iniciar o projeto

Na raiz do projeto, onde está o arquivo `pom.xml`, execute:

**Windows (PowerShell)** — se existir `mvnw.cmd`:

```powershell
.\mvnw.cmd spring-boot:run
```

**Windows (PowerShell)** — com Maven instalado:

```powershell
mvn spring-boot:run
```

**Linux/macOS** — se existir `mvnw`:

```bash
./mvnw spring-boot:run
```

Na primeira execução, o Maven pode baixar as dependências e demorar alguns minutos.

## 🌐 3. Abrir no navegador

Com o servidor em execução, acesse:

**http://localhost:8080**

A porta padrão do Spring Boot é `8080`, desde que nenhuma outra porta tenha sido configurada. Se a página inicial não abrir ou aparecer erro 404, verifique se a aplicação possui um controlador ou uma rota para `/`.

Para interromper o servidor, pressione **Ctrl + C** no terminal.

## 🧪 4. Executar os testes

```powershell
mvn test
```

Se houver o Maven Wrapper no Windows, também é possível usar ` .\mvnw.cmd test `.

## 📦 5. Gerar o arquivo JAR

```powershell
mvn clean package
```

Após uma compilação bem-sucedida, o arquivo gerado ficará na pasta `target/`. A versão atualmente declarada no `pom.xml` é `0.0.1-SNAPSHOT`.

Para executá-lo (caso o empacotamento gere um JAR executável):

```powershell
java -jar target/gympulse-0.0.1-SNAPSHOT.jar
```

## 🗄️ Banco de dados

O `pom.xml` verificado não declara dependências de persistência, como Spring Data JPA, nem driver de banco de dados. O arquivo `application.properties` consultado contém apenas `spring.application.name=gympulse`.

Por isso, **não há uma etapa de instalação ou configuração de banco de dados confirmada** nesta documentação. Quando o armazenamento de treinos for implementado, esta seção deverá ser atualizada com o banco utilizado, as variáveis de ambiente e os comandos de configuração.

## ❗ Problemas comuns

| Problema | O que verificar |
|---|---|
| `java` não é reconhecido | Instale o JDK 21 e configure o `PATH` / `JAVA_HOME`. |
| `mvn` não é reconhecido | Instale o Maven ou use `mvnw.cmd` se existir. |
| Porta 8080 ocupada | Encerre a aplicação que está usando a porta ou configure outra porta no Spring Boot. |
| Erro 404 na página inicial | Verifique se existe uma rota para `/`. |
| Falha ao baixar dependências | Verifique a conexão com a internet e a mensagem de erro do Maven. |

## 📁 Repositório

Código-fonte: [Mauromjr/GymPulse](https://github.com/Mauromjr/GymPulse)

## 👨‍💻 Desenvolvimento

Projeto em desenvolvimento. Novas funcionalidades e instruções poderão ser adicionadas conforme a evolução da aplicação.
